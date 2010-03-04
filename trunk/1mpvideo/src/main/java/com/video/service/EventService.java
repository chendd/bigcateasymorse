package com.video.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.Event;
import com.video.domain.Notice;
import com.video.util.Pagination;

public interface EventService {
	
	public void createEvent(Event event) throws DataAccessException;

	public void deleteEvent(Long id) throws DataAccessException;

	public List<Event> getLastEvents() throws DataAccessException;

	public void getEvents(Pagination<Event> pagination)
			throws DataAccessException;
	
	List<Notice> getNotices() throws DataAccessException;

}
