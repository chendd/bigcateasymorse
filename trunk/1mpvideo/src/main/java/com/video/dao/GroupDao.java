package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.Group;
import com.video.domain.User;
import com.video.util.Pagination;

public interface GroupDao {
	
	public Group createGroup(Group group) throws DataAccessException;
	
	public void updateGroup(Group group) throws DataAccessException;
	
	public void deleteGroup(Long id) throws DataAccessException;
	
	public Group getGroupById(Long id) throws DataAccessException;
	
	public void getGroups(Pagination<Group> pagination) throws DataAccessException;
	
	public void getUsersByGroupId(Pagination<User> pagination) throws DataAccessException;
	
	public void getOhterUsersByGroupId(Pagination<User> pagination) throws DataAccessException;
	
	public Group getGroupSimpleById(Long id) throws DataAccessException;
	
	public List<Group> getMyGroupList(Long id) throws DataAccessException;
	
	
	


	
	

}
