package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.UserKeywordDao;
import com.video.domain.UserKeyword;

public class UserKeywordDaoImpl extends SqlMapClientDaoSupport implements
		UserKeywordDao {

	public void createUserKeyword(UserKeyword userKeyword)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createUserSearch", userKeyword);
	}

	public void deleteUserKeywordByName(String Name) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public List<UserKeyword> getUserKeywords() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserKeyword> getUserSearchWithForeFront(int size)
			throws DataAccessException {

		return getSqlMapClientTemplate().queryForList(
				"getUserSearchWithForeFront", size);
	}

	public UserKeyword getUserKeywordByName(UserKeyword userKeyword)
			throws DataAccessException {
		return (UserKeyword) getSqlMapClientTemplate().queryForObject(
				"getUserSearchByName", userKeyword);
	}

	public void updateUserSearch(UserKeyword userKeyword)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateUserSearch", userKeyword);
	}

}
