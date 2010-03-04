package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.EventDao;
import com.video.domain.DailyComment;
import com.video.domain.Event;
import com.video.util.Pagination;

public class EventDaoImpl extends SqlMapClientDaoSupport implements EventDao {

	public void createEvent(Event event) throws DataAccessException {
		getSqlMapClientTemplate().insert("createEvent", event);

	}

	public void deleteEvent(Long id) throws DataAccessException {
		getSqlMapClientTemplate().insert("createEvent", id);

	}

	@SuppressWarnings("unchecked")
	public void getEvents(Pagination<Event> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countEvents", pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<Event> list;
			list = getSqlMapClientTemplate().queryForList("getEvents",
					pagination);
			pagination.setResults(list);
		}

	}

	@SuppressWarnings("unchecked")
	public List<Event> getLastEvents() throws DataAccessException {
		List<Event> events = getSqlMapClientTemplate().queryForList(
				"getLastEvents");
		return events;
	}

}
