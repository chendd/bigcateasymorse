package com.domain.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.domain.pojo.Event;
import com.domain.pojo.Video;

public interface EventDao {
	
	public void createEvent(Event event,Connection connection) throws SQLException;

}
