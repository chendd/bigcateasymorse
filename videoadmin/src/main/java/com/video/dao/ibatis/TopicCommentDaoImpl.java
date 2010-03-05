package com.video.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.TopicCommentDao;
import com.video.domain.Tag;
import com.video.domain.TopicComment;
import com.video.util.Pagination;

public class TopicCommentDaoImpl  extends SqlMapClientDaoSupport implements TopicCommentDao{

	public void createTopicComment(TopicComment topicComment)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void deleteTopicComment(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteTopicComment", id);
		
	}

	public TopicComment getTopicCommentById(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public void getTopicComments(
			Pagination<TopicComment> pagination) throws DataAccessException {
		// TODO Auto-generated method stub
	}

	public void updateTopicComment(TopicComment topicComment)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
