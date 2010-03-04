package com.video.dao.ibatis;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.SafeCodeDao;
import com.video.domain.SafeCode;

public class SafeCodeDaoImpl extends SqlMapClientDaoSupport implements
		SafeCodeDao {

	public void createSafeCode(SafeCode safeCode) throws DataAccessException {
		getSqlMapClientTemplate().insert("createSafeCode", safeCode);
	}

	public void deleteSafeCodeByCode(String code) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteSafeCodeByCode", code);
		
	}

	public SafeCode getSafeCodeByCode(String code) throws DataAccessException {
		
		return (SafeCode) getSqlMapClientTemplate().queryForObject("getSafeCodeByCode", code);
	}

	

	

}
