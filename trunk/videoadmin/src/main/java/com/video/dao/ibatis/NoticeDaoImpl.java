package com.video.dao.ibatis;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.NoticeDao;
import com.video.domain.Notice;

public class NoticeDaoImpl extends SqlMapClientDaoSupport implements NoticeDao {

	@Override
	public void createNotice(Notice notice) throws DataAccessException {
		getSqlMapClientTemplate().insert("createNotice", notice);
		
	}

	public void deleteNoticeById(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteNoticeById", id);
		
	}

	public List<Notice> getNotices() throws DataAccessException {
		List<Notice> notices = (List<Notice>)getSqlMapClientTemplate().queryForList("getNotices");
		return notices;
	}

	public void updateNotice(Notice notice) throws DataAccessException {
		getSqlMapClientTemplate().update("updateNotice", notice);
		
	}

	public Notice getNoticeById(Long id) throws DataAccessException {
	
		return (Notice)this.getSqlMapClientTemplate().queryForObject("getNoticeById",id);
	}


	
}
