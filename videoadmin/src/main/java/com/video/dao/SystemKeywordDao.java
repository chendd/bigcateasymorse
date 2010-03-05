package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.SystemKeyword;
import com.video.util.Pagination;

public interface SystemKeywordDao {

	public void createSystemKeyword(SystemKeyword systemKeyword)
			throws DataAccessException;

	public void updateSystemKeyword(SystemKeyword systemKeyword)
			throws DataAccessException;

	public void deleteSystemKeyword(Long id) throws DataAccessException;

	public SystemKeyword getSystemKeywordById(Long id)
			throws DataAccessException;

	public void getSystemKeywords(Pagination<SystemKeyword> pagination)
			throws DataAccessException;

	public List<SystemKeyword> getSystemKeywordByChannelId(Long id)
			throws DataAccessException;

	public void deleteSystemKeywordByChannelId(Long id)
			throws DataAccessException;

}
