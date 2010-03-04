package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.GroupRequest;
import com.video.domain.UserRequest;

public interface UserRequestDao { 
	public UserRequest getUserRequest(UserRequest userRequest) throws DataAccessException;
	public void createUserRequest(UserRequest userRequest) throws DataAccessException;
	
	public void deleteUserRequestById(Long id) throws DataAccessException;
	
	public void updateUserRequest(UserRequest userRequest) throws DataAccessException;
	
	public List<UserRequest> getUserRequestsByGroupId(Long id)  throws DataAccessException;

	

}
