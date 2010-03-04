package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.SystemNotice;
import com.video.util.Pagination;

public interface SystemNoticeDao {
	
	public void createSystemNotice(SystemNotice systemNotice) throws DataAccessException;
	
	public void updateSystemNotice(SystemNotice systemNotice) throws DataAccessException;
	
	public void deleteSystemNoticeByUserId(Long id) throws DataAccessException;
	
	public void getSystemNoticesByUserId(Pagination<SystemNotice> pagination)  throws DataAccessException;
	
	public SystemNotice getSystemNoticeById(Long id) throws DataAccessException;
	
	public int countNewNotice(Long id) throws DataAccessException;
	
	public void updateSystemNoticeById(SystemNotice systemNotice) throws DataAccessException;

	
	
	


}
