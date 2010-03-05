package com.video.domain;

import java.io.Serializable;
import java.util.Date;





public class SubscribePlaybill implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private User user;//操作用户
   private Playbill playbill;//订阅节目单
   private Date subscribeDate;//订阅时间
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Playbill getPlaybill() {
	return playbill;
}
public void setPlaybill(Playbill playbill) {
	this.playbill = playbill;
}
public Date getSubscribeDate() {
	return subscribeDate;
}
public void setSubscribeDate(Date subscribeDate) {
	this.subscribeDate = subscribeDate;
}

}