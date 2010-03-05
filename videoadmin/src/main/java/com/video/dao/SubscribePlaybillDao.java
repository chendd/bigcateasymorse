package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.SubscribePlaybill;
import com.video.util.Pagination;

public interface SubscribePlaybillDao {
	
	public void createSubscribePlaybill(SubscribePlaybill subscribePlaybill) throws DataAccessException;
	
	public void deleteSubscribePlaybill(Long id) throws DataAccessException;
	

	
	public void getSubscribePlaybills(Pagination<SubscribePlaybill> pagination) throws DataAccessException;

}
