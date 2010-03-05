package com.video.web.formbean;

import com.video.web.struts.BaseActionForm;

public class VideoChannelFormBean extends BaseActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String parentId;
	private String name;
	private String wapName;
	private String description;
	private String imageUrl;
	private String activeImageUrl;
	private String deactivateImageUrl;
	private String grade;

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWapName() {
		return wapName;
	}

	public void setWapName(String wapName) {
		this.wapName = wapName;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
