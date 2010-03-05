package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.KeywordChannel;

public interface KeywordChannelDao {

	public void createKeywordChannel(KeywordChannel keywordChannel)
			throws DataAccessException;

	public void updateKeywordChannel(KeywordChannel keywordChannel)
			throws DataAccessException;

	public void deleteKeywordChannel(Long id) throws DataAccessException;

	public KeywordChannel getKeywordChannel(Long id) throws DataAccessException;

	public List<KeywordChannel> getKeywordChannels() throws DataAccessException;

	public KeywordChannel getKeywordChannelByName(String name)
			throws DataAccessException;

	public void updateKeywordChannelWithOrder(KeywordChannel keywordChannel)
			throws DataAccessException;
}
