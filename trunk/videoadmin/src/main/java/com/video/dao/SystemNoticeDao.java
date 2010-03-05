package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.SystemNotice;
import com.video.domain.User;
import com.video.util.Pagination;

public interface SystemNoticeDao {
	
	public void createSystemNotice(SystemNotice systemNotice) throws DataAccessException;
	
	
	
	public void getSystemNotices(Pagination<SystemNotice> pagination)  throws DataAccessException;
	
	public void deleteSystemNoticeByGrade(User user)  throws DataAccessException;
	
	public void deleteSystemNoticeByDate(int dayNum) throws DataAccessException;
	
	public SystemNotice getSystemNoticeById(Long id)  throws DataAccessException;
	
	public void deleteSystemNoticeBySendDate(SystemNotice systemNotice) throws DataAccessException;

	
	
	


}
