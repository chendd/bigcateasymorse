package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.DailyHistoryDao;
import com.video.domain.DailyHistory;
import com.video.util.Pagination;

public class DailyHistoryDaoImpl extends SqlMapClientDaoSupport implements DailyHistoryDao{


	public void createDailyHistory(DailyHistory dailyHistory) throws DataAccessException {
		getSqlMapClientTemplate().insert("createDailyHistory", dailyHistory);
		
	}


	public void getDailyHistories(Pagination<DailyHistory> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countDailyHistory", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<DailyHistory> list;
			list = getSqlMapClientTemplate().queryForList("getDailyHistories",
					pagination);
			pagination.setResults(list);
		}
		
	}


	
	public void updateDailyHistory(DailyHistory dailyHistory)
			throws DataAccessException {
	
		getSqlMapClientTemplate().update("updateDailyHistory",dailyHistory);
		
	}



	public DailyHistory getDailyHistory(DailyHistory dailyHistory)
			throws DataAccessException {
		
		return (DailyHistory)getSqlMapClientTemplate().queryForObject("getDailyHistory",dailyHistory);
	}


	public void deleteDailyHistoryByDailyId(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteDailyHistoryByDailyId", id);
		
	}


	





	
}
