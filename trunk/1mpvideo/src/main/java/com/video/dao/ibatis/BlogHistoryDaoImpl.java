package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.BlogHistoryDao;
import com.video.domain.BlogHistory;
import com.video.util.Pagination;

public class BlogHistoryDaoImpl extends SqlMapClientDaoSupport implements BlogHistoryDao{


	public void createBlogHistory(BlogHistory blogHistory) throws DataAccessException {
		getSqlMapClientTemplate().insert("createBlogHistory", blogHistory);
		
	}


	public void getBlogHistories(Pagination<BlogHistory> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countBlogHistory", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<BlogHistory> list;
			list = getSqlMapClientTemplate().queryForList("getBlogHistories",
					pagination);
			pagination.setResults(list);
		}
		
	}


	public void updateBlogHistory(BlogHistory blogHistory)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateBlogHistory", blogHistory);
		
	}


	public BlogHistory getBlogHistory(BlogHistory blogHistory) throws DataAccessException {
		return (BlogHistory)getSqlMapClientTemplate().queryForObject("getBlogHistory", blogHistory);
		
	}

	
}
