package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.UserKeywordDao;
import com.video.domain.UserKeyword;

public class UserKeywordDaoImpl extends SqlMapClientDaoSupport implements UserKeywordDao {

	public void createUserKeyword(UserKeyword userKeyword)
			throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public void deleteUserKeywordByName(String Name) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}

	public List<UserKeyword> getUserKeywords() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
