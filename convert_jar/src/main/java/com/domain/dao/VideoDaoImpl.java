package com.domain.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.domain.pojo.Uploadvideo;
import com.domain.pojo.Video;


public class VideoDaoImpl implements VideoDao {

	@Override
	public void updateVideo(Video video, Connection connection)throws SQLException {
		String sql = "update w_video set name=?,url=?,time_length=?,image=?,flag=? where id =?  ";
		PreparedStatement statement = connection.prepareStatement(sql);
		int index = 1;
		statement.setString(index++, video.getName());
		statement.setString(index++, video.getUrl());
		statement.setInt(index++, video.getTimeLength());
		statement.setString(index++, video.getImage());
		statement.setInt(index++, video.getFlag());
		statement.setLong(index++, video.getId());
		statement.execute();
		statement.close();
	}

	@Override
	public Video findVideoById(Long id, Connection connection)throws SQLException {
		String sql = "select name,url,time_length,image,flag,user_id,channel_id,description from w_video where id=?  ";
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setLong(1, id);
		Video video = new Video();
		
		ResultSet resultSet = statement.executeQuery();
		if(resultSet.next()){
			video.setId(id);
			video.setName(resultSet.getString("name"));
			video.setUrl(resultSet.getString("url"));
			video.setTimeLength(resultSet.getInt("time_length"));
			video.setImage(resultSet.getString("image"));
			video.setFlag(resultSet.getInt("flag"));
			video.setUserId(resultSet.getLong("user_id"));
			video.setChannelId(resultSet.getLong("channel_id"));
			video.setDescription(resultSet.getString("description"));
			
		
			
		}
		resultSet.close();
		statement.close();
		return video;
	}

}
