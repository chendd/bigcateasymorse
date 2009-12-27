package util.security;
import util.dao.Dao;
/**
 * 
 * @author 邓彦辉 <a href="mailto:jiessiedyh@gmail.com">jiessiedyh@gmail.com</a>
 *
 */
public interface RoleDao extends Dao<Role, Long> {
	public Role findByNames(String name);
}
