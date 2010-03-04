package com.video.domain;


import java.io.Serializable;
import java.util.*;

public class GroupAndUser implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer rate;//圈员级别
   private Date addDate;//加入时间
   private Group group;//圈子
   private User user;//圈子成员

public Date getAddDate() {
	return addDate;
}
public void setAddDate(Date addDate) {
	this.addDate = addDate;
}
public Group getGroup() {
	return group;
}
public void setGroup(Group group) {
	this.group = group;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
   
  public GroupAndUser() {
	
}
public Integer getRate() {
	return rate;
}
public void setRate(Integer rate) {
	this.rate = rate;
} 

}