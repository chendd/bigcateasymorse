package com.easymorse.admin;

import util.dao.Dao;

public interface AdminUserDao extends Dao<AdminUser, Long> {

	public AdminUser findByName(String name);
}
