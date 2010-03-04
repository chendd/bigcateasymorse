package com.video.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/** @pdOid 7760110d-e156-40de-addd-76d0aff91ace */
public class Topic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;//话题ID
	private String title;//话题标题
	private String text;//话题内容
	private String text2;//只有文字的话题内容，用于wap
	private User user;//发表用户
	private Group group;//所属圈子
	private int browseCount;//浏览次数
	private Date addDate;
	private int flag;
	private Date recommendDate;
	private int commentCount;
	private Long dailyId;//对应的日志ID
	private Set<TopicComment> comments = new HashSet<TopicComment>();
	public Set<TopicComment> getComments() {
		return comments;
	}
	public void setComments(Set<TopicComment> comments) {
		this.comments = comments;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public int getBrowseCount() {
		return browseCount;
	}
	public void setBrowseCount(int browseCount) {
		this.browseCount = browseCount;
	}
	public Topic() {
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Date getRecommendDate() {
		return recommendDate;
	}
	public void setRecommendDate(Date recommendDate) {
		this.recommendDate = recommendDate;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public String getText2() {
		return text2;
	}
	public void setText2(String text2) {
		this.text2 = text2;
	}
	public Long getDailyId() {
		return dailyId;
	}
	public void setDailyId(Long dailyId) {
		this.dailyId = dailyId;
	}
	
	

}