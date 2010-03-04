package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.BlogHistory;
import com.video.domain.DailyHistory;
import com.video.domain.GroupHistory;
import com.video.util.Pagination;

public interface DailyHistoryDao {
	

	
	public void createDailyHistory(DailyHistory dailyHistory)throws DataAccessException;
	
	public void updateDailyHistory(DailyHistory dailyHistory)throws DataAccessException;
	
	public DailyHistory getDailyHistory(DailyHistory dailyHistory)throws DataAccessException;
	
	public void getDailyHistories(Pagination<DailyHistory> pagination) throws DataAccessException;
	
	public void deleteDailyHistoryByDailyId(Long id) throws DataAccessException;

}
