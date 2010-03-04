package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.SystemNoticeDao;
import com.video.domain.BlogWord;
import com.video.domain.SystemNotice;
import com.video.util.Pagination;

public class SystemNoticeDaoImpl extends SqlMapClientDaoSupport implements
		SystemNoticeDao {

	public void createSystemNotice(SystemNotice systemNotice)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createSystemNotice", systemNotice);

	}

	public void deleteSystemNoticeByUserId(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteSystemNoticeById", id);

	}

	public void getSystemNoticesByUserId(Pagination<SystemNotice> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countSystemNoticesByUserId", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<SystemNotice> list;

			list = getSqlMapClientTemplate().queryForList(
					"getSystemNoticesByUserId", pagination);

			pagination.setResults(list);
		}

	}

	public void updateSystemNotice(SystemNotice systemNotice)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("updateSystemNotice", systemNotice);

	}

	public SystemNotice getSystemNoticeById(Long id) throws DataAccessException {

		return (SystemNotice) getSqlMapClientTemplate().queryForObject(
				"getSystemNoticeById", id);
	}

	public int countNewNotice(Long id) throws DataAccessException {
		
		return (Integer) getSqlMapClientTemplate().queryForObject("countNewNotice",id);
	}

	public void updateSystemNoticeById(SystemNotice systemNotice)
			throws DataAccessException {
	getSqlMapClientTemplate().update("updateSystemNoticeById", systemNotice);
		
	}

}
