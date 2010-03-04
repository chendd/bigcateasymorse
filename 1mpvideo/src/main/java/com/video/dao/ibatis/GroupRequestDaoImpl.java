package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.GroupRequestDao;
import com.video.domain.GroupRequest;

public class GroupRequestDaoImpl extends SqlMapClientDaoSupport implements GroupRequestDao{


	public void createGroupRequest(GroupRequest groupRequest)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createGroupRequest", groupRequest);
		
	}

	
	public void deleteGroupRequestById(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteGroupRequest", id);
		
	}


	public List<GroupRequest> getGroupRequestsByGroupId(Long id)
			throws DataAccessException {
		
		return (List<GroupRequest> )getSqlMapClientTemplate().queryForList("getGroupRequestsByGroupId", id);
	}


	public void updateGroupRequest(GroupRequest groupRequest)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateGroupRequest", groupRequest);
		
	}


	public GroupRequest getGroupRequest(GroupRequest groupRequest) throws DataAccessException {
		
		return (GroupRequest) getSqlMapClientTemplate().queryForObject("getGroupRequest", groupRequest);
	}

}
