package com.video.domain;


import java.io.Serializable;
import java.util.*;

/** @pdOid c13ff5bb-7e09-42d6-a81e-8670bcbceb27 */
public class TopicComment implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Long id;//回复ID
   private Topic topic;//对应话题
   private User user;//回复用户
   private String comment;//回复内容
   private Date commentDate;//回复时间
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Topic getTopic() {
	return topic;
}
public void setTopic(Topic topic) {
	this.topic = topic;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public Date getCommentDate() {
	return commentDate;
}
public void setCommentDate(Date commentDate) {
	this.commentDate = commentDate;
}
   
   public TopicComment() {
}

}