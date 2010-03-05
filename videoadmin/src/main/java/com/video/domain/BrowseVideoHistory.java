package com.video.domain;

import java.io.Serializable;
import java.util.*;

public class BrowseVideoHistory implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Video video;
	private User user;
	private Date browseDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Date getBrowseDate() {
		return browseDate;
	}

	public void setBrowseDate(Date browseDate) {
		this.browseDate = browseDate;
	}
	
	public BrowseVideoHistory() {
	}

}