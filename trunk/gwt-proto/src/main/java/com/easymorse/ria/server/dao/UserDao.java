package com.easymorse.ria.server.dao;

import org.apache.log4j.Logger;

import com.easymorse.ria.beans.User;

public class UserDao {

	private static final Logger logger  = Logger.getLogger(UserDao.class);
	
	public String findUser(User user){
		/**
		 * 模拟数据操作
		 */
		logger.debug("user name is---"+user.getName()+"-----user password is ----"+user.getPassword());
		
		if("zhangsan".equals(user.getName())&& "password".equals(user.getPassword())){
			return "success";
		}else{
			return "error";
		}
	}
}
