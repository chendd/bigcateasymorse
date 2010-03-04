package com.video.service;

import org.springframework.dao.DataAccessException;

import com.video.dao.CommentDao;
import com.video.domain.Comment;
import com.video.util.Pagination;

public class VideoCommentServiceImpl implements VideoCommentService {
	private CommentDao commentDao;

	public CommentDao getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDao commentDao) {
		this.commentDao = commentDao;
	}

	public void getCommentByVideoId(Pagination<Comment> pagination)
			throws DataAccessException {
		this.commentDao.getCommentByVideoId(pagination);
	}

	public void createComment(Comment comment) throws DataAccessException {
		this.commentDao.createComment(comment);
	}

}
