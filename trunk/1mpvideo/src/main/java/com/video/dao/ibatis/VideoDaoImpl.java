package com.video.dao.ibatis;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.sun.accessibility.internal.resources.accessibility;
import com.video.dao.VideoDao;
import com.video.domain.BrowseHistoryVideo;
import com.video.domain.PointHistory;
import com.video.domain.Video;
import com.video.domain.connection.ChannelCount;
import com.video.domain.connection.Condition;
import com.video.domain.connection.VideoAndTag;
import com.video.util.Pagination;

public class VideoDaoImpl extends SqlMapClientDaoSupport implements VideoDao {

	public void createVideo(Video video) throws DataAccessException {
		getSqlMapClientTemplate().insert("createVideo", video);
	}

	public void deleteVideo(Long id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public Video getVideoById(Long id) throws DataAccessException {
		return (Video) getSqlMapClientTemplate().queryForObject("getVideoById",
				id);

	}
	@SuppressWarnings("unchecked")
	public void getVideoes(Pagination<Video> pagination)
			throws DataAccessException {

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countVideoes", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {

			List<Video> list;

			list = getSqlMapClientTemplate().queryForList("getVideoes",
					pagination);

			pagination.setResults(list);
		}
	}

	public void updateVideo(Video video) throws DataAccessException {
		getSqlMapClientTemplate().update("updateVideo", video);
	}

