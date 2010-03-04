package com.video.domain;

import java.io.Serializable;
import java.util.Date;

public class IsSubscribe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long userId;
	private Long playbillId;
	private Date addDate;

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPlaybillId() {
		return playbillId;
	}

	public void setPlaybillId(Long playbillId) {
		this.playbillId = playbillId;
	}

}
