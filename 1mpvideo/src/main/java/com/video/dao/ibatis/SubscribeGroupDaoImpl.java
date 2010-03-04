package com.video.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.SubscribeGroupDao;
import com.video.domain.SubscribeGroup;
import com.video.util.Pagination;

public class SubscribeGroupDaoImpl  extends SqlMapClientDaoSupport implements SubscribeGroupDao{

	public void createSubscribeGroup(SubscribeGroup subscribeGroup)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void deleteSubscribeGroup(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void getDailySubscribeGroups(
			Pagination<SubscribeGroup> pagination) throws DataAccessException {
		// TODO Auto-generated method stub
	}

}