	public void updateVideoByVideoChannelId(Video video)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateVideoByVideoChannelId", video);

	}

	public void deleteVideoByChannelId(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteVideoByChannelId", id);

	}

	public void updateVideoWithChannelByVideoChannelId(Video video)
			throws DataAccessException {
		getSqlMapClientTemplate().update(
				"updateVideoWithChannelByVideoChannelId", video);
	}
	@SuppressWarnings("unchecked")
	public void getVideoByTagId(Pagination<Video> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countVideoByTagId", pagination);
		pagination.setRecordSum(count);
		if (count > 0) {
			List<Video> list;
			list = getSqlMapClientTemplate().queryForList("getVideoByTagId",
					pagination);
			pagination.setResults(list);
		}
	}
	@SuppressWarnings("unchecked")
	public void getVideoByKey(Pagination<Video> pagination)
			throws DataAccessException {
		if (pagination.getCondition() != null) {
			Video video = (Video) pagination.getCondition();
			if (video.getDescription() != null
					&& !video.getDescription().isEmpty()) {
				video.setDescription(MessageFormat.format("%{0}%", video
						.getDescription().replaceAll("%", "!%").replaceAll("!",
								"!!")));
			}
			if (video.getName() != null && !video.getName().isEmpty()) {
				video.setName(MessageFormat.format("%{0}%", video.getName()
						.replaceAll("%", "!%").replaceAll("!", "!!")));
			}
		}

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countVideoByKey", pagination);
		pagination.setRecordSum(count);
		if (count > 0) {
			List<Video> list;
			list = getSqlMapClientTemplate().queryForList("getVideoByKey",
					pagination);
			pagination.setResults(list);
		}
	}
	@SuppressWarnings("unchecked")
	public void getVideoesByGroupId(Pagination<Video> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countVideoesByGroupId", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {

			List<Video> list;

			list = getSqlMapClientTemplate().queryForList(
					"getVideoesByGroupId", pagination);

			pagination.setResults(list);
		}

	}
	@SuppressWarnings("unchecked")
	public void getVideoByPlaybill(Pagination<Video> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countVideoByPlaybill", pagination);
		System.out.println(count);
		pagination.setRecordSum(count);
		if (count > 0) {
			List<Video> list;
			list = getSqlMapClientTemplate().queryForList("getVideoByPlaybill",
					pagination);
			pagination.setResults(list);
		}
	}
	@SuppressWarnings("unchecked")
	public void getVideo(Pagination<Video> pagination)
			throws DataAccessException {

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countVideoes", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {

			List<Video> list;

			list = getSqlMapClientTemplate().queryForList("getVideoIndex",
					pagination);

			pagination.setResults(list);
		}
	}
	@SuppressWarnings("unchecked")
	public void getVideoByCommend(Pagination<Video> pagination)
			throws DataAccessException {

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countVideoByCommend", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {

			List<Video> list;

			list = getSqlMapClientTemplate().queryForList(
					"getVideoIndexByCommend", pagination);

			pagination.setResults(list);
		}
	}
	@SuppressWarnings("unchecked")
	public void getBrowseHistoryByUserId(Pagination<Video> pagination)
			throws DataAccessException {

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countBrowseHistoryByUserId", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {

			List<Video> list;

			list = getSqlMapClientTemplate().queryForList(
					"getBrowseHistoryByUserId", pagination);

			pagination.setResults(list);
		}
	}
	@SuppressWarnings("unchecked")
	public void getMyCommentVideo(Pagination<Video> pagination)
			throws DataAccessException {

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countMyCommentVideo", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {

			List<Video> list;

			list = getSqlMapClientTemplate().queryForList("getMyCommentVideo",
					pagination);

			pagination.setResults(list);
		}
	}

	public void createBrowseHistory(BrowseHistoryVideo browseHistoryVideo)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createBrowseHistory",
				browseHistoryVideo);
	}

	public int getBrowseHistoryCountByUIdAndVId(
			BrowseHistoryVideo browseHistoryVideo) throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"getBrowseHistoryCountByUIdAndVId", browseHistoryVideo);
		return count;
	}

	public void updateBrowseHistory(BrowseHistoryVideo browseHistoryVideo)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateBrowseHistory",
				browseHistoryVideo);
	}

	public void updateVideoFlag(Video video) throws DataAccessException {
		getSqlMapClientTemplate().update("updateVideoFlag", video);

	}

	public void createVideoAndTag(VideoAndTag videoAndTag)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createVideoAndTag", videoAndTag);

	}

	public VideoAndTag getVideoAndTag(VideoAndTag videoAndTag)
			throws DataAccessException {
		return (VideoAndTag) getSqlMapClientTemplate().queryForObject(
				"getVideoAndTag", videoAndTag);
	}

	public void deleteVideoAndTagByVideoId(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteVideoAndTagByVideoId", id);
	}
	@SuppressWarnings("unchecked")
	public void getBrowseHistoryByGroupId(Pagination<Video> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countBrowseHistoryByGroupId", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {

			List<Video> list;

			list = getSqlMapClientTemplate().queryForList(
					"getBrowseHistoryByGroupId", pagination);

			pagination.setResults(list);
		}
		
	}
	

	public void createPointHistory(PointHistory pointHistory)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createPointHistory", pointHistory);
	}

	public void deletePointHistory(PointHistory pointHistory)
			throws DataAccessException {
		if (pointHistory != null
				&& (pointHistory.getId() != null
						|| pointHistory.getUserId() != null || pointHistory
						.getVideoId() != null)) {
			getSqlMapClientTemplate()
					.delete("deletePointHistory", pointHistory);
		}
	}

	public void updatePointHistory(PointHistory pointHistory)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updatePointHistory", pointHistory);
	}

	public PointHistory getPointHistory(PointHistory pointHistory)throws DataAccessException {
		return (PointHistory) getSqlMapClientTemplate().queryForObject(
				"getPointHistory", pointHistory);
	}
	@SuppressWarnings("unchecked")
	public List<Video> getPlaybillVideoList(Long id) throws DataAccessException {
		return (List<Video>)getSqlMapClientTemplate().queryForList("getPlaybillVideoList",id);
	}

	
	public ChannelCount getChannelTop(Long id)
			throws DataAccessException {
		
		ChannelCount channelCount = (ChannelCount) getSqlMapClientTemplate().queryForObject("getChannelTop", id);
		return channelCount;
	}
	@SuppressWarnings("unchecked")
	public List<Video> getVideoRand(Condition condition) throws DataAccessException {
	List<Video> results =new ArrayList<Video>();
	results = getSqlMapClientTemplate().queryForList("getVideoRand", condition);
		return results;
	}
	@SuppressWarnings("unchecked")
	public List<Long> getPlayHistoryVideoIds(Long id)
			throws DataAccessException {
	List<Long> ids = new ArrayList<Long>();
	ids = getSqlMapClientTemplate().queryForList("getPlayHistoryVideoIds", id);
		return ids;
	}

}
