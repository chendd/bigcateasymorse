package com.easymorse.criticism;

import java.util.List;

import util.dao.Dao;

import com.easymorse.hotel.HotelBean;

public interface CriticismBeanDao extends Dao<CriticismBean, Long> {

	public List<CriticismBean> findListById(HotelBean hotelbean);
	public List<CriticismBean> findAllDesc();
}
