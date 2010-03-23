package com.easymorse.admin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.easymorse.hotel.HotelBean;

@Entity
@Table(name = "adminuser")
public class AdminUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String adminUserName;
	@Column
	private String adminUserPassword;
	@Column
	private Date registerTime;
	@Column
	private String adminType;
	@Column
	private String phone;
	@Column
	private String imNumber;

	@OneToOne
	private HotelBean hotelBean;
	
	
	public HotelBean getHotelBean() {
		return hotelBean;
	}

	public void setHotelBean(HotelBean hotelBean) {
		this.hotelBean = hotelBean;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getImNumber() {
		return imNumber;
	}

	public void setImNumber(String imNumber) {
		this.imNumber = imNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}

	public String getAdminUserPassword() {
		return adminUserPassword;
	}

	public void setAdminUserPassword(String adminUserPassword) {
		this.adminUserPassword = adminUserPassword;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getAdminType() {
		return adminType;
	}

	public void setAdminType(String adminType) {
		this.adminType = adminType;
	}

}
