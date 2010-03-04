package com.video.domain;

import java.io.Serializable;
import java.util.*;

public class Whisper implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private User toUser;
	private User fromUser;
	private String message;
	private Video recommendVido;
	private int status;
	private Date sendDate;
	private String title;

	public String getTitle() {
		return this.message.length()>10?this.message.substring(0, 9)+"...":this.message;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Video getRecommendVido() {
		return recommendVido;
	}

	public void setRecommendVido(Video recommendVido) {
		this.recommendVido = recommendVido;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	
	public Whisper() {
	}

}