package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.Notice;

public interface NoticeDao {
	
	public void createNotice(Notice notice) throws DataAccessException;
	
	public void updateNotice(Notice notice) throws DataAccessException;
	
	public void deleteNoticeById(Long id) throws DataAccessException;
	
	
	public List<Notice> getNotices() throws DataAccessException;
	
	public Notice getNoticeById(Long id) throws DataAccessException;
	
	
	
	
	
	

}
