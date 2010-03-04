package com.video.domain;

import java.io.Serializable;
import java.util.*;

/** @pdOid 52e2c941-6811-40d2-aebf-278cbcad41ff */
public class DailyReply implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;// 记录ID
	private User user;// 回复用户
	private Daily daily;// 对应日志
	private String comment;// 回复内容
	private Date addDate;// 回复时间
	private int point;// 评分
	private int flag;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUserId(Long id) {
		if (this.user == null) {
			this.user = new User();
		}
		this.user.setId(id);
	}

	public Long getUserId() {
		if (this.user == null) {
			this.user = new User();
		}
		return this.user.getId();
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setDailyId(Long id) {
		if (this.daily == null) {
			this.daily = new Daily();
		}
		this.daily.setId(id);
	}

	public Long getDailyId() {
		if (this.daily == null) {
			this.daily = new Daily();
		}
		return this.daily.getId();
	}

	public Daily getDaily() {
		return daily;
	}

	public void setDaily(Daily daily) {
		this.daily = daily;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public DailyReply() {
	}

}