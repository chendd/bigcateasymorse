package com.easymorse.hotel;

import java.util.List;

import util.dao.Dao;

public interface HotelBeanDao extends Dao<HotelBean, Long> {

	public List<HotelBean> findNotCheckup(boolean b);
	public List<HotelBean> findAllDesc();
}
