package cn.vsp.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

public class DBUtil {

	private static String url;
	private static String userName;
	private static String password;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			url = "jdbc:mysql://localhost:3306/smsdb?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=utf-8";
			userName = "root";
			password = "password";
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnetion() throws Exception {
		return java.sql.DriverManager.getConnection(url, userName, password);
	}

	public static void closeConnection(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args) throws Exception {
		System.out.println(DBUtil.getConnetion());
		
	}
}
