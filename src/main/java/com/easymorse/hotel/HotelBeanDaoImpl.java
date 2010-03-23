package com.easymorse.hotel;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.easymorse.admin.AdminUser;

import util.dao.HibernateDaoImpl;

public class HotelBeanDaoImpl extends HibernateDaoImpl<HotelBean, Long>
		implements HotelBeanDao {

	{
		this.type = HotelBean.class;
	}

	@Override
	public List<HotelBean> findNotCheckup(final boolean bbb) {
		return (List<HotelBean>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(" from "
								+ type.getName() + " b where b.isCheckUp=:bbb");
						query.setParameter("bbb", bbb);
						return query.list();
					}
				});
	}

	@Override
	public List<HotelBean> findAllDesc() {
		return (List<HotelBean>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(" from "
								+ type.getName() + " b  order by b.applyTime desc");
						
						return query.list();
					}
				});
	}




	
}
