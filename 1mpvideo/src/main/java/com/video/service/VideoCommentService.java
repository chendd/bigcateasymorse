package com.video.service;

import org.springframework.dao.DataAccessException;

import com.video.domain.Comment;
import com.video.util.Pagination;

public interface VideoCommentService {
	public void getCommentByVideoId(Pagination<Comment> pagination)
			throws DataAccessException;

	public void createComment(Comment comment) throws DataAccessException;
}
