package com.video.domain;

import java.io.Serializable;

public class SystemKeywordChange implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1790962570025819809L;

	private Long id;
	private String name;
	private int viewTimes;
	private double change;

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

	public int getViewTimes() {
		return viewTimes;
	}

	public void setViewTimes(int viewTimes) {
		this.viewTimes = viewTimes;
	}

	public double getChange() {
		return change;
	}

	public void setChange(double change) {
		this.change = change;
	}

}
