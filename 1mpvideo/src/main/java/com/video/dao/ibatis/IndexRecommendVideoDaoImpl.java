package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.IndexRecommendVideoDao;
import com.video.domain.IndexRecommendVideo;

public class IndexRecommendVideoDaoImpl  extends SqlMapClientDaoSupport implements IndexRecommendVideoDao{

	public void createIndexRecommendVideo(
			IndexRecommendVideo indexRecommendVideo) throws DataAccessException {
		getSqlMapClientTemplate().insert("createIndexRecommendVideo", indexRecommendVideo);
		
	}

	public void deleteIndexRecommendVideo() throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteIndexRecommendVideo");
		
	}



	public List<IndexRecommendVideo> getIndexRecommendVideoes()
			throws DataAccessException {
		return (List<IndexRecommendVideo>)getSqlMapClientTemplate().queryForList("getIndexRecommendVideoes");
	}

	public void updateIndexRecommendVideo(
			IndexRecommendVideo indexRecommendVideo) throws DataAccessException {
		getSqlMapClientTemplate().update("updateIndexRecommendVideo", indexRecommendVideo);
		
	}

	public IndexRecommendVideo getBackVideoById(Long id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public IndexRecommendVideo getFrontVideoById(Long id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public IndexRecommendVideo getIndexRecommendVideoById(Long id)
			throws DataAccessException {
		return (IndexRecommendVideo)getSqlMapClientTemplate().queryForObject("getIndexRecommendVideoById", id);
	}

}
