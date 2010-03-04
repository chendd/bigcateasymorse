package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.Event;
import com.video.util.Pagination;

public interface EventDao {

	public void createEvent(Event event) throws DataAccessException;

	public void deleteEvent(Long id) throws DataAccessException;

	public List<Event> getLastEvents() throws DataAccessException;

	public void getEvents(Pagination<Event> pagination)
			throws DataAccessException;

}
