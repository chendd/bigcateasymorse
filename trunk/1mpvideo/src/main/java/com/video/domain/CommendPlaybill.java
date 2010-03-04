package com.video.domain;

import java.io.Serializable;
import java.util.Date;

public class CommendPlaybill implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4072939933570908758L;

	private Integer id;
	private String name;
	private String description;
	private String image;
	private Playbill playbill;
	private Date addDate;
	private int browseCount;

	public Date getAddDate() {
		return addDate;
	}

	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}

	public int getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(int browseCount) {
		this.browseCount = browseCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Playbill getPlaybill() {
		return playbill;
	}

	public void setPlaybill(Playbill playbill) {
		this.playbill = playbill;
	}

}
