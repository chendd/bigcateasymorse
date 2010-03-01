package com.domain.dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.domain.pojo.Uploadvideo;


public interface UploadvideoDao {
	
	public List<Uploadvideo> getUploadvideoes(Connection connection) throws SQLException;
	
	public void updateUploadvideo(Uploadvideo uploadvideo,Connection connection) throws SQLException;
	
	public void deleteUploadvideo(Long id,Connection connection) throws SQLException;

}
