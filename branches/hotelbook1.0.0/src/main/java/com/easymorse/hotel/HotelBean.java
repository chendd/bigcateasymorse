package com.easymorse.hotel;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotelbean")
public class HotelBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * 酒店名称
	 */
	@Column
	private String hotelName;
	/**
	 * 公司全称
	 */
	@Column
	private String companyName;
	/**
	 * 酒店星级
	 */
	@Column
	private String hotelType;
	/**
	 * 酒店地址
	 */
	@Column
	private String hotelAddress;
	/**
	 * 联系电话
	 */
	@Column
	private String hotelPhone;
	/**
	 * 酒店简介
	 */
	@Column
	private String hotelIntroduce;
	
	/**
	 * 酒店详细简介
	 */
	@Column
	private String hotelDetail;
	/**
	 * 酒店周边
	 */
	@Column
	private String hotelRound;
	/**
	 * 酒店图片
	 */
	@Column
	private String hotelImage;

	/**
	 * 是否通过审核
	 */
	@Column
	private boolean isCheckUp;

	@Column
	private Date applyTime;

	
	public String getHotelDetail() {
		return hotelDetail;
	}

	public void setHotelDetail(String hotelDetail) {
		this.hotelDetail = hotelDetail;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public boolean isCheckUp() {
		return isCheckUp;
	}

	public void setCheckUp(boolean isCheckUp) {
		this.isCheckUp = isCheckUp;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public String getHotelAddress() {
		return hotelAddress;
	}

	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	public String getHotelPhone() {
		return hotelPhone;
	}

	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}

	public String getHotelIntroduce() {
		return hotelIntroduce;
	}

	public void setHotelIntroduce(String hotelIntroduce) {
		this.hotelIntroduce = hotelIntroduce;
	}

	public String getHotelRound() {
		return hotelRound;
	}

	public void setHotelRound(String hotelRound) {
		this.hotelRound = hotelRound;
	}

	public String getHotelImage() {
		return hotelImage;
	}

	public void setHotelImage(String hotelImage) {
		this.hotelImage = hotelImage;
	}

}
