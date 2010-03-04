package com.video.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

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

public interface VideoService {

	public List<IndexRecommendVideo> getIndexRecommendVideoes()
			throws DataAccessException;

	public List<MayLikeVideo> getMayLikeVideoes() throws DataAccessException;

	public void getPlayBills(Pagination<Playbill> pagination)
			throws DataAccessException;

	public void getVideoByTagId(Pagination<Video> pagination)
			throws DataAccessException;

	public void getVideoes(Pagination<Video> pagination)
			throws DataAccessException;

	public void getVideoBykey(Pagination<Video> pagination)
			throws DataAccessException;

	public void getVideoByPlaybill(Pagination<Video> pagination)
			throws DataAccessException;

	public void getVideo(Pagination<Video> pagination)
			throws DataAccessException;

	public void getVideoByCommend(Pagination<Video> pagination)
			throws DataAccessException;

	public void getBrowseHistoryByUserId(Pagination<Video> pagination)
			throws DataAccessException;

	public void getMyCommentVideo(Pagination<Video> pagination)
			throws DataAccessException;

	public Video getVideoById(Long id, User user) throws DataAccessException;

	public Video getInitVideo(Long id) throws DataAccessException;

	public void createCollection(CollectionVideo collectionVideo)
			throws DataAccessException;

	public void updateVideo(Video video) throws DataAccessException;

	public List<VideoChannel> getVideoChannelList() throws DataAccessException;

	public void createVideo(Video video) throws DataAccessException;

	public void createUploadVideo(UploadVideo uploadVideo)
			throws DataAccessException;

	public void updateUploadVideoStatus(UploadVideo uploadVideo)
			throws DataAccessException;
	
	public void updateUploadVideoLength(UploadVideo uploadVideo)
	throws DataAccessException;

	public Video getVideo(Long id) throws DataAccessException;

	public void getBrowseHistoryByGroupId(Pagination<Video> pagination)
			throws DataAccessException;


	public boolean pointVideo(PointHistory pointHistory)
			throws DataAccessException;
	
	public List<Video> getPlaybillVideoList(Long id) throws DataAccessException;
	
	public ChannelCount getChannelTop(Long id)
	throws DataAccessException;
	
	public List<Video> getVideoRand(Condition condition) throws DataAccessException;
	
	public List<Long> getPlayHistoryVideoIds(Long id)
	throws DataAccessException;

}
