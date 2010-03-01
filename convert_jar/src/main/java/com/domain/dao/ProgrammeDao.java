package com.domain.dao;


import java.sql.Connection;
import java.sql.SQLException;

import com.domain.pojo.Programme;



public interface ProgrammeDao {
	
	public void createProgramme(Connection connection,Programme programme) throws SQLException;

}
