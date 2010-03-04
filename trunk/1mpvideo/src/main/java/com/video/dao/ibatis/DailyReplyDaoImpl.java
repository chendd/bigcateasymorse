package com.video.dao.ibatis;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.DailyReplyDao;
import com.video.domain.DailyReply;
import com.video.util.Pagination;

public class DailyReplyDaoImpl extends SqlMapClientDaoSupport implements
		DailyReplyDao {

	public void createDailyReply(DailyReply dailyReply)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createDailyReply", dailyReply);
	}

	public void deleteDailyReplyById(long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteDailyReplyById", id);
	}

	public void getDailyReplies(Pagination<DailyReply> pagination)
			throws DataAccessException {
		if (pagination.getCondition() != null) {
			DailyReply dailyReply = (DailyReply) pagination.getCondition();

			if (dailyReply.getComment() != null
					&& !dailyReply.getComment().isEmpty()) {
				dailyReply.setComment(MessageFormat.format("%{0}%", dailyReply
						.getComment().replaceAll("%", "!%").replaceAll("!",
								"!!")));
			}
		}

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countDailyReply", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<DailyReply> list;
			list = getSqlMapClientTemplate().queryForList("getDailyReplies",
					pagination);
			pagination.setResults(list);
		}
	}

	public DailyReply getDailyReplyById(long id) throws DataAccessException {
		DailyReply dailyReply = (DailyReply) getSqlMapClientTemplate()
				.queryForObject("getDailyReplyById", id);
		return dailyReply;
	}

	public void updateDailyReplyById(DailyReply dailyReply)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateDailyReplyById", dailyReply);
	}

}
