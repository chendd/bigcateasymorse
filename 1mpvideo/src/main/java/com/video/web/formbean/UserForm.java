package com.video.web.formbean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.video.domain.User;
import com.video.web.struts.BaseActionForm;

public class UserForm extends BaseActionForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6130159565135915159L;

	private String userName;// 用户名

	private String password;// 密码

	private String againPassword;// 确认密码

	private String realName;// 真实姓名

	private String email;// 电子邮箱

	private String passwordHint;// 密码提示问题

	private String hintAns;// 密码提示答案

	private String mobilePhone;// 手机号码

	private String qq;// qq号码

	private String postCode;// 邮编

	private String address;// 地址

	private String gender;// 性别

	private String birthdayString;// 生日

	private String area;// 地区

	private String marriage;// 婚姻

	private String hobby;// 爱好

	private String signature;// 个性签名

	private String education;// 教育程度

	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		if (userName != null && !userName.trim().isEmpty()) {
			if (userName.length() > 16 || userName.length() < 3) {
				errors.add("userName", new ActionMessage(
						"error.user.userName.format"));
			} else {
				User user = new User();
				user.setUserName(userName);
				user = getAllService().getUser(user);
				if (user != null) {
					errors.add("userName", new ActionMessage(
							"error.user.userName.exist"));
				}
			}
		} else {
			errors.add("userName", new ActionMessage(
					"error.user.userName.empty"));
		}
		if (realName != null && !realName.trim().isEmpty()) {
			if (realName.length() > 6 || realName.length() < 2) {
				errors.add("realName", new ActionMessage(
						"errors.user.realName.format"));
			}
		} else {
			errors.add("realName", new ActionMessage(
					"error.user.realName.empty"));
		}
		if (password != null && !password.trim().isEmpty()
				&& againPassword != null && !againPassword.trim().isEmpty()) {
			if (!password.equals(againPassword)) {
				errors.add("againPassword", new ActionMessage(
						"error.user.password.differ"));
			}
		} else {
			errors.add("password", new ActionMessage(
					"error.user.password.empty"));
		}

		if (email != null && !email.trim().isEmpty()) {
			String regex = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(email);
			if (!m.find()) {
				errors.add("email",
						new ActionMessage("error.user.email.format"));
			} else {
				User user = new User();
				user.setEmail(email);
				user = getAllService().getUser(user);
				if (user != null) {
					errors.add("email", new ActionMessage(
							"error.user.email.exist"));
				}
			}
		} else {
			errors.add("email", new ActionMessage("error.user.email.empty"));
		}

		if (passwordHint != null && !passwordHint.trim().isEmpty()) {
			if (passwordHint.length() > 16 || passwordHint.length() < 6) {
				errors.add("passwordHint", new ActionMessage(
						"error.user.passwordHint.format"));
			}
		} else {
			errors.add("passwordHint", new ActionMessage(
					"error.user.passwordHint.empty"));
		}

		if (hintAns != null && !hintAns.trim().isEmpty()) {
			if (hintAns.length() > 16 || hintAns.length() < 6) {
				errors.add("hintAns", new ActionMessage(
						"error.user.hintAns.format"));
			}
		} else {
			errors.add("passwordHint", new ActionMessage(
					"error.user.hintAns.empty"));
		}

		if (mobilePhone != null && !mobilePhone.trim().isEmpty()) {
			String regex = "^1[3|5][\\d]{9}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(mobilePhone);
			if (!m.find()) {
				errors.add("mobilePhone", new ActionMessage(
						"error.user.mobilePhone.format"));
			}
		}

		if (qq != null && !qq.trim().isEmpty()) {
			String regex = "^[1-9]\\d{4,15}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(qq);
			if (!m.find()) {
				errors.add("qq", new ActionMessage("error.user.qq.format"));
			}
		}

		if (postCode != null && !postCode.trim().isEmpty()) {
			String regex = "^(\\d){6}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(postCode);
			if (!m.find()) {
				errors.add("postCode", new ActionMessage(
						"error.user.postCode.format"));
			}
		}

		if (birthdayString != null && !birthdayString.trim().isEmpty()) {
			String regex = "^19\\d{2}\\/((0[1-9]{1})|(1[0-2]{1}))\\/((0[1-9]{1})|([1-2]{1}[0-9]{1})|(3[0-1]{1}))$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(birthdayString);
			if (!m.find()) {
				errors.add("birthdayString", new ActionMessage(
						"error.user.birthdayString.format"));
			}
		}

		if (errors.size() > 0) {
			String send = request.getParameter("send");
			request.setAttribute("send", send);
		}

		return errors;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAgainPassword() {
		return againPassword;
	}

	public void setAgainPassword(String againPassword) {
		this.againPassword = againPassword;
	}

	public String getBirthdayString() {
		return birthdayString;
	}

	public void setBirthdayString(String birthdayString) {
		this.birthdayString = birthdayString;
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

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

}
