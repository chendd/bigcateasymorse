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
	private User user;//发表用户
	private Group group;//所属圈子
	private int browseCount;//浏览次数
	private Date addDate;
	private int flag;
	private Date recommendDate;
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

}