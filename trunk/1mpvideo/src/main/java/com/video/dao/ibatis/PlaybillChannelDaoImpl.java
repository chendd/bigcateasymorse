package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.PlaybillChannelDao;
import com.video.domain.PlaybillChannel;

public class PlaybillChannelDaoImpl extends SqlMapClientDaoSupport implements
		PlaybillChannelDao {
	public List<PlaybillChannel> getPlaybillChannels() throws DataAccessException{
		return getSqlMapClientTemplate().queryForList("getPlayBillChannels");
	}
}
