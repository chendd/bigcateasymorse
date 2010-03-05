package com.video.dao.ibatis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.GroupDao;
import com.video.domain.Administrator;
import com.video.domain.Group;
import com.video.domain.User;
import com.video.util.Pagination;

public class GroupDaoImpl extends SqlMapClientDaoSupport implements GroupDao {

	public Group createGroup(Group group) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteGroup(Long id) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public Group getGroupById(Long id) throws DataAccessException {
		return (Group) getSqlMapClientTemplate().queryForObject("getGroupById",
				id);
	}

	public void getGroups(Pagination<Group> pagination)
			throws DataAccessException {

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countGroup");

		pagination.setRecordSum(count);
		if (count > 0) {
			List<Group> list;

			list = this.getSqlMapClientTemplate().queryForList("getGroups",
					pagination);

			pagination.setResults(list);

		}
	}

	public void updateGroup(Group group) throws DataAccessException {
		getSqlMapClientTemplate().update("updateGroup", group);

	}

	public void getOhterUsersByGroupId(Pagination<User> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countOhterUsersByGroupId",pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<User> list;

			list = this.getSqlMapClientTemplate().queryForList(
					"getOhterUsersByGroupId", pagination);

			pagination.setResults(list);

		}

	}

	public void getUsersByGroupId(Pagination<User> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countUsersByGroupId",pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<User> list;

			list = this.getSqlMapClientTemplate().queryForList(
					"getUsersByGroupId", pagination);

			pagination.setResults(list);

		}

	}

	public List<Group> getRecommendGroups() throws DataAccessException {
		List<Group> groups = new ArrayList<Group>();
		groups = this.getSqlMapClientTemplate().queryForList("getRecommendGroups");
		return groups;
	}

	public void deleteRecommendGroups() throws DataAccessException {
		getSqlMapClientTemplate().update("deleteRecommendGroups");
		
	}

	public void creatRecommendGroup(Group group) throws DataAccessException {
		getSqlMapClientTemplate().update("creatRecommendGroup",group);
		
	}

}
