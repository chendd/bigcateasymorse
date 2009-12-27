package util.security;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import util.dao.HibernateDaoImpl;

public class AuthenticationDaoImpl extends
		HibernateDaoImpl<Authentication, Long> implements AuthenticationDao {

	{
		this.type=Authentication.class;
	}
	
	@Override
	public Authentication findByUsername(final String username) {
		return (Authentication) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery("from "
								+ type.getSimpleName()
								+ " a where a.username=:username");
						query.setParameter("username", username);
						return query.uniqueResult();
					}
				});
	}

	@SuppressWarnings("unchecked")
	@Override
	public List findAllUsers() {
		
		return (List<Authentication>) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery("from "
								+ type.getSimpleName());
						return query.list();
					}
				});
	}
	
}
