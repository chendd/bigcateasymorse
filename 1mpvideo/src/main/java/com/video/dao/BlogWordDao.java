package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.BlogWord;
import com.video.util.Pagination;

public interface BlogWordDao {
	
	
	public void createBlogWord(BlogWord blogWord) throws DataAccessException;
	
	public void deleteBlogWordById(Long id) throws DataAccessException;
	
	public void getBlogWords(Pagination<BlogWord> pagination) throws DataAccessException;

}
