package cn.vsp.bean;

import java.sql.Date;

public class SmsBean {

	private Long id;
	private String phoneNum;
	private String message;
	private Date sendDate;
	private String smsSign;

	public String getSmsSign() {
		return smsSign;
	}

	public void setSmsSign(String smsSign) {
		this.smsSign = smsSign;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

}
