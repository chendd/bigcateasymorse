package com.video.domain;

import java.io.Serializable;

public class VideoAndPlayBill implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long playBillId;
	private Long videoId;
	public Long getPlayBillId() {
		return playBillId;
	}
	public void setPlayBillId(Long playBillId) {
		this.playBillId = playBillId;
	}
	public Long getVideoId() {
		return videoId;
	}
	public void setVideoId(Long videoId) {
		this.videoId = videoId;
	}
	
	public VideoAndPlayBill() {
		
	}

}
