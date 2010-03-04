package com.video.domain;

import java.io.Serializable;
import java.util.Date;

public class Friend implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private User user;
	private User fUser;
	private Date regdate;
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
//	public User getFUser() {
//		return fUser;
//	}
//	public void setFUser(User user) {
//		fUser = user;
//	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	public Friend() {
		// TODO Auto-generated constructor stub
	}
	public User getfUser() {
		return fUser;
	}
	public void setfUser(User fUser) {
		this.fUser = fUser;
	}

}
