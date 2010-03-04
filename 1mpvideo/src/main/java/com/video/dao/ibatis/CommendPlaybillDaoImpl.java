package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.CommendPlaybillDao;
import com.video.domain.CommendPlaybill;
import com.video.domain.PlaybillCommet;
import com.video.util.Pagination;

public class CommendPlaybillDaoImpl extends SqlMapClientDaoSupport implements
		CommendPlaybillDao {

	public void createCommendPlaybill(CommendPlaybill commendPlaybill)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createCommendPlaybill",
				commendPlaybill);
	}

	public void deleteCommendPlaybill(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteCommendPlaybill", id);
	}

	public void updateCommendPlaybill(CommendPlaybill commendPlaybill)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateCommendPlaybill",
				commendPlaybill);
	}

	public List<CommendPlaybill> getCommendPlaybill()
			throws DataAccessException {
		return getSqlMapClientTemplate().queryForList("getCommendPlaybill");
	}

	public void getCommentPlaybillByPlaybillId(
			Pagination<PlaybillCommet> pagination) throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countCommentPlaybillByPlaybillId", pagination);
		pagination.setRecordSum(count);
		if (count > 0) {
			List<PlaybillCommet> list;
			list = this.getSqlMapClientTemplate().queryForList(
					"getCommentPlaybillByPlaybillId", pagination);
			pagination.setResults(list);
		}
	}

	public void updateCommendPlaybillWithBrowseCount(
			CommendPlaybill commendPlaybill) throws DataAccessException {
		this.getSqlMapClientTemplate().update(
				"updateCommendPlaybillWithBrowseCount", commendPlaybill);
	}

	public void createCommentPlaybill(PlaybillCommet commet)
			throws DataAccessException {
		this.getSqlMapClientTemplate().insert("createCommentPlaybill", commet);
	}
}
