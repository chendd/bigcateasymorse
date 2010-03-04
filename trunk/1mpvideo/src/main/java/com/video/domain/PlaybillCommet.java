package com.video.domain;

import java.io.Serializable;
import java.util.Date;

public class PlaybillCommet implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4409685806982736523L;
	private int id;// 记录ID
	private Playbill playbill;// 对应节目单
	private User user;// 操作用户
	private Date commentDate;// 评论时间
	private String comment;// 评论内容

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Playbill getPlaybill() {
		return playbill;
	}

	public void setPlaybill(Playbill playbill) {
		this.playbill = playbill;
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
