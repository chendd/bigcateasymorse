package com.domain.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.domain.pojo.Programme;



public class ProgrammeDaoImpl implements ProgrammeDao{

	@Override
	public void createProgramme(Connection connection, Programme programme)
			throws SQLException {
		String sql ="insert into programmes(channel_id,name,filesize,time_length,image,add_date,update_date,intro_detail,download_url,download_times,browse_times,add_time,update_time,uid,video_id) values(?,?,?,?,?,current_date(),current_date(),?,?,?,?,current_time(),current_time(),?,?)";
		PreparedStatement statement = connection.prepareStatement(sql);
		int index =1;
		statement.setLong(index++, programme.getChannelId());
		statement.setString(index++, programme.getName());
		statement.setLong(index++, programme.getFilesize());
		statement.setInt(index++, programme.getTimeLength());
		statement.setString(index++, programme.getImage());
		statement.setString(index++, programme.getIntroDetail());
		statement.setString(index++, programme.getDownloadUrl());
		statement.setInt(index++, 0);
		statement.setInt(index++, 0);
		statement.setLong(index++, programme.getUserId());
		statement.setLong(index++, programme.getVideoId());
		statement.execute();
		statement.close();
		
		
		
	}

}
