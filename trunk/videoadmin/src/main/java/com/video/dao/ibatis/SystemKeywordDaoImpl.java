package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.SystemKeywordDao;
import com.video.domain.SystemKeyword;
import com.video.util.Pagination;

public class SystemKeywordDaoImpl extends SqlMapClientDaoSupport implements
		SystemKeywordDao {

	public void createSystemKeyword(SystemKeyword systemKeyword)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createSystemKeyword", systemKeyword);
	}

	public void deleteSystemKeyword(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteSystemKeyword", id);

	}

	public SystemKeyword getSystemKeywordById(Long id)
			throws DataAccessException {
		return (SystemKeyword) getSqlMapClientTemplate().queryForObject(
				"getSystemKeywordById", id);
	}

	public void getSystemKeywords(Pagination<SystemKeyword> pagination)
			throws DataAccessException {
		// TODO Auto-generated method stub
	}

	public void updateSystemKeyword(SystemKeyword systemKeyword)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateSystemKeyword", systemKeyword);
	}

	public void deleteSystemKeywordByChannelId(Long id)
			throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteSystemKeywordByChannelId", id);
	}

	public List<SystemKeyword> getSystemKeywordByChannelId(Long id)
			throws DataAccessException {
		List<SystemKeyword> list = getSqlMapClientTemplate().queryForList(
				"getSystemKeywordByChannelId", id);
		return list;
	}

}
