package cn.vsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.MessageFormat;

import org.apache.log4j.Logger;

import cn.vsp.bean.SmsBean;
import cn.vsp.util.DBUtil;

public class SmsBeanDao {

	private static final Logger logger = Logger.getLogger(SmsBeanDao.class);

	public void insetSms(SmsBean smsBean) {
		try {
			Connection connection = DBUtil.getConnetion();
			String insertSql = "insert into smstable (phoneNum,message,sendDate,smsSign) values(?,?,?,?)";
			PreparedStatement preparedStatement = connection
					.prepareStatement(insertSql);
			int i = 1;
			preparedStatement.setString(i++, smsBean.getPhoneNum());
			preparedStatement.setString(i++, smsBean.getMessage());
			logger.debug("短信内容是：》》》》"+smsBean.getMessage());
			java.util.Date date = new java.util.Date();
			String dateString = MessageFormat.format(
					"{0,date,yyyy-MM-dd hh:mm:ss }", date);
			preparedStatement.setTimestamp(i++, Timestamp.valueOf(dateString));
			preparedStatement.setString(i++, smsBean.getSmsSign());
			
			logger.debug(">>>sql语句是："+insertSql);
			 
			preparedStatement.execute();
			
			DBUtil.closeConnection(connection);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public SmsBean findSmsBeanBysmsSign(String s){
		
		
		try {
			
			Connection connection = DBUtil.getConnetion();
			String selectSql = "select * from  smstable where smsSign = ?";
			PreparedStatement preparedStatement = connection
					.prepareStatement(selectSql);
			
			preparedStatement.setString(1, s);
			ResultSet resultSet = preparedStatement.executeQuery();
			logger.debug(">>>sql语句是："+selectSql);
			SmsBean smsBean = null;
			while(resultSet.next()){
				  smsBean =   new SmsBean();
				logger.debug(">>>>>>"+resultSet.getString("phoneNum"));
				
				smsBean.setPhoneNum(resultSet.getString("phoneNum"));
				smsBean.setMessage(resultSet.getString("message"));
				smsBean.setSmsSign(resultSet.getString("smsSign"));
			}
			
			DBUtil.closeConnection(connection);
			logger.debug("smsBean是否为空"+smsBean == null);
			return smsBean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	public static void main(String[] args) {
		SmsBeanDao smsBeanDao = new SmsBeanDao();
		SmsBean smsBean = new SmsBean();
		smsBean.setMessage("ddd");
		smsBean.setPhoneNum("1111");

		smsBeanDao.insetSms(smsBean);
	}

}
