package com.video.dao.ibatis;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.TopicDao;
import com.video.domain.Topic;
import com.video.domain.User;
import com.video.util.Pagination;

public class TopicDaoImpl extends SqlMapClientDaoSupport implements TopicDao {

	public void createTopic(Topic topic) throws DataAccessException {
		getSqlMapClientTemplate().insert("createTopic", topic);

	}

	public void deleteTopic(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteTopicById", id);

	}

	public Topic getTopicById(Long id) throws DataAccessException {
		return (Topic)getSqlMapClientTemplate().queryForObject("getTopicById", id);
	}

	public void getTopices(Pagination<Topic> pagination)
			throws DataAccessException {
		if(pagination.getCondition()!=null){
			Topic topic = (Topic) pagination.getCondition();
			
			if (topic.getTitle() != null && !topic.getTitle().isEmpty()) {
				topic.setTitle(MessageFormat.format("%{0}%", topic.getTitle()
						.replaceAll("%", "!%").replaceAll("!", "!!")));
			}
			
			
		}
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countTopic",pagination);

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


	public void getMyGroupTopices(Pagination<Topic> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
		"countMyGroupTopic");

pagination.setRecordSum(count);
if (count > 0) {
	List<Topic> list;

	list = this.getSqlMapClientTemplate().queryForList("getMyGroupTopices",
			pagination);

	pagination.setResults(list);

}
		
	}

	
	public void getTopicesByGroupId(Pagination<Topic> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
		"countTopicesByGroupId",pagination);

pagination.setRecordSum(count);
if (count > 0) {
	List<Topic> list;

	list = this.getSqlMapClientTemplate().queryForList("getTopicesByGroupId",
			pagination);

	pagination.setResults(list);

}
	}

	public void deleteTopicByGroupId(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteTopicByGroupId", id);
		
	}

	public List<Topic> getTopicesByDaily(Long id) throws DataAccessException {
		
		return this.getSqlMapClientTemplate().queryForList("getTopicesByDaily",
				id);
	}

}
