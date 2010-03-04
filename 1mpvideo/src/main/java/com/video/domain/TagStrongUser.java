package com.video.domain;

import java.io.Serializable;

public class TagStrongUser implements Serializable {

	/**
	 * 标签强人
	 */
	private static final long serialVersionUID = 1L;
	private int countTag;
	private User user;

	public int getCountTag() {
		return countTag;
	}

	public void setCountTag(int countTag) {
		this.countTag = countTag;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
