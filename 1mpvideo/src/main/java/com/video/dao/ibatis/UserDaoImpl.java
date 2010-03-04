package com.video.dao.ibatis;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.UserDao;
import com.video.domain.Friend;
import com.video.domain.SubscribeUser;
import com.video.domain.User;
import com.video.domain.UserLevel;
import com.video.util.Pagination;

public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao {

	public User createUser(User user) throws DataAccessException {
		getSqlMapClientTemplate().insert("createUser", user);
		return user;
	}

	public void deleteUser(Long id) throws DataAccessException {

		getSqlMapClientTemplate().delete("deleteUser", id);

	}

	public User getUserById(Long id) throws DataAccessException {
		return (User) getSqlMapClientTemplate().queryForObject("getUserById",
				id);
	}

	public void getUsers(Pagination<User> pagination)
			throws DataAccessException {
		if (pagination.getCondition() != null) {
			User user = (User) pagination.getCondition();

			if (user.getUserName() != null && !user.getUserName().isEmpty()) {
				user.setUserName(MessageFormat.format("%{0}%", user
						.getUserName().replaceAll("%", "!%").replaceAll("!",
								"!!")));
			}

			if (user.getRealName() != null && !user.getRealName().isEmpty()) {
				user.setRealName(MessageFormat.format("%{0}%", user
						.getRealName().replaceAll("%", "!%").replaceAll("!",
								"!!")));
			}
		}

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countUser", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<User> list;

			list = getSqlMapClientTemplate().queryForList("getUsers",
					pagination);

			pagination.setResults(list);
		}
	}

	public void updateUser(User user) throws DataAccessException {

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

		list = getSqlMapClientTemplate().queryForList("listUsers", pagination);

		pagination.setResults(list);

	}

	public void getFriends(Pagination<User> pagination)
			throws DataAccessException {
		if (pagination.getCondition() != null) {
			User user = (User) pagination.getCondition();

		}

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countFriend", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<User> list;

			list = getSqlMapClientTemplate().queryForList("getFriends",
					pagination);

			pagination.setResults(list);
		}
	}

	public void getUsers2(Pagination<User> pagination)
			throws DataAccessException {

		if (pagination.getCondition() != null) {
			User user = (User) pagination.getCondition();

		

			if (user.getRealName() != null && !user.getRealName().isEmpty()) {
				user.setRealName(MessageFormat.format("%{0}%", user
						.getRealName().replaceAll("%", "!%").replaceAll("!",
								"!!")));
			}
		}
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countUser", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<User> list;

			list = getSqlMapClientTemplate().queryForList("getUsers2",
					pagination);

			pagination.setResults(list);
		}

	}

	public void getSubscribeUser(Pagination<SubscribeUser> pagination)
			throws DataAccessException {

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countSubscribeUser", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<SubscribeUser> list;

			list = getSqlMapClientTemplate().queryForList("getSubscribeUsers",
					pagination);

			pagination.setResults(list);
		}

	}

	public User getUser2ById(Long id) throws DataAccessException {
		return (User) getSqlMapClientTemplate().queryForObject("getUser2ById",
				id);
	}

	public void getUsersOrderByBrowseTimes(Pagination<User> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countUsersOrderByCommentCount",pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<User> list;

			list = getSqlMapClientTemplate().queryForList(
					"getUsersOrderByBrowseTimes", pagination);

			pagination.setResults(list);
		}

	}

	public void getUsersOrderByNewVideo(Pagination<User> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countUsersOrderByCommentCount");

		pagination.setRecordSum(count);
		if (count > 0) {
			List<User> list;

			list = getSqlMapClientTemplate().queryForList(
					"getUsersOrderByNewVideo", pagination);

			pagination.setResults(list);
		}

	}

	public void getUsersOrderByCommentCount(Pagination<User> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countUsersOrderByCommentCount",pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<User> list;
			list = getSqlMapClientTemplate().queryForList(
					"getUsersOrderByCommentCount", pagination);
			pagination.setResults(list);
		}

	}

	public User getUserUsePlaybillById(User user) throws DataAccessException {
		return (User) getSqlMapClientTemplate().queryForObject(
				"getUserUsePlaybillById", user);
	}

	public void getOtherUserByVideoId(Pagination<User> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countOtherUserByVideoId", pagination);
		pagination.setRecordSum(count);
		if (count > 0) {
			List<User> list;
			list = getSqlMapClientTemplate().queryForList(
					"getOtherUserByVideoId", pagination);
			pagination.setResults(list);
		}
	}

	public void createSubscribe(SubscribeUser subscribeUser)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createSubscribe", subscribeUser);
	}
	
	
	public void deleteSubscribe(SubscribeUser subscribeUser)
	throws DataAccessException{
		getSqlMapClientTemplate().delete("deleteSubscribe", subscribeUser);
	}

	
	public Long getFriendId(Friend friend) throws DataAccessException {
		
		return (Long)getSqlMapClientTemplate().queryForObject("getFriendId", friend);
	}


	public SubscribeUser getSubscribe(SubscribeUser subscribeUser)
			throws DataAccessException {
		return (SubscribeUser) getSqlMapClientTemplate().queryForObject(
				"getSubscribe", subscribeUser);
	}

	public User getUser(User user) throws DataAccessException {
		return (User) getSqlMapClientTemplate().queryForObject("getUser", user);
	}


	public void createFriend(Friend friend) throws DataAccessException {
		getSqlMapClientTemplate().insert("createFriend",friend);
		
	}

	@SuppressWarnings("unchecked")
	public List<Long> getStars() throws DataAccessException {
		
		return (List<Long>)getSqlMapClientTemplate().queryForList("getStars");
	}

	public void deleteFriend(Friend friend) throws DataAccessException {
		
		getSqlMapClientTemplate().delete("deleteFriend", friend);
		
	}

	public int countMyFans(Long id) throws DataAccessException {
		int count =(Integer) getSqlMapClientTemplate().queryForObject("countMyFans",id);
		return count;
	}

	public int countMySubscibeUsers(Long id) throws DataAccessException {
		int count =(Integer) getSqlMapClientTemplate().queryForObject("countMySubscibeUsers",id);
		return count;
	}


	public void getSimilars(Pagination<User> pagination)
			throws DataAccessException {
		if (pagination.getCondition() != null) {
			User user = (User) pagination.getCondition();

		}

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countSimilars", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<User> list;

			list = getSqlMapClientTemplate().queryForList("getSimilars",
					pagination);

			pagination.setResults(list);
		}
		
	}


}
