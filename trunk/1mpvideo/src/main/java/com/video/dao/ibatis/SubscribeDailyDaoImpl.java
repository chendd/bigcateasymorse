package com.video.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.SubscribeDailyDao;
import com.video.domain.SubscribeDaily;
import com.video.util.Pagination;

public class SubscribeDailyDaoImpl extends SqlMapClientDaoSupport implements SubscribeDailyDao{

	public void createSubscribeDaily(SubscribeDaily subscribeDaily)
			throws DataAccessException {
		
		
	}

	public void deleteSubscribeDaily(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void getDailySubscribeDailies(
			Pagination<SubscribeDaily> pagination) throws DataAccessException {
		// TODO Auto-generated method stub
	}

}
