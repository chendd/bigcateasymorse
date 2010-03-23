package com.easymorse.room;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import util.dao.HibernateDaoImpl;

import com.easymorse.hotel.HotelBean;

public class HotelRoomDaoImpl extends HibernateDaoImpl<HotelRoom, Long>
		implements HotelRoomDao {

	{
		this.type = HotelRoom.class;
	}

	@Override
	public List findRoom(final HotelBean id) {
		return (List<HotelRoom>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(" from "
								+ type.getName() + " b where b.hotelBean=:bbb");
						query.setParameter("bbb", id);
						return query.list();
					}
				});
	}

	

}
