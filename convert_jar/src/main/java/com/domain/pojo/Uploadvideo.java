package com.domain.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author <a href="mailto:jarrywin@gmail.com">Jarry Zheng</a>
 * 
 * 	$LastChangedBy$ $LastChangedDate$ $LastChangedRevision$ $HeadURL$
 * 
 * 	用户原始上传的视频类
 */
public class Uploadvideo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;// 视频ID

	private String url;// 视频地址
	private String videoType;// 视频格式
	private int videoTime;// 视频时间
	private int status;// 视频状态
	private int num3gp;// 转成3gp的数量
	private Video video = new Video();// 对应的FLV视频
	private int convertStatus;
	public int getConvertStatus() {
		return convertStatus;
	}
	public void setConvertStatus(int convertStatus) {
		this.convertStatus = convertStatus;
	}
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

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getNum3gp() {
		return num3gp;
	}
	public void setNum3gp(int num3gp) {
		this.num3gp = num3gp;
	}
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Uploadvideo() {
	}

}
