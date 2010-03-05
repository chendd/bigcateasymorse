package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.SubscribeDaily;
import com.video.util.Pagination;

public interface SubscribeDailyDao {
	
	public void createSubscribeDaily(SubscribeDaily subscribeDaily) throws DataAccessException;
	
	public void deleteSubscribeDaily(Long id) throws DataAccessException;
	

	
	public void getDailySubscribeDailies(Pagination<SubscribeDaily> pagination) throws DataAccessException;

}
