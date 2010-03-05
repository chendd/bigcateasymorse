package com.video.dao.ibatis;


import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.UserDao;
import com.video.domain.User;
import com.video.domain.UserLevel;
import com.video.domain.connection.Star;
import com.video.util.Pagination;

public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao {

	public User createUser(User user) throws DataAccessException {
		getSqlMapClientTemplate().insert("createUser", user);
		return user;
	}

	public void deleteUser(Long id) throws DataAccessException {

		// TODO Auto-generated method stub


		getSqlMapClientTemplate().delete("deleteUser", id);


	}

	public User getUserById(Long id) throws DataAccessException {
		return (User) getSqlMapClientTemplate().queryForObject("getUserById",
				id);
	}

	public void getUsers(Pagination<User> pagination)
			throws DataAccessException {
		if(pagination.getCondition()!=null){
			User user = (User) pagination.getCondition();
			
			if (user.getUserName() != null && !user.getUserName().isEmpty()) {
				user.setUserName(MessageFormat.format("%{0}%", user.getUserName()
						.replaceAll("%", "!%").replaceAll("!", "!!")));
			}
			
			if (user.getRealName() != null && !user.getRealName().isEmpty()) {
				user.setRealName(MessageFormat.format("%{0}%", user.getRealName()
						.replaceAll("%", "!%").replaceAll("!", "!!")));
			}
		}
		
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countUser",pagination);
		
		pagination.setRecordSum(count);
		if (count > 0) {
			List<User> list;
			
			
			
			

			list = getSqlMapClientTemplate().queryForList("getUsers",
					pagination);

			pagination.setResults(list);
		}
	}

	public void updateUser(User user) throws DataAccessException {

		// TODO Auto-generated method stub


		getSqlMapClientTemplate().update("updateUser", user);


	}


	public List<UserLevel> getUserLevels() throws DataAccessException {
		List<UserLevel> userLevelList = new ArrayList<UserLevel>();
		UserLevel level1 = new UserLevel();
		level1.setId((long) 0);
		level1.setName("游客");
		UserLevel level2 = new UserLevel();
		level2.setId((long) 1);
		level2.setName("注册用户");
		userLevelList.add(level1);
		userLevelList.add(level2);
		return userLevelList;
	}



	public User getUserByEmail(String email) throws DataAccessException {
		return (User) getSqlMapClientTemplate().queryForObject(
				"getUserByEmail", email);
	}


	public User getUserByName(String userName) throws DataAccessException {
		return (User) getSqlMapClientTemplate().queryForObject("getUserByName",
				userName);
	}


	public User getUserByRealName(String realName) throws DataAccessException {
		return (User) getSqlMapClientTemplate().queryForObject(
				"getUserByRealName", realName);
	}



	public void listUsers(Pagination<User> pagination)
			throws DataAccessException {
		
		List<User> list;
		
		
		
		

		list = getSqlMapClientTemplate().queryForList("listUsers",
				pagination);

		pagination.setResults(list);
		
		
	}

	public List<Long> getStarIds() throws DataAccessException {
		
		return getSqlMapClientTemplate().queryForList("getStarIds");
	}

	public void updateStar(Star star) throws DataAccessException {
		getSqlMapClientTemplate().update("updateStar", star);
		
	}


}
