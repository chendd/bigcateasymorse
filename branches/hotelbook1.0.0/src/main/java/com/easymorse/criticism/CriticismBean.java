package com.easymorse.criticism;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.easymorse.hotel.HotelBean;

@Entity
@Table(name = "criticisms")
public class CriticismBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String criticism;
	@Column
	private Date criticismTime;

	@ManyToOne
	private HotelBean hotelBean;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCriticism() {
		return criticism;
	}

	public void setCriticism(String criticism) {
		this.criticism = criticism;
	}

	public Date getCriticismTime() {
		return criticismTime;
	}

	public void setCriticismTime(Date criticismTime) {
		this.criticismTime = criticismTime;
	}

	public HotelBean getHotelBean() {
		return hotelBean;
	}

	public void setHotelBean(HotelBean hotelBean) {
		this.hotelBean = hotelBean;
	}

}
