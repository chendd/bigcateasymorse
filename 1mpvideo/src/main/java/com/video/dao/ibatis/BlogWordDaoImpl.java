package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.BlogWordDao;
import com.video.domain.BlogWord;
import com.video.domain.User;
import com.video.util.Pagination;

public class BlogWordDaoImpl extends SqlMapClientDaoSupport implements BlogWordDao{


	public void createBlogWord(BlogWord blogWord) throws DataAccessException {

		getSqlMapClientTemplate().insert("createBlogWord", blogWord);
	}

	
	public void deleteBlogWordById(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteBlogWordById", id);

		
	}


	public void getBlogWords(Pagination<BlogWord> pagination)
			throws DataAccessException {
		
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
		"countBlogWord",pagination);
		
		pagination.setRecordSum(count);
		if (count > 0) {
			List<BlogWord> list;
			
			
			
			

			list = getSqlMapClientTemplate().queryForList("getBlogWords",
					pagination);

			pagination.setResults(list);
		}
	}

}
