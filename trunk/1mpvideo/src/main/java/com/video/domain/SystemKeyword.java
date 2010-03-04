package com.video.domain;

import java.io.Serializable;
import java.util.*;

public class SystemKeyword implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private KeywordChannel channel;
	private Date createDate;
	private int beforeYesterday;// 前天点击总数
	private int yesterday;// 昨天点击总数
	private int today;// 今天点击总数
	private int viewTimes;

	public int getBeforeYesterday() {
		return beforeYesterday;
	}

	public void setBeforeYesterday(int beforeYesterday) {
		this.beforeYesterday = beforeYesterday;
	}

	public int getViewTimes() {
		return viewTimes;
	}

	public void setViewTimes(int viewTimes) {
		this.viewTimes = viewTimes;
	}

	public Long getChannelId() {
		if (this.channel == null) {
			this.channel = new KeywordChannel();
		}
		return this.channel.getId();
	}

	public void setChannelId(Long id) {
		if (this.channel == null) {
			this.channel = new KeywordChannel();
		}
		this.channel.setId(id);
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

	public KeywordChannel getChannel() {
		return channel;
	}

	public void setChannel(KeywordChannel channel) {
		this.channel = channel;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getYesterday() {
		return yesterday;
	}

	public void setYesterday(int yesterday) {
		this.yesterday = yesterday;
	}

	public int getToday() {
		return today;
	}

	public void setToday(int today) {
		this.today = today;
	}

	public SystemKeyword() {
	}

}