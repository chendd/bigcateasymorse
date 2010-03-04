package com.video.domain;

import java.io.Serializable;

public class SystemKeywordTerm implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6823607962884411425L;

	private Long id;
	private int size;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

}
