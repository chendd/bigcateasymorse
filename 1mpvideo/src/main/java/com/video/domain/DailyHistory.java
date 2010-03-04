package com.video.domain;

import java.io.Serializable;
import java.util.Date;

public class DailyHistory implements Serializable{
	
	private Daily daily;
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
	public Daily getDaily() {
		return daily;
	}
	public void setDaily(Daily daily) {
		this.daily = daily;
	}
	
	

}
