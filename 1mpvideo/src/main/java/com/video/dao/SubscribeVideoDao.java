package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.SubscribeVideo;
import com.video.util.Pagination;

public interface SubscribeVideoDao {
	
	public void createSubscribeVideo(SubscribeVideo subscribeVideo) throws DataAccessException;
	
	public void deleteSubscribeVideo(Long id) throws DataAccessException;
	

	
	public void getSubscribeVideoes(Pagination<SubscribeVideo> pagination) throws DataAccessException;

}
