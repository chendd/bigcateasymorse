package com.video.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.DailyChannelDao;
import com.video.domain.Administrator;
import com.video.domain.DailyChannel;
import com.video.util.Pagination;

public class DailyChannelDaoImpl extends SqlMapClientDaoSupport implements
		DailyChannelDao {

	public void createDailyChannel(DailyChannel dailyChannel)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createDailyChannel", dailyChannel);
	}

	public void deleteDailyChannel(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteDailyChannel", id);
	}

	public DailyChannel getDailyChannelById(Long id) throws DataAccessException {
		DailyChannel dailyChannel = (DailyChannel) getSqlMapClientTemplate()
				.queryForObject("getDailyChannelById", id);
		return dailyChannel;
	}

	public List<DailyChannel> getDailyChannels() throws DataAccessException {
		List<DailyChannel> dailyChannelList = null;
		try {
			dailyChannelList = getSqlMapClient().queryForList(
					"getDailyChannels");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dailyChannelList;
	}

	public void updateDailyChannel(DailyChannel dailyChannel)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateDailyChannel", dailyChannel);
	}

	public void getDailyChannelPage(Pagination<DailyChannel> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countDailyChannel");

		pagination.setRecordSum(count);
		if (count > 0) {
			List<DailyChannel> list;
			try {
				list = this.getSqlMapClient().queryForList(
						"getDailyChannelPage", pagination);
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			pagination.setResults(list);
		}
	}

	public List<DailyChannel> getRootDailyChannels() throws DataAccessException {
		List<DailyChannel> rootDailyChannelList = getSqlMapClientTemplate()
				.queryForList("getRootDailyChannels");
		return rootDailyChannelList;
	}

	public void updateDailyChannelOrders(DailyChannel dailyChannel)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateDailyChannelOrders",
				dailyChannel);
	}

	public List<DailyChannel> getDailyChannelsByParentId(Long parentId)
			throws DataAccessException {
		List<DailyChannel> childDailyChannelList = getSqlMapClientTemplate()
				.queryForList("getDailyChannelsByParentId", parentId);
		return childDailyChannelList;
	}

	public void updateRepositionDailyChannelOrders() throws DataAccessException {
		getSqlMapClientTemplate().update("repositionDailyChannelOrders");

	}

	public DailyChannel getParentDailyChannel(DailyChannel dailyChannel)
			throws DataAccessException {
		DailyChannel parentDailyChannel = (DailyChannel) getSqlMapClientTemplate()
				.queryForObject("getParentDailyChannel", dailyChannel);
		return parentDailyChannel;
	}

	public void updateUniteDailyChannel(DailyChannel dailyChannel)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateUniteDailyChannel",
				dailyChannel);
	}

}
