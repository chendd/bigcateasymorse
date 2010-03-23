package com.easymorse.room;

import java.util.List;

import util.dao.Dao;

import com.easymorse.hotel.HotelBean;

public interface HotelRoomDao extends Dao<HotelRoom, Long> {

	public List findRoom(HotelBean id);
}
