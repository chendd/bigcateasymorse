package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.UserKeyword;

public interface UserKeywordDao {

	public void createUserKeyword(UserKeyword userKeyword)
			throws DataAccessException;

	public void deleteUserKeywordByName(String Name) throws DataAccessException;

	public List<UserKeyword> getUserKeywords() throws DataAccessException;

	public List<UserKeyword> getUserSearchWithForeFront(int size)
			throws DataAccessException;

	public UserKeyword getUserKeywordByName(UserKeyword userKeyword)
			throws DataAccessException;

	public void updateUserSearch(UserKeyword userKeyword)
			throws DataAccessException;

}
