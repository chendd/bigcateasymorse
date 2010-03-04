package com.video.domain;

import java.io.Serializable;
import java.util.*;

/** @pdOid 12b57d43-368d-413a-a6bf-3a6696553707 */
public class Video implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String url;
	private Date addDate;
	private int browseCount;
	private VideoChannel channel;
	private UploadVideo uploadVideo;
	private User user;
	private int videoTime;
	private int videoSize;
	private int notify;
	private int point;
	private int pushCount;
	private String password;
	private String description;
	private int flag;
	private String image;
	private int commentCount;
	private int collectionCount;

	public int getCommentCount() {
		return commentCount;
	}                                                                                                                         

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public int getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(int browseCount) {
		this.browseCount = browseCount;
	}

	public VideoChannel getChannel() {
		return channel;
	}

	public Long getChannelId() {
		if (this.channel == null) {
			this.channel = new VideoChannel();
		}
		return this.channel.getId();
	}

	public void setChannelId(Long id) {
		if (this.channel == null) {
			this.channel = new VideoChannel();
		}
		this.channel.setId(id);
	}

	public void setChannel(VideoChannel channel) {
		this.channel = channel;
	}

	public UploadVideo getUploadVideo() {
		return uploadVideo;
	}

	public Long getUploadVideoId() {
		if (this.uploadVideo == null) {
			this.uploadVideo = new UploadVideo();
		}
		return this.uploadVideo.getId();
	}

	public void setUploadVideoId(Long id) {
		if (this.uploadVideo == null) {
			this.uploadVideo = new UploadVideo();
		}
		this.uploadVideo.setId(id);
	}

	public void setUploadVideo(UploadVideo uploadVideo) {
		this.uploadVideo = uploadVideo;
	}

	public User getUser() {
		return user;
	}

	public Long getUserId() {
		if (this.user == null) {
			this.user = new User();
		}
		return this.user.getId();
	}

	public void setUserId(Long id) {
		if (this.user == null) {
			this.user = new User();
		}
		this.user.setId(id);
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getVideoTime() {
		return videoTime;
	}

	public void setVideoTime(int videoTime) {
		this.videoTime = videoTime;
	}

	public int getVideoSize() {
		return videoSize;
	}

	public void setVideoSize(int videoSize) {
		this.videoSize = videoSize;
	}

	public int getNotify() {
		return notify;
	}

	public void setNotify(int notify) {
		this.notify = notify;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPushCount() {
		return pushCount;
	}

	public void setPushCount(int pushCount) {
		this.pushCount = pushCount;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Video() {
	}

	public int getCollectionCount() {
		return collectionCount;
	}

	public void setCollectionCount(int collectionCount) {
		this.collectionCount = collectionCount;
	}

}