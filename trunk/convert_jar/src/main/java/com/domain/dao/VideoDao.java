package com.domain.dao;


import java.sql.Connection;
import java.sql.SQLException;

import com.domain.pojo.Video;


public interface VideoDao {
	
	public void updateVideo(Video video,Connection connection) throws SQLException;
	
	public Video findVideoById(Long id,Connection connection)throws SQLException;

}
