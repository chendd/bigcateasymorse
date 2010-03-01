package com.domain.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.domain.pojo.Uploadvideo;






public class UploadvideoDaoImpl implements UploadvideoDao {

	@Override
	public void deleteUploadvideo(Long id, Connection connection) throws SQLException {
		String sql = "delete w_uploadvideoes  where id =?  ";
		PreparedStatement statement = connection.prepareStatement(sql);
	
		statement.setLong(1, id);
		statement.execute();
		statement.close();
		
		


	}

	@Override
	public List<Uploadvideo> getUploadvideoes(Connection connection) throws SQLException{
		List<Uploadvideo> videoes = new ArrayList<Uploadvideo>();
		String sql = "select id,path,time_length,video_type,status,num_3gp,convert_status,video_id from w_uploadvideoes where status !=? and convert_status=?  ";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setInt(1, 0);
		statement.setInt(2, 0);
		
		ResultSet resultSet = statement.executeQuery();
		while(resultSet.next()){
			Uploadvideo uploadvideo = new Uploadvideo();
			uploadvideo.setId(resultSet.getLong("id"));
			uploadvideo.setUrl(resultSet.getString("path"));
			uploadvideo.setVideoTime(resultSet.getInt("time_length"));
			uploadvideo.setVideoType(resultSet.getString("video_type"));
			uploadvideo.setStatus(resultSet.getInt("status"));
			uploadvideo.setNum3gp(resultSet.getInt("num_3gp"));
			uploadvideo.setConvertStatus(resultSet.getInt("convert_status"));
			uploadvideo.getVideo().setId(resultSet.getLong("video_id"));
			videoes.add(uploadvideo);
		}
		resultSet.close();
		statement.close();
		return videoes;
	}

	@Override
	public void updateUploadvideo(Uploadvideo uploadvideo, Connection connection) throws SQLException{
		String sql = "update w_uploadvideoes set status=?,convert_status=? where id =?  ";
		PreparedStatement statement = connection.prepareStatement(sql);
		int index = 1;
		statement.setInt(index++, uploadvideo.getStatus());
		statement.setInt(index++, uploadvideo.getConvertStatus());
		statement.setLong(index++, uploadvideo.getId());
		statement.execute();
		statement.close();

	}

}
