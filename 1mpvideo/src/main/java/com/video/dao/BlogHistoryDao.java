package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.BlogHistory;
import com.video.util.Pagination;

public interface BlogHistoryDao {
	

	
	public void createBlogHistory(BlogHistory blogHistory)throws DataAccessException;
	
	public void updateBlogHistory(BlogHistory blogHistory)throws DataAccessException;
	
	public void getBlogHistories(Pagination<BlogHistory> pagination) throws DataAccessException;
	public BlogHistory getBlogHistory(BlogHistory blogHistory) throws DataAccessException;

}
