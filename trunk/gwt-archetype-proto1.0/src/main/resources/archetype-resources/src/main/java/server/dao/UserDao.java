#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server.dao;

import org.apache.log4j.Logger;

import ${package}.beans.User;

public class UserDao {

	private static final Logger logger  = Logger.getLogger(UserDao.class);
	
	public String findUser(User user){
		/**
		 * 模拟数据操作
		 */
		logger.debug("user name is---"+user.getName()+"-----user password is ----"+user.getPassword());
		
		if("zhangsan".equals(user.getName())&& "password".equals(user.getPassword())){
			return "success-管理员";
		}if("lisi".equals(user.getName())&& "password".equals(user.getPassword())){
			return "success-普通用户";
		}
		else{
			return "error";
		}
	}
}
