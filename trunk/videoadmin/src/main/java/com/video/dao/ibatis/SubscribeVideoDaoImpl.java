package com.video.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.SubscribeVideoDao;
import com.video.domain.SubscribeVideo;
import com.video.util.Pagination;

public class SubscribeVideoDaoImpl  extends SqlMapClientDaoSupport implements SubscribeVideoDao{

	public void createSubscribeVideo(SubscribeVideo subscribeVideo)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void deleteSubscribeVideo(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void getSubscribeVideoes(
			Pagination<SubscribeVideo> pagination) throws DataAccessException {
		// TODO Auto-generated method stub
	}

}
