package com.video.domain;

import java.io.Serializable;
import java.util.Date;

public class CollectionVideo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;//操作用户
	private Video video;//收藏视频
	private Date collectionDate;//收藏时间

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public Date getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(Date collectionDate) {
		this.collectionDate = collectionDate;
	}

}