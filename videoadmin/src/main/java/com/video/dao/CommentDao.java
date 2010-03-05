package com.video.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.video.domain.Comment;
import com.video.util.Pagination;

public interface CommentDao {
	
	public void createComment(Comment comment) throws DataAccessException;
	
	public void updateComment(Comment comment) throws DataAccessException;
	
	public void deleteComment(Long id) throws DataAccessException;
	
	public void getComments(Pagination<Comment> pagination) throws DataAccessException;
	
	public List<Comment> getCommentsByVideoId(Long id) throws DataAccessException;
	

 
}
