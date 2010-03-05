package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.User;
import com.video.domain.UserLevel;
import com.video.domain.connection.Star;
import com.video.util.Pagination;

public interface UserDao {
	
	public User createUser(User user) throws DataAccessException;
	
	public void updateUser(User user) throws DataAccessException;
	
	public void deleteUser(Long id) throws DataAccessException;
	
	public User getUserById(Long id) throws DataAccessException;
	
	public User getUserByName(String userName) throws DataAccessException;
	
	public User getUserByEmail(String email) throws DataAccessException;
	
	public User getUserByRealName(String realName) throws DataAccessException;
	
	public void getUsers(Pagination<User> pagination) throws DataAccessException;

	
	public void listUsers(Pagination<User> pagination) throws DataAccessException;

	public List<UserLevel> getUserLevels()throws DataAccessException;
	
	public List<Long> getStarIds()throws DataAccessException;
	
	public void updateStar(Star star) throws DataAccessException;


}
