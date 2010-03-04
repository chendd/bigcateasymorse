package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.GroupRequestDao;
import com.video.dao.UserRequestDao;
import com.video.domain.GroupRequest;
import com.video.domain.UserRequest;

public class UserRequestDaoImpl extends SqlMapClientDaoSupport implements UserRequestDao{


	public void createUserRequest(UserRequest userRequest)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createUserRequest", userRequest);
		
	}

	
	public void deleteUserRequestById(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteUserRequest", id);
		
	}


	public List<UserRequest> getUserRequestsByGroupId(Long id)
			throws DataAccessException {
		
		return (List<UserRequest> )getSqlMapClientTemplate().queryForList("getUserRequestsByGroupId", id);
	}


	public void updateUserRequest(UserRequest userRequest)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateUserRequest", userRequest);
		
	}


	public UserRequest getUserRequest(UserRequest userRequest) throws DataAccessException {
		
		return (UserRequest) getSqlMapClientTemplate().queryForObject("getUserRequest", userRequest);
	}




	

}
