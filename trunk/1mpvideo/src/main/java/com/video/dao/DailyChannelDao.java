package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.Administrator;
import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.util.Pagination;

public interface DailyChannelDao {

	public void createDailyChannel(DailyChannel dailyChannel)
			throws DataAccessException;

	public void deleteDailyChannel(Long id) throws DataAccessException;

	public void updateDailyChannel(DailyChannel dailyChannel)
			throws DataAccessException;

	public void updateDailyChannelOrders(DailyChannel dailyChannel)
			throws DataAccessException;

	public DailyChannel getDailyChannelById(Long id) throws DataAccessException;

	public List<DailyChannel> getDailyChannels() throws DataAccessException;

	public List<DailyChannel> getDailyChannelsByParentId(Long parentId)
			throws DataAccessException;

	public void getDailyChannelPage(Pagination<DailyChannel> pagination)
			throws DataAccessException;

	public List<DailyChannel> getRootDailyChannels() throws DataAccessException;

	public void updateRepositionDailyChannelOrders() throws DataAccessException;

	public DailyChannel getParentDailyChannel(DailyChannel dailyChannel)
			throws DataAccessException;

	public void updateUniteDailyChannel(DailyChannel dailyChannel)
			throws DataAccessException;
	
	
	public List<DailyChannel> getSimpleDailyChannels(Long userId) throws DataAccessException;
}
