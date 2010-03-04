package com.video.domain.connection;

import java.io.Serializable;

public class VideoAndTag implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -906431970676723343L;

	private Long tagId;
	private Long videoId;

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public Long getVideoId() {
		return videoId;
	}

	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}

}
