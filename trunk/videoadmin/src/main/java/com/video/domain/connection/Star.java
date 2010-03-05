package com.video.domain.connection;

import java.io.Serializable;

public class Star implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int  id;
	private Long user_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	
	

}
