package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.GroupRequest;

public interface GroupRequestDao { 
	public GroupRequest getGroupRequest(GroupRequest groupRequest) throws DataAccessException;
	public void createGroupRequest(GroupRequest groupRequest) throws DataAccessException;
	
	public void deleteGroupRequestById(Long id) throws DataAccessException;
	
	public void updateGroupRequest(GroupRequest groupRequest) throws DataAccessException;
	
	public List<GroupRequest> getGroupRequestsByGroupId(Long id)  throws DataAccessException;

	

}
