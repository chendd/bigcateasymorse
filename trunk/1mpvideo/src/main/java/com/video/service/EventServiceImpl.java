package com.video.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.dao.EventDao;
import com.video.dao.NoticeDao;
import com.video.domain.Event;
import com.video.domain.Notice;
import com.video.util.Pagination;

public class EventServiceImpl implements EventService{

	private EventDao eventDao;
	
	private NoticeDao noticeDao;
	
	
	
	public NoticeDao getNoticeDao() {
		return noticeDao;
	}

	public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}

	public EventDao getEventDao() {
		return eventDao;
	}

	public void setEventDao(EventDao eventDao) {
		this.eventDao = eventDao;
	}

	public void createEvent(Event event) throws DataAccessException {
		this.eventDao.createEvent(event);
		
	}

	public void deleteEvent(Long id) throws DataAccessException {
		this.eventDao.deleteEvent(id);
		
	}

	public void getEvents(Pagination<Event> pagination)
			throws DataAccessException {
		this.eventDao.getEvents(pagination);
		
	}

	public List<Event> getLastEvents() throws DataAccessException {
	
		return this.eventDao.getLastEvents();
	}

	public List<Notice> getNotices() throws DataAccessException {
	
		return this.noticeDao.getNotices();
	}

}
