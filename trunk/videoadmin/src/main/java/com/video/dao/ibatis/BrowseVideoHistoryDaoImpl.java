package com.video.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.BrowseVideoHistoryDao;
import com.video.domain.BrowseVideoHistory;
import com.video.util.Pagination;

public class BrowseVideoHistoryDaoImpl extends SqlMapClientDaoSupport implements BrowseVideoHistoryDao{

	public BrowseVideoHistory createBrowseVideoHistory(
			BrowseVideoHistory history) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public void getBrowseVideoHistories(
			Pagination<BrowseVideoHistory> pagination)
			throws DataAccessException {
		// TODO Auto-generated method stub
	}

}
