package com.easymorse.admin;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.easymorse.user.UserBean;

import util.dao.HibernateDaoImpl;

public class AdminUserDaoImpl extends HibernateDaoImpl<AdminUser, Long>
		implements AdminUserDao {

	{
		this.type = AdminUser.class;
	}

	
	
	@Override
	public AdminUser findByName(final String name) {
		return (AdminUser) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(" from "
								+ type.getName() + " b where b.adminUserName=:name");
						query.setParameter("name", name);
						return query.uniqueResult();
					}
				});
	}

}
