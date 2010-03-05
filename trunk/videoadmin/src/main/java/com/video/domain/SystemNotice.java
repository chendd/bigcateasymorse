package com.video.domain;

import java.io.Serializable;
import java.util.Date;

public class SystemNotice implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id; // 系统信息ID
	private Date sendDate;// 发送时间
	private String title;// 标题
	private String message;// 信息内容
	private int status;// 是否阅读 0:未读，1:已读，2:同意，3:拒绝
	private User user;// 接受用户
    private Module module;// 申请方，可能是用户，也可能是小组
	private int type;// 信息类型：o:系统公告；1：系统通知，2：小组邀请，3：小组公告，4：好友申请，5：好友分享

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public SystemNotice() {

	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
