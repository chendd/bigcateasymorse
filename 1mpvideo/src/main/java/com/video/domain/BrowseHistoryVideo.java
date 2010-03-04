package com.video.domain;

import java.io.Serializable;
import java.util.Date;

public class BrowseHistoryVideo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5259856415806070227L;
	private Video video;
	private User user;
	private Date addDate;

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

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
}
