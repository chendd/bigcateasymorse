package com.video.domain;

import java.io.Serializable;
import java.util.Date;




/** @pdOid 5df9bf78-21af-484c-bc62-8bc56521c888 */
public class Video3gp implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Long id;
   private VideoChannel channel;
   private int typeId;
   private int videoSize;
   private int videoTime;
   private String imageUrl;
   private String author;
   private String copyright;
   private int status;
   private Date addDate;
   private Date updateDate;
   private String introSimple;
   private String introDetail;
   private String downloadUrl;
   private String smallUrl;
   private int downloadCount;
   private int browseCount;
   private double price;
   private String surportMobileType;
   private int downloadEnable;
   private Date addTime;
   private Date updateTime;
   private User user;
   private String tag;
   private int count1;
   private int count2;
   private int count3;
   private Date lastTime;
   private Video video;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public VideoChannel getChannel() {
	return channel;
}
public void setChannel(VideoChannel channel) {
	this.channel = channel;
}
public int getTypeId() {
	return typeId;
}
public void setTypeId(int typeId) {
	this.typeId = typeId;
}
public int getVideoSize() {
	return videoSize;
}
public void setVideoSize(int videoSize) {
	this.videoSize = videoSize;
}
public int getVideoTime() {
	return videoTime;
}
public void setVideoTime(int videoTime) {
	this.videoTime = videoTime;
}
public String getImageUrl() {
	return imageUrl;
}
public void setImageUrl(String imageUrl) {
	this.imageUrl = imageUrl;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getCopyright() {
	return copyright;
}
public void setCopyright(String copyright) {
	this.copyright = copyright;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public Date getAddDate() {
	return addDate;
}
public void setAddDate(Date addDate) {
	this.addDate = addDate;
}
public Date getUpdateDate() {
	return updateDate;
}
public void setUpdateDate(Date updateDate) {
	this.updateDate = updateDate;
}
public String getIntroSimple() {
	return introSimple;
}
public void setIntroSimple(String introSimple) {
	this.introSimple = introSimple;
}
public String getIntroDetail() {
	return introDetail;
}
public void setIntroDetail(String introDetail) {
	this.introDetail = introDetail;
}
public String getDownloadUrl() {
	return downloadUrl;
}
public void setDownloadUrl(String downloadUrl) {
	this.downloadUrl = downloadUrl;
}
public String getSmallUrl() {
	return smallUrl;
}
public void setSmallUrl(String smallUrl) {
	this.smallUrl = smallUrl;
}
public int getDownloadCount() {
	return downloadCount;
}
public void setDownloadCount(int downloadCount) {
	this.downloadCount = downloadCount;
}
public int getBrowseCount() {
	return browseCount;
}
public void setBrowseCount(int browseCount) {
	this.browseCount = browseCount;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getSurportMobileType() {
	return surportMobileType;
}
public void setSurportMobileType(String surportMobileType) {
	this.surportMobileType = surportMobileType;
}
public int getDownloadEnable() {
	return downloadEnable;
}
public void setDownloadEnable(int downloadEnable) {
	this.downloadEnable = downloadEnable;
}
public Date getAddTime() {
	return addTime;
}
public void setAddTime(Date addTime) {
	this.addTime = addTime;
}
public Date getUpdateTime() {
	return updateTime;
}
public void setUpdateTime(Date updateTime) {
	this.updateTime = updateTime;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getTag() {
	return tag;
}
public void setTag(String tag) {
	this.tag = tag;
}
public int getCount1() {
	return count1;
}
public void setCount1(int count1) {
	this.count1 = count1;
}
public int getCount2() {
	return count2;
}
public void setCount2(int count2) {
	this.count2 = count2;
}
public int getCount3() {
	return count3;
}
public void setCount3(int count3) {
	this.count3 = count3;
}
public Date getLastTime() {
	return lastTime;
}
public void setLastTime(Date lastTime) {
	this.lastTime = lastTime;
}
public Video getVideo() {
	return video;
}
public void setVideo(Video video) {
	this.video = video;
}
   
   public Video3gp() {
}

}