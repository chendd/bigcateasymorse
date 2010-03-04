package com.video.dao;

import org.springframework.dao.DataAccessException;

import com.video.domain.SafeCode;

public interface SafeCodeDao {
	
	public void createSafeCode(SafeCode safeCode) throws DataAccessException;
	
	public void deleteSafeCodeByCode(String code) throws DataAccessException;

	
	public SafeCode getSafeCodeByCode(String code) throws DataAccessException;
	

	


}
