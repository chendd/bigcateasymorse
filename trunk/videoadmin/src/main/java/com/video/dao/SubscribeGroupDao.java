package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.SubscribeGroup;
import com.video.util.Pagination;

public interface SubscribeGroupDao {
	
	public void createSubscribeGroup(SubscribeGroup subscribeGroup) throws DataAccessException;
	
	public void deleteSubscribeGroup(Long id) throws DataAccessException;
	

	
	public void getDailySubscribeGroups(Pagination<SubscribeGroup> pagination) throws DataAccessException;

}
