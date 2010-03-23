package com.easymorse.user;

import util.dao.Dao;

public interface UserBeanDao extends Dao<UserBean, Long> {

	
	public UserBean findByAlise(String alise);
}
