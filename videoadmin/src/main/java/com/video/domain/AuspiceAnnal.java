package com.video.domain;


import java.io.Serializable;
import java.util.*;

public class AuspiceAnnal implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Long id;
   private User auspiceer;
   private Video video;
   private Challenge challenge;
   private Date auspiceTime;
   private String auspiceIp;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public User getAuspiceer() {
	return auspiceer;
}
public void setAuspiceer(User auspiceer) {
	this.auspiceer = auspiceer;
}
public Video getVideo() {
	return video;
}
public void setVideo(Video video) {
	this.video = video;
}
public Challenge getChallenge() {
	return challenge;
}
public void setChallenge(Challenge challenge) {
	this.challenge = challenge;
}
public Date getAuspiceTime() {
	return auspiceTime;
}
public void setAuspiceTime(Date auspiceTime) {
	this.auspiceTime = auspiceTime;
}
public String getAuspiceIp() {
	return auspiceIp;
}
public void setAuspiceIp(String auspiceIp) {
	this.auspiceIp = auspiceIp;
}
   public AuspiceAnnal() {
}
   

}