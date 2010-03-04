package com.video.domain;

import java.io.Serializable;
import java.util.Date;

public class SubscribeUser implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	private User passiveUser;
	private Date addDate;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public User getPassiveUser() {
		return passiveUser;
	}
	public void setPassiveUser(User passiveUser) {
		this.passiveUser = passiveUser;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	public SubscribeUser() {
		
	}

}
