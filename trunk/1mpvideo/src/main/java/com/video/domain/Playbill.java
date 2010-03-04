package com.video.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/** @pdOid 3cf6d93f-d223-48b4-9d8f-3d6a6d800bb5 */
public class Playbill implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;// 节目单ID
	private String name;// 节目单名称
	private User user;// 添加用户
	private String description;// 节目单说明
	private String imagesUrl;// 图片
	private Date addDate;
	private Set<Video> videoes = new HashSet<Video>();
	private int flag = 1;
	private int videoSize;
	private int browseCount;
	private int commentCount;
	private PlaybillChannel channel;
	private int subscribeCount;

	public int getSubscribeCount() {
		return subscribeCount;
	}

	public void setSubscribeCount(int subscribeCount) {
		this.subscribeCount = subscribeCount;
	}

	public PlaybillChannel getChannel() {
		return channel;
	}

	public void setChannel(PlaybillChannel channel) {
		this.channel = channel;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public int getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(int browseCount) {
		this.browseCount = browseCount;
	}

	public int getVideoSize() {
		return videoSize;
	}

	public void setVideoSize(int videoSize) {
		this.videoSize = videoSize;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImagesUrl() {
		return imagesUrl;
	}

	public void setImagesUrl(String imagesUrl) {
		this.imagesUrl = imagesUrl;
	}

	public Set<Video> getVideoes() {
		return videoes;
	}

	public void setVideoes(Set<Video> videoes) {
		this.videoes = videoes;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

}