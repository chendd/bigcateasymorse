package util.security;

import java.util.List;

import util.dao.Dao;

/**
 * 认证使用的Dao接口。
 * 
 * @author Marshal Wu <a
 *         href="mailto:marshal.wu@gmail.com">marshal.wu@gmail.com</a>
 * 
 */
public interface AuthenticationDao extends Dao<Authentication, Long> {
	/**
	 * 根据用户名获取认证对象。
	 * 
	 * @param username
	 * @return
	 */
	public Authentication findByUsername(String username);
	/**
	 * 得到所有的用户
	 * 
	 * @return
	 */
	public List findAllUsers();
}
