package com.video.domain;

import java.io.Serializable;
import java.util.*;

/** @pdOid 8b0cdcc6-2bc8-4409-ab90-1a1c7af6b10e */
public class UploadVideo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;//视频ID
	
	private String url;//视频地址
	private String videoType;//视频格式
	private int videoTime;//视频时间
	private int stauts;//视频状态
	private int num3gp;//转成3gp的数量
	private Video video;//对应的FLV视频
	private int convertStatus;//转换状态
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getVideoType() {
		return videoType;
	}
	public void setVideoType(String videoType) {
		this.videoType = videoType;
	}
	
	public int getVideoTime() {
		return videoTime;
	}
	public void setVideoTime(int videoTime) {
		this.videoTime = videoTime;
	}
	
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public int getStauts() {
		return stauts;
	}
	public void setStauts(int stauts) {
		this.stauts = stauts;
	}
	public int getNum3gp() {
		return num3gp;
	}
	public void setNum3gp(int num3gp) {
		this.num3gp = num3gp;
	}

	
	public UploadVideo() {
	}
	public int getConvertStatus() {
		return convertStatus;
	}
	public void setConvertStatus(int convertStatus) {
		this.convertStatus = convertStatus;
	}

}