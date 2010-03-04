package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.GroupAndUserDao;
import com.video.domain.Group;
import com.video.domain.GroupAndUser;
import com.video.domain.User;
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


	public void getMyJoinGroups(Pagination<GroupAndUser> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countMyJoinGroup",pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<GroupAndUser> list;

			list = this.getSqlMapClientTemplate().queryForList(
					"getMyJoinGroups", pagination);

			pagination.setResults(list);

		}
		
	}


	public void getMyGroupMembers(Pagination<GroupAndUser> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countMyGroupMembers",pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<GroupAndUser> list;

			list = this.getSqlMapClientTemplate().queryForList(
					"getMyGroupMembers", pagination);

			pagination.setResults(list);

		}
		
	}


	public List<Group> getMyGroups(Long userId) throws DataAccessException {
		
		return (List<Group>)getSqlMapClientTemplate().queryForList("getMyGroups",userId);
	}

	public GroupAndUser getGroupAndUser(GroupAndUser groupAndUser)
			throws DataAccessException {
		
		return (GroupAndUser)getSqlMapClientTemplate().queryForObject("getGroupAndUser",groupAndUser);
	}

	public void deleteGroupAndUserByGoupId(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteGroupAndUserByGoupId", id);
		
	}

	public void getGroupAdmins(Pagination<GroupAndUser> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countGroupAdmins",pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<GroupAndUser> list;

			list = this.getSqlMapClientTemplate().queryForList(
					"getGroupAdmins", pagination);

			pagination.setResults(list);

		}
	}

}
