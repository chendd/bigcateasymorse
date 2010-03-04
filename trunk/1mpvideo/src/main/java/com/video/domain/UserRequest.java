package com.video.domain;

import java.io.Serializable;
import java.util.Date;

public class UserRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private User user;
	private User rUser;
	private Date addDate;
	private String word;
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
//	public User getRUser() {
//		return rUser;
//	}
//	public void setRUser(User user) {
//		rUser = user;
//	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	public UserRequest() {
	}
	public User getrUser() {
		return rUser;
	}
	public void setrUser(User rUser) {
		this.rUser = rUser;
	}
	
}
