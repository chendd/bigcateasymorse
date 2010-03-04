package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.TagDao;
import com.video.domain.Tag;
import com.video.domain.TagStrongUser;
import com.video.domain.Video;
import com.video.util.Pagination;

public class TagDaoImpl extends SqlMapClientDaoSupport implements TagDao {

	public void createTag(Tag tag) throws DataAccessException {
		getSqlMapClientTemplate().insert("createTag", tag);

	}

	public void deleteTag(Long id) throws DataAccessException {
		getSqlMapClientTemplate().delete("deleteTag", id);

	}

	public Tag getTagById(Long id) throws DataAccessException {
		return (Tag) getSqlMapClientTemplate().queryForObject("getTagById", id);
	}

	public void getTags(Pagination<Tag> pagination) throws DataAccessException {

		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countTag",pagination);

		pagination.setRecordSum(count);
		if (count > 0) {
			List<Tag> list;
			list = getSqlMapClientTemplate()
					.queryForList("getTags", pagination);
			pagination.setResults(list);
		}
	}

	public void updateTag(Tag tag) throws DataAccessException {
		getSqlMapClientTemplate().update("updateTag", tag);

	}

	public List<Video> getVideoesByTagId(Long id) throws DataAccessException {

		return (List<Video>) getSqlMapClientTemplate().queryForList(
				"getVideoesByTagId", id);
	}

	public Tag getTagByName(String name) throws DataAccessException {
		return (Tag) getSqlMapClientTemplate().queryForObject("getTagByName",
				name);
	}

	public List<Tag> getLikeVideoTag(int size) throws DataAccessException {
		return (List<Tag>) getSqlMapClientTemplate().queryForList(
				"getLikeVideoTag", size);
	}

	public List<TagStrongUser> getTagStrongUser(int size)
			throws DataAccessException {
		return (List<TagStrongUser>) getSqlMapClientTemplate().queryForList(
				"getTagStrongUser", size);
	}

	public List<Tag> getTagsByVideo(Long id) throws DataAccessException {
	
		return this.getSqlMapClientTemplate().queryForList("getTagsByVideo",id);
	}

}
