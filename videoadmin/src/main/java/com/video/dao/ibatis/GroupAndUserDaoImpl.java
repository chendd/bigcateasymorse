package com.video.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.GroupAndUserDao;
import com.video.domain.GroupAndUser;
import com.video.util.Pagination;

public class GroupAndUserDaoImpl extends SqlMapClientDaoSupport implements GroupAndUserDao {

	public void createGroupAndUser(GroupAndUser groupAndUser)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createGroupAndUser",groupAndUser);
		
	}

	public void deleteGroupAndUser(GroupAndUser groupAndUser) throws DataAccessException {
		getSqlMapClientTemplate().insert("deleteGroupAndUser",groupAndUser);
		
	}

	public void getGroupAndUsers(
			Pagination<GroupAndUser> pagination) throws DataAccessException {
		// TODO Auto-generated method stub
	}

	public void updateGroupAndUser(GroupAndUser groupAndUser)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

}
