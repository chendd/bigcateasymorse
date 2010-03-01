package com.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DbUtil {
	
	public Connection getConnection() throws  Exception{
		
		//Class.forName("org.gjt.mm.mysql.Driver").newInstance(); 
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		String url = "jdbc:mysql://localhost:3306/1mp?user=jarry&password=abc123&characterEncoding=utf8"; 
		Connection connection = DriverManager
		.getConnection(url);
		connection.setAutoCommit(false);
		return connection;
		
		
	}
	
	
	public void commit(Connection connection) throws SQLException {
		
		connection.commit();
		
	}
	
	public void rollback(Connection connection){
		if(connection != null){
			try {
				connection.rollback();
			} catch (SQLException e) {
			
			}
		}
		
	}
	
	public void close(Connection connection){
		if(connection != null){
			try {
				connection.close();
			} catch (SQLException e) {
			
			
			}
		}
		
	}
	


}
