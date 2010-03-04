package com.video.domain;

import java.io.Serializable;
import java.util.Date;

public class GroupHistory implements Serializable{
	
	private Group group;
	private User visiter;
	private Date visitDate;
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
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	

}
