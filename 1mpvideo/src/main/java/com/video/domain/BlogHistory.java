package com.video.domain;

import java.io.Serializable;
import java.util.Date;

public class BlogHistory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	private User visiter;
	private Date visitDate;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getVisiter() {
		return visiter;
	}
	public void setVisiter(User visiter) {
		this.visiter = visiter;
	}
	public Date getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}
	
	

}
