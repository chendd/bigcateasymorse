package com.easymorse.news;

import util.dao.HibernateDaoImpl;

public class NewsBeanDaoImpl extends HibernateDaoImpl<NewsBean, Long> implements
		NewsBeanDao {

	{
		this.type = NewsBean.class;
	}
}
