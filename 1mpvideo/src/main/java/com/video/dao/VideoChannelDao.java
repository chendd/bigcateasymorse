package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.VideoChannel;

public interface VideoChannelDao {

	public void createVideoChannel(VideoChannel videoChannel)
			throws DataAccessException;

	public void updateVideoChannel(VideoChannel videoChannel)
			throws DataAccessException;

	public void deleteVideoChannel(Long id) throws DataAccessException;

	public VideoChannel getVideoChannelById(Long id) throws DataAccessException;

	public List<VideoChannel> getVideoChannels(VideoChannel videoChannel)
			throws DataAccessException;

	public List<VideoChannel> getVideoChannelList() throws DataAccessException;

	public List<VideoChannel> getChildVideoChannelList(Long parentId)
			throws DataAccessException;

	public void updateVideoChannelWithParent(VideoChannel videoChannel)
			throws DataAccessException;

	public void updateVideoChannelWithParentByParent(VideoChannel videoChannel)
			throws DataAccessException;
}
