package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.DailyTagDao;
import com.video.domain.Daily;
import com.video.domain.DailyTag;
import com.video.util.Pagination;

public class DailyTagDaoImpl extends SqlMapClientDaoSupport implements DailyTagDao {

	public void createDailyTag(DailyTag tag) throws DataAccessException {
		getSqlMapClientTemplate().insert("createDailyTag", tag);

	}

	public void deleteDailyTag(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteDailyTag", id);

	}

	public DailyTag getDailyTagById(Long id) throws DataAccessException {
		return (DailyTag) getSqlMapClientTemplate().queryForObject("getDailyTagById", id);
	}
	@SuppressWarnings("unchecked")
	public void getDailyTags(Pagination<DailyTag> pagination) throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countDailyTag");
  
		pagination.setRecordSum(count);
		if (count > 0) {
			List<DailyTag> list;

			list = getSqlMapClientTemplate()
					.queryForList("getDailyTags", pagination);

			pagination.setResults(list);
		}
	}

	public void updateDailyTag(DailyTag tag) throws DataAccessException {
		getSqlMapClientTemplate().update("updateDailyTag",tag);

	}

	@SuppressWarnings("unchecked")
	public List<Daily> getDailysByTagId(Long id) throws DataAccessException {
		
		return (List<Daily>)getSqlMapClientTemplate().queryForList("getDailysByTagId",id);
	}


	public DailyTag getDailyTagByName(String name) throws DataAccessException {
		return (DailyTag) getSqlMapClientTemplate().queryForObject("getDailyTagByName", name);
	}

	public void deleteDailyTagByDailyId(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteDailyTagByDailyId", id);
		
	}
	@SuppressWarnings("unchecked")
	public List<DailyTag> getDailyTagsByUser(Long id)
			throws DataAccessException {
	
		return (List<DailyTag>)getSqlMapClientTemplate().queryForList("getDailyTagsByUser", id);
	}

}
