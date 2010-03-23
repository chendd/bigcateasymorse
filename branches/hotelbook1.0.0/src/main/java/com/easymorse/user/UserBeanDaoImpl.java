package com.easymorse.user;



import java.sql.SQLException;
import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import util.dao.HibernateDaoImpl;

public class UserBeanDaoImpl extends HibernateDaoImpl<UserBean, Long> implements
		UserBeanDao {

	{
		this.type = UserBean.class;
	}

	@Override
	public UserBean findByAlise(final String alias) {
		return (UserBean) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(" from "
								+ type.getName() + " b where b.alias=:alias");
						query.setParameter("alias", alias);
						return query.uniqueResult();
					}
				});
	}

	
}
