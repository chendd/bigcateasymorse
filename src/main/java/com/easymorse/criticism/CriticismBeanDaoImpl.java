package com.easymorse.criticism;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.easymorse.hotel.HotelBean;

import util.dao.HibernateDaoImpl;

public class CriticismBeanDaoImpl extends HibernateDaoImpl<CriticismBean, Long>
		implements CriticismBeanDao {

	{
		this.type=CriticismBean.class;
	}

	@Override
	public List<CriticismBean> findListById(final HotelBean hotelbean) {
		return (List<CriticismBean>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(" from "
								+ type.getName() + " b where b.hotelBean=:hotelBean");
						query.setParameter("hotelBean", hotelbean);
						return query.list();
					}
				});
	}

	@Override
	public List<CriticismBean> findAllDesc() {
		return (List<CriticismBean>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(" from "
								+ type.getName() + " b  order by b.criticismTime desc ");
						
						return query.list();
					}
				});
	}

	
	

}
