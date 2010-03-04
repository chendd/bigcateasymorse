package com.video.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.dao.CollectionVideoDao;
import com.video.dao.IndexRecommendVideoDao;
import com.video.dao.MayLikeVideoDao;
import com.video.dao.PlaybillDao;
import com.video.dao.UploadVideoDao;
import com.video.dao.UserDao;
import com.video.dao.VideoChannelDao;
import com.video.dao.VideoDao;
import com.video.domain.BrowseHistoryVideo;
import com.video.domain.CollectionVideo;
import com.video.domain.IndexRecommendVideo;
import com.video.domain.MayLikeVideo;
import com.video.domain.Playbill;
import com.video.domain.PointHistory;
import com.video.domain.UploadVideo;
import com.video.domain.User;
import com.video.domain.Video;
import com.video.domain.VideoChannel;
import com.video.domain.connection.ChannelCount;
import com.video.domain.connection.Condition;
import com.video.util.Pagination;

public class VideoServiceImpl implements VideoService {

	private VideoDao videoDao;
	private IndexRecommendVideoDao indexRecommendVideoDao;
	private MayLikeVideoDao mayLikeVideoDao;
	private CollectionVideoDao collectionVideoDao;
	private VideoChannelDao videoChannelDao;
	private PlaybillDao playbillDao;
	private UserDao userDao;
	private UploadVideoDao uploadVideoDao;

	public UploadVideoDao getUploadVideoDao() {
		return uploadVideoDao;
	}

