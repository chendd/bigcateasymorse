package com.video.dao.ibatis;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.video.dao.CommentDao;
import com.video.domain.Comment;
import com.video.domain.Topic;
import com.video.util.Pagination;

public class CommentDaoImpl extends SqlMapClientDaoSupport implements
		CommentDao {

	public void createComment(Comment comment) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	public void deleteComment(Long id) throws DataAccessException {

		getSqlMapClientTemplate().delete("deleteCommentById", id);

	}

	public void getComments(Pagination<Comment> pagination)
			throws DataAccessException {
		int count = (Integer) getSqlMapClientTemplate().queryForObject(
				"countComment");

		pagination.setRecordSum(count);
		if (count > 0) {
			List<Comment> list;

			list = this.getSqlMapClientTemplate().queryForList("getComments",
					pagination);

			pagination.setResults(list);

		}
	}

	public void updateComment(Comment comment) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Comment> getCommentsByVideoId(Long id)
			throws DataAccessException {

		return getSqlMapClientTemplate().queryForList("getCommentsByVideoId",
				id);
	}

}
