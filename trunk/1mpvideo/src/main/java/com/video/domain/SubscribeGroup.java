package com.video.domain;

import java.io.Serializable;
import java.util.*;

public class SubscribeGroup implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;//操作用户
	private Group group;//被订阅圈子
	private Date subscribeDate;//订阅时间

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Date getSubscribeDate() {
		return subscribeDate;
	}

	public void setSubscribeDate(Date subscribeDate) {
		this.subscribeDate = subscribeDate;
	}
public SubscribeGroup() {
}
}