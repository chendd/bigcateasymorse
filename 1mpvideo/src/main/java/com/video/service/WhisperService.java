package com.video.service;

import org.springframework.dao.DataAccessException;

import com.video.domain.SystemNotice;
import com.video.domain.Whisper;
import com.video.util.Pagination;

public interface WhisperService {
	public void createWhisper(Whisper whisper) throws DataAccessException;
	public void getWhispers(Pagination<Whisper> pagination) throws DataAccessException;
	public Whisper getWhisperById(Long id) throws DataAccessException;
	public SystemNotice getSystemNoticeById(Long id) throws DataAccessException;
	
	public void getSystemNoticesByUserId(Pagination<SystemNotice> pagination) throws DataAccessException;
	
	public void createSystemNotice(SystemNotice systemNotice)
	throws DataAccessException;
	
	public int getNewMessageCount(Long id) throws DataAccessException;
	

}
