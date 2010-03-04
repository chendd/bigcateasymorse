package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.PlaybillChannel;

public interface PlaybillChannelDao {
	public List<PlaybillChannel> getPlaybillChannels()
			throws DataAccessException;
}
