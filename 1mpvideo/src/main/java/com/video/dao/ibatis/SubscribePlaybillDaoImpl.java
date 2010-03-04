package com.video.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.SubscribePlaybillDao;
import com.video.domain.SubscribePlaybill;
import com.video.util.Pagination;

public class SubscribePlaybillDaoImpl  extends SqlMapClientDaoSupport implements SubscribePlaybillDao{

	public void createSubscribePlaybill(SubscribePlaybill subscribePlaybill)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void deleteSubscribePlaybill(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void getSubscribePlaybills(
			Pagination<SubscribePlaybill> pagination)
			throws DataAccessException {
		// TODO Auto-generated method stub
	}

}
