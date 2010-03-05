package com.video.domain;

import java.io.Serializable;

/** @pdOid 0a3ba8ab-e840-490f-ac08-c3bf51817340 */
public class DailyChannel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id; // 分类ID
	private DailyChannel parent; // 父类
	private String name; // 分类名词
	private String image;// 分类图片
	private String description;// 分类说明
	private int recommend;// 推荐
	private int beTop;// 置顶
	private String url;// 链接地址
	private int readGrade;// 阅读等级
	private int publishGrade;// 发表等级
	private Administrator manage;
	private int orders;

	public void setManageId(Long id) {
		if (this.manage == null) {
			this.manage = new Administrator();
		}
		this.manage.setId(id);
	}
	
	public Long getManageId(){
		if(this.manage!=null){
			return this.manage.getId();
		}
		return null;
	}

	public void setParentId(Long id) {
		if (this.parent == null) {
			this.parent = new DailyChannel();
		}
		this.parent.setId(id);
	}

	public Long getParentId() {
		if (this.parent != null) {
			return this.parent.getId();
		}
		return null;
	}

	public int getOrders() {
		return orders;
	}

	public void setOrders(int orders) {
		this.orders = orders;
	}

	public Administrator getManage() {
		return manage;
	}

	public void setManage(Administrator manage) {
		this.manage = manage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DailyChannel getParent() {
		return parent;
	}

	public void setParent(DailyChannel parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public int getBeTop() {
		return beTop;
	}

	public void setBeTop(int beTop) {
		this.beTop = beTop;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getReadGrade() {
		return readGrade;
	}

	public void setReadGrade(int readGrade) {
		this.readGrade = readGrade;
	}

	public int getPublishGrade() {
		return publishGrade;
	}

	public void setPublishGrade(int publishGrade) {
		this.publishGrade = publishGrade;
	}

	public DailyChannel() {

	}

}