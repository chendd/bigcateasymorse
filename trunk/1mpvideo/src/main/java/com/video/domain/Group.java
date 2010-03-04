package com.video.domain;


import java.io.Serializable;
import java.util.*;

/** 圈子
 * 
 * @pdOid fb4c2023-4f8d-4c49-a186-3e4dabef696d */
public class Group implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
  private Long id;//圈子ID
   private User owner;//圈主
   private String descrption;//圈子介绍
   private String image;//圈子图片
   private Date addDate;//创建时间
   private String name;//圈子名称
   private int flag;
   private int memberCount;
   private int topicCount;
   private int videoCount;
   private Date recommendDate;//推荐时间
   private int auditType;//审核类型
   private int activity;
   
public int getActivity() {
	return activity;
}
public void setActivity(int activity) {
	this.activity = activity;
}
public int getAuditType() {
	return auditType;
}
public void setAuditType(int auditType) {
	this.auditType = auditType;
}
public Date getRecommendDate() {
	return recommendDate;
}
public void setRecommendDate(Date recommendDate) {
	this.recommendDate = recommendDate;
}
public int getMemberCount() {
	return memberCount;
}
public void setMemberCount(int memberCount) {
	this.memberCount = memberCount;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public User getOwner() {
	return owner;
}
public void setOwner(User owner) {
	this.owner = owner;
}
public String getDescrption() {
	return descrption;
}
public void setDescrption(String descrption) {
	this.descrption = descrption;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Date getAddDate() {
	return addDate;
}
public void setAddDate(Date addDate) {
	this.addDate = addDate;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getFlag() {
	return flag;
}
public void setFlag(int flag) {
	this.flag = flag;
}
   public Group() {
	
}
public int getTopicCount() {
	return topicCount;
}
public void setTopicCount(int topicCount) {
	this.topicCount = topicCount;
}
public int getVideoCount() {
	return videoCount;
}
public void setVideoCount(int videoCount) {
	this.videoCount = videoCount;
}
   
   

}