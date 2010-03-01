package com.domain.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.domain.pojo.Event;

public class EventDaoImpl implements EventDao{

	public void createEvent(Event event, Connection connection)
			throws SQLException {
		String sql ="insert into w_events(description,url,user_id,add_date) values(?,?,?,?)";
		System.out.println("============="+sql);
		PreparedStatement statement = connection.prepareStatement(sql);
		int index =1;
		statement.setString(index++, event.getDescription());
		statement.setString(index++, event.getUrl());
		statement.setLong(index++, event.getUserId());
		statement.setDate(index++, new Date(event.getAddDate().getTime()));
		
		statement.execute();
		statement.close();
	}

}
