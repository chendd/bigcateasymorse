package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.BrowseHistoryVideo;
import com.video.domain.PointHistory;
import com.video.domain.Video;
import com.video.domain.connection.ChannelCount;
import com.video.domain.connection.Condition;
import com.video.domain.connection.VideoAndTag;
import com.video.util.Pagination;

public interface VideoDao {

	public void createVideo(Video video) throws DataAccessException;

	public void updateVideo(Video video) throws DataAccessException;

	public void deleteVideo(Long id) throws DataAccessException;

	public Video getVideoById(Long id) throws DataAccessException;

	public void getVideoes(Pagination<Video> pagination)
			throws DataAccessException;

	public void updateVideoByVideoChannelId(Video video)
			throws DataAccessException;

	public void deleteVideoByChannelId(Long id) throws DataAccessException;

	public void updateVideoWithChannelByVideoChannelId(Video video)
			throws DataAccessException;

	public void getVideoByTagId(Pagination<Video> pagination)
			throws DataAccessException;

	public void getVideoByKey(Pagination<Video> pagination)
			throws DataAccessException;

	public void getVideoesByGroupId(Pagination<Video> pagination)
			throws DataAccessException;

	public void getVideoByPlaybill(Pagination<Video> pagination)
			throws DataAccessException;

	public void getVideo(Pagination<Video> pagination)
			throws DataAccessException;

	public void getVideoByCommend(Pagination<Video> pagination)
			throws DataAccessException;

	public void getBrowseHistoryByUserId(Pagination<Video> pagination)
			throws DataAccessException;
	
	public void getBrowseHistoryByGroupId(Pagination<Video> pagination)
	throws DataAccessException;

	public void getMyCommentVideo(Pagination<Video> pagination)
			throws DataAccessException;

	public void createBrowseHistory(BrowseHistoryVideo browseHistoryVideo)
			throws DataAccessException;

	public void updateBrowseHistory(BrowseHistoryVideo browseHistoryVideo)
			throws DataAccessException;

	public int getBrowseHistoryCountByUIdAndVId(
			BrowseHistoryVideo browseHistoryVideo) throws DataAccessException;

	public void updateVideoFlag(Video video) throws DataAccessException;

	public VideoAndTag getVideoAndTag(VideoAndTag videoAndTag)
			throws DataAccessException;

	public void createVideoAndTag(VideoAndTag videoAndTag)
			throws DataAccessException;

	public void deleteVideoAndTagByVideoId(Long id) throws DataAccessException;

	public void createPointHistory(PointHistory pointHistory)
			throws DataAccessException;

	public void deletePointHistory(PointHistory pointHistory)
			throws DataAccessException;

	public void updatePointHistory(PointHistory pointHistory)
			throws DataAccessException;

	public PointHistory getPointHistory(PointHistory pointHistory)
			throws DataAccessException;
	
	public List<Video> getPlaybillVideoList(Long id) throws DataAccessException;
	
	public ChannelCount getChannelTop(Long id) throws DataAccessException;
	
	public List<Video> getVideoRand(Condition condition) throws DataAccessException;
	
	public List<Long> getPlayHistoryVideoIds(Long id) throws DataAccessException;;

}
