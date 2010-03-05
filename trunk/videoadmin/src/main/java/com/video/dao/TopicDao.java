package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.Tag;
import com.video.domain.Topic;
import com.video.util.Pagination;

public interface TopicDao {
	
	
public void createTopic(Topic topic) throws DataAccessException;
	
	public void updateTopic(Topic topic) throws DataAccessException;
	
	public void deleteTopic(Long id) throws DataAccessException;
	
	public Topic getTopicById(Long id) throws DataAccessException;
	
	public void getTopices(Pagination<Topic> pagination) throws DataAccessException;

}
