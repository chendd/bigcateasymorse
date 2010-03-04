package com.video.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.DailyAndTagDao;
import com.video.domain.connection.DailyAndTag;

public class DailyAndTagDaoImpl extends SqlMapClientDaoSupport implements
		DailyAndTagDao {

	public void createDailyAndTag(DailyAndTag dailyAndTag) {
		getSqlMapClientTemplate().insert("createDailyAndTag", dailyAndTag);
	}

	public void deleteDailyAndTagByDailyId(Long id) {
		getSqlMapClientTemplate().delete("deleteDailyAndTagByDailyId", id);
	}

	public void deleteDailyAndTagByDailyIdAndTagId(DailyAndTag dailyAndTag) {
		getSqlMapClientTemplate().delete("deleteDailyAndTagByDailyIdAndTagId",
				dailyAndTag);
	}

	public void deleteDailyAndTagByTagId(Long id) {
		getSqlMapClientTemplate().delete("deleteDailyAndTagByTagId", id);
	}

	public List<DailyAndTag> getDailyAndTagByDailyId(Long id) {
		List<DailyAndTag> dailyAndTagList = (List<DailyAndTag>) getSqlMapClientTemplate()
				.queryForList("getDailyAndTagByDailyId", id);
		return dailyAndTagList;
	}

	public List<DailyAndTag> getDailyAndTagByTagId(Long id) {
		List<DailyAndTag> dailyAndTagList = (List<DailyAndTag>) getSqlMapClientTemplate()
				.queryForList("getDailyAndTagByTagId", id);
		return dailyAndTagList;
	}

}
