package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.TopicDao;
import com.video.domain.Topic;
import com.video.util.Pagination;

public class TopicDaoImpl extends SqlMapClientDaoSupport implements TopicDao {

	public void createTopic(Topic topic) throws DataAccessException {
		getSqlMapClientTemplate().delete("createTopic", topic);

	}

	public void deleteTopic(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteTopicById", id);

	}

	public Topic getTopicById(Long id) throws DataAccessException {
		return (Topic)getSqlMapClientTemplate().queryForObject("getTopicById", id);
	}

	public void getTopices(Pagination<Topic> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countTopic");

		pagination.setRecordSum(count);
		if (count > 0) {
			List<Topic> list;

			list = this.getSqlMapClientTemplate().queryForList("getTopices",
					pagination);

			pagination.setResults(list);

		}
	}

	public void updateTopic(Topic topic) throws DataAccessException {
		getSqlMapClientTemplate().update("updateTopic", topic);

	}

}
