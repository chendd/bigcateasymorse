package com.video.domain;

import java.io.Serializable;

/** @pdOid db5a714a-49e3-4643-9a27-413d7f71218e */
public class VideoChannel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;// 分类ID
	private String name;// 分类名称
	private VideoChannel parent;// 父类
	private int grade;// 等级
	private String description;// 分类介绍
	private String imageUrl;// 图片地址
	private String activeImageUrl;
	private String deactivateImageUrl;
	private String wapName;

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

	public VideoChannel getParent() {
		return parent;
	}

	public void setParent(VideoChannel parent) {
		this.parent = parent;
	}

	public void setParentId(Long id) {
		if (this.parent == null) {
			this.parent = new VideoChannel();
		}
		this.parent.setId(id);
	}

	public Long getParentId() {
		if (this.parent == null) {
			this.parent = new VideoChannel();
		}
		return this.parent.getId();
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getActiveImageUrl() {
		return activeImageUrl;
	}

	public void setActiveImageUrl(String activeImageUrl) {
		this.activeImageUrl = activeImageUrl;
	}

	public String getDeactivateImageUrl() {
		return deactivateImageUrl;
	}

	public void setDeactivateImageUrl(String deactivateImageUrl) {
		this.deactivateImageUrl = deactivateImageUrl;
	}

	public String getWapName() {
		return wapName;
	}

	public void setWapName(String wapName) {
		this.wapName = wapName;
	}

	public VideoChannel() {

	}
}