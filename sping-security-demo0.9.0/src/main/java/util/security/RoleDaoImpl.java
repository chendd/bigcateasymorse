package util.security;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import util.dao.HibernateDaoImpl;
/**
 * 
 * @author 邓彦辉 <a href="mailto:jiessiedyh@gmail.com">jiessiedyh@gmail.com</a>
 *
 */
public class RoleDaoImpl extends
		HibernateDaoImpl<Role, Long> implements RoleDao {

	{
		this.type=Role.class;
	}

	@Override
	public Role findByNames(final String name) {
		return (Role) this.getHibernateTemplate().execute(
				new HibernateCallback() {
					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery("from "
								+ type.getName()
								+ " a where a.name=:username");
						query.setParameter("username", name);
						return query.uniqueResult();
					}
				});
	}
}
