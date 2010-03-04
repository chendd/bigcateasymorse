package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.DailyReply;
import com.video.util.Pagination;

public interface DailyReplyDao {
	
	public void createDailyReply(DailyReply dailyReply) throws DataAccessException;
	
	public void updateDailyReplyById(DailyReply dailyReply) throws DataAccessException;
	
	public void deleteDailyReplyById(long id) throws DataAccessException;
	
	public DailyReply getDailyReplyById(long id) throws DataAccessException;
	
	public void getDailyReplies(Pagination<DailyReply> pagination) throws DataAccessException;

}
