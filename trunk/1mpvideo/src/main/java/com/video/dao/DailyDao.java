package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.domain.DailyComment;
import com.video.domain.connection.DailyAndTag;
import com.video.util.Pagination;

public interface DailyDao {

	public Daily createDaily(Daily daily) throws DataAccessException;

	public void updateDaily(Daily daily) throws DataAccessException;

	public void deleteDaily(Long id) throws DataAccessException;

	public Daily getDailyById(Long id) throws DataAccessException;

	public void getDailies(Pagination<Daily> pagination)
			throws DataAccessException;

	public void updateDailyByChannelId(Daily daily) throws DataAccessException;

	public List<Daily> getDailysByChannelId(Long id) throws DataAccessException;

	public void updateDailyCleanByChannelId(Long id) throws DataAccessException;

	public void deleteDailyByChannelId(Long id) throws DataAccessException;

	public void updateDailyWithChannelIdById(Daily daily)
			throws DataAccessException;

	public void updateDailyTopById(Daily daily) throws DataAccessException;

	public void updateDailyHotById(Daily daily) throws DataAccessException;

	public void updateDailyRecommendById(Daily daily)
			throws DataAccessException;

	public List<DailyChannel> getOtherDailyChannelByDailyId(Long id)
			throws DataAccessException;
	
	public void getMyDailies(Pagination<Daily> pagination) throws DataAccessException;
	
	public void getDailyComment(Pagination<DailyComment> pagination) throws DataAccessException;
	
	public void createDailyComment(DailyComment dailyComment) throws DataAccessException;
	
	public void deleteDailyCommentById(Long id) throws DataAccessException;
	
	public void deleteDailyCommentByDailyId(Long id) throws DataAccessException;
	
	public void createDailyAndTag(DailyAndTag dailyAndTag) throws DataAccessException;
	public DailyAndTag getDailyAndTag(DailyAndTag dailyAndTag) throws DataAccessException;
	}