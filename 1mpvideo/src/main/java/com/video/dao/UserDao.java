package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;


import com.video.domain.Friend;
import com.video.domain.SubscribeUser;
import com.video.domain.User;
import com.video.domain.UserLevel;
import com.video.util.Pagination;

public interface UserDao {

	public User createUser(User user) throws DataAccessException;

	public void updateUser(User user) throws DataAccessException;

	public void deleteUser(Long id) throws DataAccessException;

	public User getUserById(Long id) throws DataAccessException;

	public User getUser2ById(Long id) throws DataAccessException;

	public User getUserByName(String userName) throws DataAccessException;

	public User getUserByEmail(String email) throws DataAccessException;

	public User getUserByRealName(String realName) throws DataAccessException;

	public void getUsers(Pagination<User> pagination)
			throws DataAccessException;

	public void getUsers2(Pagination<User> pagination)
			throws DataAccessException;

	public void listUsers(Pagination<User> pagination)
			throws DataAccessException;
	
	public Long getFriendId(Friend friend)throws DataAccessException;
	
	public void createFriend(Friend friend) throws DataAccessException;
 

	public List<UserLevel> getUserLevels() throws DataAccessException;


	public void getFriends(Pagination<User> pagination)
			throws DataAccessException;

	public void getSubscribeUser(Pagination<SubscribeUser> pagination)
			throws DataAccessException;

	public void getUsersOrderByNewVideo(Pagination<User> pagination)
			throws DataAccessException;

	public void getUsersOrderByBrowseTimes(Pagination<User> pagination)
			throws DataAccessException;

	public void getUsersOrderByCommentCount(Pagination<User> pagination)
			throws DataAccessException;

	public User getUserUsePlaybillById(User user) throws DataAccessException;

	public void getOtherUserByVideoId(Pagination<User> pagination)
			throws DataAccessException;

	public void createSubscribe(SubscribeUser subscribeUser)
			throws DataAccessException;
	
	public void deleteSubscribe(SubscribeUser subscribeUser)
	throws DataAccessException;

	public SubscribeUser getSubscribe(SubscribeUser subscribeUser)
			throws DataAccessException;

	public User getUser(User user) throws DataAccessException;
	
	public List<Long> getStars() throws DataAccessException;
	
	public void deleteFriend(Friend friend) throws DataAccessException;
	
	public int countMySubscibeUsers(Long id) throws DataAccessException;
	
	public int countMyFans(Long id) throws DataAccessException;
	
	public void getSimilars(Pagination<User> pagination)
	throws DataAccessException;
	

}
