package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.VideoChannelDao;
import com.video.domain.VideoChannel;

public class VideoChannelDaoImpl extends SqlMapClientDaoSupport implements
		VideoChannelDao {

	public void createVideoChannel(VideoChannel videoChannel)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createVideoChannel", videoChannel);
	}

	public void deleteVideoChannel(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteVideoChannel", id);
	}

	public VideoChannel getVideoChannelById(Long id) throws DataAccessException {

		return (VideoChannel) getSqlMapClientTemplate().queryForObject(
				"getVideoChannelById", id);
	}

	public List<VideoChannel> getVideoChannels(VideoChannel videoChannel)
			throws DataAccessException {
		// List<VideoChannel> list = getSqlMapClientTemplate().queryForList("");
		return null;
	}

	public void updateVideoChannel(VideoChannel videoChannel)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateVideoChannel", videoChannel);
	}

	public List<VideoChannel> getVideoChannelList() throws DataAccessException {
		List<VideoChannel> list = getSqlMapClientTemplate().queryForList(
				"getVideoChannelList");
		return list;
	}

	public List<VideoChannel> getChildVideoChannelList(Long parentId)
			throws DataAccessException {
		return getSqlMapClientTemplate().queryForList(
				"getChildVideoChannelList", parentId);
	}

	public void updateVideoChannelWithParent(VideoChannel videoChannel)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateVideoChannelWithParent",
				videoChannel);
	}

	public void updateVideoChannelWithParentByParent(VideoChannel videoChannel)
			throws DataAccessException {
		getSqlMapClientTemplate().update(
				"updateVideoChannelWithParentByParent", videoChannel);
	}

}
