package com.video.domain.connection;

import java.io.Serializable;

public class DailyAndTag implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8476646646165127513L;
	private Long dailyId;
	private Long tagId;

	public Long getDailyId() {
		return dailyId;
	}

	public void setDailyId(Long dailyId) {
		this.dailyId = dailyId;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
}
