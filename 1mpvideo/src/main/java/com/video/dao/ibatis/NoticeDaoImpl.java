package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.NoticeDao;
import com.video.dao.TagDao;
import com.video.domain.Notice;
import com.video.domain.Tag;
import com.video.domain.TagStrongUser;
import com.video.domain.Video;
import com.video.util.Pagination;

public class NoticeDaoImpl extends SqlMapClientDaoSupport implements NoticeDao {

	@Override
	public List<Notice> getNotices() throws DataAccessException {

		return this.getSqlMapClientTemplate().queryForList("getNotices");
	}

	

}
