package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.BrowseVideoHistory;
import com.video.util.Pagination;

public interface BrowseVideoHistoryDao {

	public BrowseVideoHistory createBrowseVideoHistory(
			BrowseVideoHistory history) throws DataAccessException;

	public void getBrowseVideoHistories(Pagination<BrowseVideoHistory> pagination)
			throws DataAccessException;



}
