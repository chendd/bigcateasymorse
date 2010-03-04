package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.BlogHistory;
import com.video.domain.GroupHistory;
import com.video.util.Pagination;

public interface GroupHistoryDao {
	

	
	public void createGroupHistory(GroupHistory groupHistory)throws DataAccessException;
	
	public void updateGroupHistory(GroupHistory groupHistory)throws DataAccessException;
	
	public GroupHistory getGroupHistory(GroupHistory groupHistory)throws DataAccessException;
	
	public void getGroupHistories(Pagination<GroupHistory> pagination) throws DataAccessException;
	
	public void deleteGroupHistoryByGoupId(Long id) throws DataAccessException;

}
