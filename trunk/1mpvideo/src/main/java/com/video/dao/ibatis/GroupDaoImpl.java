package com.video.dao.ibatis;

import java.text.MessageFormat;
import java.util.List;

//import org.apache.struts.taglib.tiles.GetAttributeTag;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.GroupDao;
import com.video.domain.Administrator;
import com.video.domain.Group;
import com.video.domain.Topic;
import com.video.domain.User;
import com.video.util.Pagination;

public class GroupDaoImpl extends SqlMapClientDaoSupport implements GroupDao {

	public Group createGroup(Group group) throws DataAccessException {
		getSqlMapClientTemplate().insert("createGroup", group);
		return group;
	}

	public void deleteGroup(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteGroupById", id);

	}

	public Group getGroupById(Long id) throws DataAccessException {
	
		return (Group) getSqlMapClientTemplate().queryForObject("getGroupById",
				id);
	}

	public void getGroups(Pagination<Group> pagination)
			throws DataAccessException {
		if(pagination.getCondition()!=null){
			Group group = (Group) pagination.getCondition();
			
			if (group.getName() != null && !group.getName().isEmpty()) {
				group.setName(MessageFormat.format("%{0}%", group.getName()
						.replaceAll("%", "!%").replaceAll("!", "!!")));
			}
		}
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countGroup",pagination);

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


	public Group getGroupSimpleById(Long id) throws DataAccessException {
		return (Group)getSqlMapClientTemplate().queryForObject("getGroupSimpleById",id);
	}

	public List<Group> getMyGroupList(Long id) throws DataAccessException {
		
		return this.getSqlMapClientTemplate().queryForList(
				"getMyGroupList", id);
	}




}
