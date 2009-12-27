package util.security;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.security.userdetails.UserDetails;
import org.springframework.security.userdetails.UserDetailsService;
import org.springframework.security.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 认证服务的实现。
 * 
 * @author Marshal Wu <a
 *         href="mailto:marshal.wu@gmail.com">marshal.wu@gmail.com</a>
 * 
 */
@Service("userDetailsService")
public class SimpleUserDetailsService implements UserDetailsService {

	@Resource(name = "authenticationDao")
	private AuthenticationDao authenticationDao;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		return this.authenticationDao.findByUsername(username);
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateTheUser(Authentication au){
		this.authenticationDao.update(au);
	}
}
