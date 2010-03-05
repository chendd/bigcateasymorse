package com.video.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.AuspiceAnnalDao;
import com.video.domain.AuspiceAnnal;
import com.video.util.Pagination;

public class AuspiceAnnalDaoImpl extends SqlMapClientDaoSupport implements AuspiceAnnalDao{

	public void createAuspiceAnnal(AuspiceAnnal auspiceAnnal)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void getAuspiceAnnals(Pagination<AuspiceAnnal> pagination)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	

}
