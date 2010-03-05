package com.video.domain;

import java.io.Serializable;
import java.util.*;

public class Comment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;// 记录ID
	private Video video;// 对应视频
	private User user;// 操作用户
	private Date commentDate;// 评论时间
	private String comment;// 评论内容

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}