	public void setUploadVideoDao(UploadVideoDao uploadVideoDao) {
		this.uploadVideoDao = uploadVideoDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public PlaybillDao getPlaybillDao() {
		return playbillDao;
	}

	public void setPlaybillDao(PlaybillDao playbillDao) {
		this.playbillDao = playbillDao;
	}

	public MayLikeVideoDao getMayLikeVideoDao() {
		return mayLikeVideoDao;
	}

	public void setMayLikeVideoDao(MayLikeVideoDao mayLikeVideoDao) {
		this.mayLikeVideoDao = mayLikeVideoDao;
	}

	public IndexRecommendVideoDao getIndexRecommendVideoDao() {
		return indexRecommendVideoDao;
	}

	public void setIndexRecommendVideoDao(
			IndexRecommendVideoDao indexRecommendVideoDao) {
		this.indexRecommendVideoDao = indexRecommendVideoDao;
	}

	public VideoDao getVideoDao() {
		return videoDao;
	}

	public void setVideoDao(VideoDao videoDao) {
		this.videoDao = videoDao;
	}

	public List<IndexRecommendVideo> getIndexRecommendVideoes()
			throws DataAccessException {
		return this.indexRecommendVideoDao.getIndexRecommendVideoes();
	}

	public List<MayLikeVideo> getMayLikeVideoes() throws DataAccessException {

		return this.mayLikeVideoDao.getMayLikeVideoes();
	}

	public void getPlayBills(Pagination<Playbill> pagination)
			throws DataAccessException {

		this.playbillDao.getPlaybills(pagination);
	}

	public void getVideoByTagId(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoDao.getVideoByTagId(pagination);
	}

	public void getVideoes(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoDao.getVideoes(pagination);

	}

	public void getVideoBykey(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoDao.getVideoByKey(pagination);
	}

	public void getVideoByPlaybill(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoDao.getVideoByPlaybill(pagination);
	}

	public void getVideo(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoDao.getVideo(pagination);
	}

	public void getVideoByCommend(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoDao.getVideoByCommend(pagination);
	}

	public void getBrowseHistoryByUserId(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoDao.getBrowseHistoryByUserId(pagination);
	}

	public void getMyCommentVideo(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoDao.getMyCommentVideo(pagination);
	}

	public Video getVideoById(Long id, User user) throws DataAccessException {
		Video video = this.videoDao.getVideoById(id);
		// if (user == null) {
		// user = userDao.getUserById(0L);
		// }
		if (user != null && video != null) {
			BrowseHistoryVideo browseHistoryVideo = new BrowseHistoryVideo();
			browseHistoryVideo.setUser(user);
			browseHistoryVideo.setVideo(video);
			browseHistoryVideo.setAddDate(new Date());
			int count = this.videoDao
					.getBrowseHistoryCountByUIdAndVId(browseHistoryVideo);
			if (count > 0) {
				this.videoDao.updateBrowseHistory(browseHistoryVideo);
			} else {
				this.videoDao.createBrowseHistory(browseHistoryVideo);
			}
		}
		if (video != null) {
			video.setBrowseCount(video.getBrowseCount() + 1);
			this.videoDao.updateVideo(video);
		}
		return video;
	}

	public Video getInitVideo(Long id) throws DataAccessException {
		return this.videoDao.getVideoById(id);
	}

	public CollectionVideoDao getCollectionVideoDao() {
		return collectionVideoDao;
	}

	public void setCollectionVideoDao(CollectionVideoDao collectionVideoDao) {
		this.collectionVideoDao = collectionVideoDao;
	}

	public void createCollection(CollectionVideo collectionVideo)
			throws DataAccessException {
		CollectionVideo collection = this.collectionVideoDao
				.getCollection(collectionVideo);
		if (collection == null) {// 是否已经收藏
			this.collectionVideoDao.createCollectionVideo(collectionVideo);
		}
	}

	public void updateVideo(Video video) throws DataAccessException {
		this.videoDao.updateVideo(video);
	}

	public List<VideoChannel> getVideoChannelList() throws DataAccessException {

		return this.videoChannelDao.getVideoChannelList();
	}

	public VideoChannelDao getVideoChannelDao() {
		return videoChannelDao;
	}

	public void setVideoChannelDao(VideoChannelDao videoChannelDao) {
		this.videoChannelDao = videoChannelDao;
	}

	public void createVideo(Video video) throws DataAccessException {
		this.videoDao.createVideo(video);

	}

	public void createUploadVideo(UploadVideo uploadVideo)
			throws DataAccessException {
		this.uploadVideoDao.createUploadVideo(uploadVideo);

	}

	public void updateUploadVideoStatus(UploadVideo uploadVideo)
			throws DataAccessException {
		this.uploadVideoDao.updateUploadVideoStatus(uploadVideo);
	}

	public Video getVideo(Long id) throws DataAccessException {
		return this.videoDao.getVideoById(id);
	}


	public boolean pointVideo(PointHistory pointHistory)
			throws DataAccessException {
		boolean flag = false;
		if (pointHistory != null) {
			PointHistory history = this.videoDao.getPointHistory(pointHistory);
			Video video = this.videoDao.getVideoById(pointHistory.getVideoId());
			if (history == null) {
				this.videoDao.createPointHistory(pointHistory);
				video.setPoint(video.getPoint() + pointHistory.getPoint());
				this.videoDao.updateVideo(video);
				flag = true;
			} else {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
				if (!dateFormat.format(history.getAddDate()).equals(
						dateFormat.format(pointHistory.getAddDate()))) {
					this.videoDao.updatePointHistory(pointHistory);
					video.setPoint(video.getPoint() + pointHistory.getPoint());
					this.videoDao.updateVideo(video);
					flag = true;
				}
			}
		}
		return flag;
	}


	public void getBrowseHistoryByGroupId(Pagination<Video> pagination)
			throws DataAccessException {
		this.videoDao.getBrowseHistoryByGroupId(pagination);
		
	}

	public void updateUploadVideoLength(UploadVideo uploadVideo)
			throws DataAccessException {
		this.uploadVideoDao.updateUploadVideoLength(uploadVideo);
		
	}

	public List<Video> getPlaybillVideoList(Long id) throws DataAccessException {
		return this.videoDao.getPlaybillVideoList(id);
	}

	public ChannelCount getChannelTop(Long id)
	throws DataAccessException{
		return this.videoDao.getChannelTop(id);
	}

	public List<Video> getVideoRand(Condition condition) throws DataAccessException {
		return this.videoDao.getVideoRand(condition);
	}

	public List<Long> getPlayHistoryVideoIds(Long id)
			throws DataAccessException {
		
		return this.videoDao.getPlayHistoryVideoIds(id);
	}

}
