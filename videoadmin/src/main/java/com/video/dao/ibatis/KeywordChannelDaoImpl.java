package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.KeywordChannelDao;
import com.video.domain.KeywordChannel;

public class KeywordChannelDaoImpl extends SqlMapClientDaoSupport implements
		KeywordChannelDao {

	public void createKeywordChannel(KeywordChannel keywordChannel)
			throws DataAccessException {
		getSqlMapClientTemplate()
				.insert("createKeywordChannel", keywordChannel);

	}

	public void deleteKeywordChannel(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteKeywordChannel", id);

	}

	public KeywordChannel getKeywordChannel(Long id) throws DataAccessException {
		return (KeywordChannel) getSqlMapClientTemplate().queryForObject(
				"getKeywordChannel", id);
	}

	public List<KeywordChannel> getKeywordChannels() throws DataAccessException {
		List<KeywordChannel> list = getSqlMapClientTemplate().queryForList(
				"getKeywordChannels");
		return list;
	}

	public void updateKeywordChannel(KeywordChannel keywordChannel)
			throws DataAccessException {
		getSqlMapClientTemplate()
				.update("updateKeywordChannel", keywordChannel);
	}

	public KeywordChannel getKeywordChannelByName(String name)
			throws DataAccessException {

		return (KeywordChannel) getSqlMapClientTemplate().queryForObject(
				"getKeywordChannelByName", name);
	}

	public void updateKeywordChannelWithOrder(KeywordChannel keywordChannel)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateKeywordChannelWithOrder",
				keywordChannel);
	}

}
