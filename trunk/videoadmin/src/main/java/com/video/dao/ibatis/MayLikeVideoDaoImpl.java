package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.MayLikeVideoDao;
import com.video.domain.IndexRecommendVideo;
import com.video.domain.MayLikeVideo;

public class MayLikeVideoDaoImpl extends SqlMapClientDaoSupport implements MayLikeVideoDao{

	public void createMayLikeVideo(MayLikeVideo mayLikeVideo)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createMayLikeVideo", mayLikeVideo);
		
	}

	public void deleteMayLikeVideo() throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteMayLikeVideo");
		
	}



	public List<MayLikeVideo> getMayLikeVideoes() throws DataAccessException {
		return (List<MayLikeVideo>)getSqlMapClientTemplate().queryForList("getMayLikeVideoes");
	}

	public void updateMayLikeVideo(MayLikeVideo mayLikeVideo)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateMayLikeVideo", mayLikeVideo);
		
	}

	public MayLikeVideo getBackVideoeById(Long id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public MayLikeVideo getFrontVideoeById(Long id)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public MayLikeVideo getMayLikeVideoById(Long id)
			throws DataAccessException {
		return (MayLikeVideo)getSqlMapClientTemplate().queryForObject("getMayLikeVideoById", id);
	}

}
