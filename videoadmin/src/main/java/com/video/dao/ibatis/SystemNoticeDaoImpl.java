package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.SystemNoticeDao;
import com.video.domain.SystemNotice;
import com.video.domain.User;
import com.video.util.Pagination;

public class SystemNoticeDaoImpl extends SqlMapClientDaoSupport implements
		SystemNoticeDao {

	public void createSystemNotice(SystemNotice systemNotice)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createSystemNotice", systemNotice);

	}

	

	public void getSystemNotices(Pagination<SystemNotice> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countSystemNotices", pagination);
	

		pagination.setRecordSum(count);
		if (count > 0) {
			List<SystemNotice> list;

			list = getSqlMapClientTemplate().queryForList(
					"getSystemNotices", pagination);

			pagination.setResults(list);
		}

	}



	public void deleteSystemNoticeByDate(int dayNum) throws DataAccessException {
		getSqlMapClientTemplate().delete("", dayNum);
		
	}



	public void deleteSystemNoticeByGrade(User user) throws DataAccessException {
		getSqlMapClientTemplate().delete("", user);
		
	}



	@Override
	public SystemNotice getSystemNoticeById(Long id) throws DataAccessException {
		
		return (SystemNotice)getSqlMapClientTemplate().queryForObject("getSystemNoticeById",id);
	}



	public void deleteSystemNoticeBySendDate(SystemNotice systemNotice)
			throws DataAccessException {
	getSqlMapClientTemplate().delete("deleteSystemNoticeBySendDate", systemNotice);
		
	}



	

}
