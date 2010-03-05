package com.video.domain;


import java.io.Serializable;
import java.util.*;

/** 标签
 * 
 * @pdOid 3e1f2ced-fcfb-4355-86f3-806d7e32fd9c */
public class DailyTag implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Long id;//标签ID
   private String name;//标签名称
   private User user;//添加用户
   private Integer browseCount;//点击次数
   private Date createDate;//添加时间
   private Integer status;//标签状态
   private Set<Daily> dailies = new HashSet<Daily>();
   

public Set<Daily> getDailies() {
	return dailies;
}
public void setDailies(Set<Daily> dailies) {
	this.dailies = dailies;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}

public Integer getBrowseCount() {
	return browseCount;
}
public void setBrowseCount(Integer browseCount) {
	this.browseCount = browseCount;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}

   
public DailyTag() {
	
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
}