package com.video.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.CollectionVideoDao;
import com.video.domain.CollectionVideo;
import com.video.util.Pagination;

public class CollectionVideoDaoImpl extends SqlMapClientDaoSupport implements CollectionVideoDao{

	public void createCollectionVideo(CollectionVideo collectionVideo)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void deleteCollectionVideo(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void getCollectionVideoes(
			Pagination<CollectionVideo> pagination) throws DataAccessException {
		// TODO Auto-generated method stub
	}

}
