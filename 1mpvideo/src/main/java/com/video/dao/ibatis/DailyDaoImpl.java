package com.video.dao.ibatis;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.DailyDao;
import com.video.domain.Daily;
import com.video.domain.DailyChannel;
import com.video.domain.DailyComment;
import com.video.domain.connection.DailyAndTag;
import com.video.util.Pagination;

public class DailyDaoImpl extends SqlMapClientDaoSupport implements DailyDao {

	public Daily createDaily(Daily daily) throws DataAccessException {
		getSqlMapClientTemplate().insert("createDaily", daily);
		return daily;
	}

	public void deleteDaily(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteDaily", id);
	}

	public void getDailies(Pagination<Daily> pagination)
			throws DataAccessException {
		if (pagination.getCondition() != null) {
			Daily daily = (Daily) pagination.getCondition();

			if (daily.getTitle() != null && !daily.getTitle().isEmpty()) {
				daily.setTitle(MessageFormat.format("%{0}%", daily.getTitle()
						.replaceAll("%", "!%").replaceAll("!", "!!")));
			}

			if (daily.getLog() != null && daily.getLog().isEmpty()) {
				daily.setLog(MessageFormat.format("%{0}%", daily.getLog()
						.replaceAll("%", "!%").replaceAll("!", "!!")));
			}
		}

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countDailies", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<Daily> list;
			list = getSqlMapClientTemplate().queryForList("getDailies",
					pagination);
			pagination.setResults(list);
		}
	}

	public Daily getDailyById(Long id) throws DataAccessException {
		Daily daily = (Daily) getSqlMapClientTemplate().queryForObject(
				"getDailyById", id);
		return daily;
	}

	public void updateDaily(Daily daily) throws DataAccessException {
		getSqlMapClientTemplate().update("updateDaily", daily);

	}

	public void updateDailyByChannelId(Daily daily) throws DataAccessException {
		getSqlMapClientTemplate()
				.update("updateDailyChannelByChannelId", daily);

	}

	public List<Daily> getDailysByChannelId(Long id) throws DataAccessException {
		List<Daily> dailyList = getSqlMapClientTemplate().queryForList(
				"getDailysByChannelId", id);
		return dailyList;
	}

	public void updateDailyCleanByChannelId(Long id) throws DataAccessException {
		getSqlMapClientTemplate().update("updateDailyCleanByChannelId", id);

	}

	public void deleteDailyByChannelId(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteDailyByChannelId", id);
	}

	public void updateDailyWithChannelIdById(Daily daily)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateDailyWithChannelIdById", daily);

	}

	public void updateDailyHotById(Daily daily) throws DataAccessException {
		getSqlMapClientTemplate().update("updateDailyHotById", daily);
	}

	public void updateDailyRecommendById(Daily daily)
			throws DataAccessException {
		getSqlMapClientTemplate().update("updateDailyRecommendById", daily);
	}

	public void updateDailyTopById(Daily daily) throws DataAccessException {
		getSqlMapClientTemplate().update("updateDailyTopById", daily);
	}

	public List<DailyChannel> getOtherDailyChannelByDailyId(Long id)
			throws DataAccessException {
		List<DailyChannel> dailyChannels = getSqlMapClientTemplate()
				.queryForList("getOtherDailyChannelByDailyId", id);
		return dailyChannels;
	}

	
	public void getMyDailies(Pagination<Daily> pagination)
			throws DataAccessException {
		

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countMyDaily", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<Daily> list;
			list = getSqlMapClientTemplate().queryForList("getMyDailies",
					pagination);
			int starIndex = pagination.getStartIndex();
			int pageNo = pagination.getNo();
			int endIndex = 0;
			if(pageNo == pagination.getPageSum()){
				endIndex = pagination.getRecordSum(); 
			}
			else{
				endIndex = starIndex+pagination.getSize();
			}
			
			pagination.setResults(list.subList(starIndex, endIndex));
		}
		
		
	}


	public void createDailyComment(DailyComment dailyComment)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createDailyComment",dailyComment);
		
	}


	public void deleteDailyCommentById(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteDailyCommentById", id);
		
	}


	public void getDailyComment(Pagination<DailyComment> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countDailyComments", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<DailyComment> list;
			list = getSqlMapClientTemplate().queryForList("getDailyComments",
					pagination);
			pagination.setResults(list);
		}
		
	}

	public void deleteDailyCommentByDailyId(Long id) throws DataAccessException {
	getSqlMapClientTemplate().delete("deleteDailyCommentByDailyId",id);
		
	}

	public void createDailyAndTag(DailyAndTag dailyAndTag)
			throws DataAccessException {
		getSqlMapClientTemplate().insert("createDailyAndTag", dailyAndTag);
	}

	public DailyAndTag getDailyAndTag(DailyAndTag dailyAndTag)
			throws DataAccessException {
		
		return (DailyAndTag) getSqlMapClientTemplate().queryForObject("getDailyAndTag", dailyAndTag);
	}

}
