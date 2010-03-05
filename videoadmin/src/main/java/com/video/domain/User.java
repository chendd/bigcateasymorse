package com.video.domain;


import java.io.Serializable;
import java.util.*;

/** 用户
 * 
 * @pdOid 6b3f3121-1b85-41e3-82f6-07ce72b8076f */
public class User implements Serializable{

   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

private Long id;

   private String userName;//用户名

   private String password;//密码

   private String realName;//真实姓名

   private String email;//电子邮箱
   
   private String passwordHint;//密码提示问题

   private String hintAns;//密码提示答案

   private String mobilePhone;//手机号码

   private String qq;//qq号码
   
   private String postCode;//邮编

   private String address;//地址

   private Date regDate;//注册日期

   private Date lastLoginDate;//最后登录时间

   private String gender;//性别

   private Date birthday;//生日

   private String area;//地区

   private String marriage;//婚姻

   private String hobby;//爱好

   private String signature;//个性签名

   private Integer level;//用户等级

   private Integer score;//积分

   private Integer fortune;//财富

   private Integer loginTimes;//总登录次数

   private String face;//头像

   private String education;//教育程度

   private Integer side;//首页布局选择

   private String layout;//首页具体布局

   private String lastLoginIp;//最后登录IP
   
   private Integer grade;//用户组级别
   
   private Integer status;//用户状态

public Integer getStatus() {
	return status;
}

public void setStatus(Integer status) {
	this.status = status;
}

public Integer getGrade() {
	return grade;
}

public void setGrade(Integer grade) {
	this.grade = grade;
}

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getRealName() {
	return realName;
}

public void setRealName(String realName) {
	this.realName = realName;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPasswordHint() {
	return passwordHint;
}

public void setPasswordHint(String passwordHint) {
	this.passwordHint = passwordHint;
}

public String getHintAns() {
	return hintAns;
}

public void setHintAns(String hintAns) {
	this.hintAns = hintAns;
}

public String getMobilePhone() {
	return mobilePhone;
}

public void setMobilePhone(String mobilePhone) {
	this.mobilePhone = mobilePhone;
}

public String getQq() {
	return qq;
}

public void setQq(String qq) {
	this.qq = qq;
}

public String getPostCode() {
	return postCode;
}

public void setPostCode(String postCode) {
	this.postCode = postCode;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public Date getRegDate() {
	return regDate;
}

public void setRegDate(Date regDate) {
	this.regDate = regDate;
}

public Date getLastLoginDate() {
	return lastLoginDate;
}

public void setLastLoginDate(Date lastLoginDate) {
	this.lastLoginDate = lastLoginDate;
}

public String getGender() {
	return gender;
}

public void setGender(String gender) {
	this.gender = gender;
}

public Date getBirthday() {
	return birthday;
}

public void setBirthday(Date birthday) {
	this.birthday = birthday;
}

public String getArea() {
	return area;
}

public void setArea(String area) {
	this.area = area;
}

public String getMarriage() {
	return marriage;
}

public void setMarriage(String marriage) {
	this.marriage = marriage;
}

public String getHobby() {
	return hobby;
}

public void setHobby(String hobby) {
	this.hobby = hobby;
}

public String getSignature() {
	return signature;
}

public void setSignature(String signature) {
	this.signature = signature;
}

public Integer getLevel() {
	return level;
}

public void setLevel(Integer level) {
	this.level = level;
}

public Integer getScore() {
	return score;
}

public void setScore(Integer score) {
	this.score = score;
}

public Integer getFortune() {
	return fortune;
}

public void setFortune(Integer fortune) {
	this.fortune = fortune;
}

public Integer getLoginTimes() {
	return loginTimes;
}

public void setLoginTimes(Integer loginTimes) {
	this.loginTimes = loginTimes;
}

public String getFace() {
	return face;
}

public void setFace(String face) {
	this.face = face;
}

public String getEducation() {
	return education;
}

public void setEducation(String education) {
	this.education = education;
}

public Integer getSide() {
	return side;
}

public void setSide(Integer side) {
	this.side = side;
}

public String getLayout() {
	return layout;
}

public void setLayout(String layout) {
	this.layout = layout;
}

public String getLastLoginIp() {
	return lastLoginIp;
}

public void setLastLoginIp(String lastLoginIp) {
	this.lastLoginIp = lastLoginIp;
}
   
   public User() {
	
}

}