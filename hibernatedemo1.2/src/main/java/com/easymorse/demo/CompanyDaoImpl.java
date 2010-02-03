package com.easymorse.demo;

import util.dao.HibernateDaoImpl;

public class CompanyDaoImpl extends HibernateDaoImpl<Company, Integer>
		implements CompanyDao {

	{
		this.type = Company.class;	
	}

}
