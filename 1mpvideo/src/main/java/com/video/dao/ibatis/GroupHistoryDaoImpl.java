package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.BlogHistoryDao;
import com.video.dao.GroupHistoryDao;
import com.video.domain.BlogHistory;
import com.video.domain.GroupHistory;
import com.video.util.Pagination;

public class GroupHistoryDaoImpl extends SqlMapClientDaoSupport implements GroupHistoryDao{


	public void createGroupHistory(GroupHistory groupHistory) throws DataAccessException {
		getSqlMapClientTemplate().insert("createGroupHistory", groupHistory);
		
	}


	public void getGroupHistories(Pagination<GroupHistory> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countGroupHistory", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<GroupHistory> list;
			list = getSqlMapClientTemplate().queryForList("getGroupHistories",
					pagination);
			pagination.setResults(list);
		}
		
	}


	
	public void updateGroupHistory(GroupHistory groupHistory)
			throws DataAccessException {
	
		getSqlMapClientTemplate().update("updateGroupHistory",groupHistory);
		
	}



	public GroupHistory getGroupHistory(GroupHistory groupHistory)
			throws DataAccessException {
		
		return (GroupHistory)getSqlMapClientTemplate().queryForObject("getGroupHistory",groupHistory);
	}


	public void deleteGroupHistoryByGoupId(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteGroupHistoryByGoupId", id);
		
	}





	
}
