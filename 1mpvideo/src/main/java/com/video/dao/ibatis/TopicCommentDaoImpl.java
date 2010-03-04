package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.TopicCommentDao;
import com.video.domain.Comment;
import com.video.domain.Tag;
import com.video.domain.TopicComment;
import com.video.util.Pagination;

public class TopicCommentDaoImpl extends SqlMapClientDaoSupport implements
		TopicCommentDao {

	public void createTopicComment(TopicComment topicComment)
			throws DataAccessException {

		getSqlMapClientTemplate().insert("createTopicComment", topicComment);

	}

	public void deleteTopicComment(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteTopicComment", id);

	}

	public TopicComment getTopicCommentById(Long id) throws DataAccessException {
	    
		TopicComment comment =  (TopicComment)getSqlMapClientTemplate().queryForObject("getTopicCommentById",id);
		
		return comment;
	}

	public void getTopicComments(Pagination<TopicComment> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countTopicComments",pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<TopicComment> list;

			list = this.getSqlMapClientTemplate().queryForList("getTopicComments",
					pagination);

			pagination.setResults(list);

		}
	}

	public void updateTopicComment(TopicComment topicComment)
			throws DataAccessException {
		// TODO Auto-generated method stub

	}


	public void deleteTopicCommentByTopicId(Long id) throws DataAccessException {
	getSqlMapClientTemplate().delete("deleteTopicCommentByTopicId", id);
		
	}

	public int getTopicCommentCount(Pagination<TopicComment> pagination)
			throws DataAccessException {
		int num = (Integer)getSqlMapClientTemplate().queryForObject("countTopicComments", pagination);
		return num;
	}

}
