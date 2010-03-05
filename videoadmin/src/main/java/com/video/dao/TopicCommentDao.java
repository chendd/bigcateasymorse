package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.Tag;
import com.video.domain.TopicComment;
import com.video.util.Pagination;

public interface TopicCommentDao {
	
	public void createTopicComment(TopicComment topicComment) throws DataAccessException;
	
	
public void updateTopicComment(TopicComment topicComment) throws DataAccessException;
	
	public void deleteTopicComment(Long id) throws DataAccessException;
	
	public TopicComment getTopicCommentById(Long id) throws DataAccessException;
	
	public void getTopicComments(Pagination<TopicComment> pagination) throws DataAccessException;

}
