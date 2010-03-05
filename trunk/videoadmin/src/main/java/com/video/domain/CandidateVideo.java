package com.video.domain;

import java.io.Serializable;
import java.util.*;

public class CandidateVideo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;//记录ID
	private Video video;//备选视频
	private String sake;//原因
	private Administrator recommender;//推荐者
	private Date recommendDate;//推荐时间
	private int state;//状态
	private int grade;//等级

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public String getSake() {
		return sake;
	}

	public void setSake(String sake) {
		this.sake = sake;
	}

	public Administrator getRecommender() {
		return recommender;
	}

	public void setRecommender(Administrator recommender) {
		this.recommender = recommender;
	}

	public Date getRecommendDate() {
		return recommendDate;
	}

	public void setRecommendDate(Date recommendDate) {
		this.recommendDate = recommendDate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}