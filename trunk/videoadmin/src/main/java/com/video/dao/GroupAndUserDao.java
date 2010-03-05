package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.GroupAndUser;
import com.video.util.Pagination;

public interface GroupAndUserDao {
	
	public void createGroupAndUser(GroupAndUser groupAndUser) throws DataAccessException;
	
	public void updateGroupAndUser(GroupAndUser groupAndUser) throws DataAccessException;
	
	public void deleteGroupAndUser(GroupAndUser groupAndUser) throws DataAccessException;
	
	public void getGroupAndUsers(Pagination<GroupAndUser> pagination) throws DataAccessException;
	

	
	
}
