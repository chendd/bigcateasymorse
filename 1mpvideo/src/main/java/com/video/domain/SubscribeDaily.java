package com.video.domain;

import java.io.Serializable;
import java.util.*;

/** @pdOid c4483c90-0f5f-47b2-8aae-0ad58ca77ec7 */
public class SubscribeDaily implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;//操作用户
	private User subscribeUser;//被订阅用户
	private Date subscribeDate;//订阅时间

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User getSubscribeUser() {
		return subscribeUser;
	}

	public void setSubscribeUser(User subscribeUser) {
		this.subscribeUser = subscribeUser;
	}

	public Date getSubscribeDate() {
		return subscribeDate;
	}

	public void setSubscribeDate(Date subscribeDate) {
		this.subscribeDate = subscribeDate;
	}

	public SubscribeDaily() {
	}

}