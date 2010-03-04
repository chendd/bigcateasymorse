package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.Group;
import com.video.domain.GroupAndUser;
import com.video.util.Pagination;

public interface GroupAndUserDao {
	
	public void createGroupAndUser(GroupAndUser groupAndUser) throws DataAccessException;
	
	public void updateGroupAndUser(GroupAndUser groupAndUser) throws DataAccessException;
	
	public void deleteGroupAndUser(GroupAndUser groupAndUser) throws DataAccessException;
	
	public void getGroupAndUsers(Pagination<GroupAndUser> pagination) throws DataAccessException;
	
	public void getMyJoinGroups(Pagination<GroupAndUser> pagination) throws DataAccessException;
	
	public void getMyGroupMembers(Pagination<GroupAndUser> pagination) throws DataAccessException;
	

	public List<Group> getMyGroups(Long userId) throws DataAccessException;
	
	public GroupAndUser getGroupAndUser(GroupAndUser groupAndUser) throws DataAccessException;
	
	public void deleteGroupAndUserByGoupId(Long id)  throws DataAccessException;
	
	public void getGroupAdmins(Pagination<GroupAndUser> pagination) throws DataAccessException;
	
}
