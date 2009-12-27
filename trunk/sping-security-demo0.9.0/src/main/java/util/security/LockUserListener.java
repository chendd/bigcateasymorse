package util.security;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.security.Authentication;
import org.springframework.security.event.authentication.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.event.authentication.AuthenticationSuccessEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class LockUserListener implements ApplicationListener {


	private ServletContext servletContext;

	private int sign =0;
	
	public void setSign(int sign) {
		this.sign = sign;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	private SimpleUserDetailsService userDetailsService;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public SimpleUserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(
			SimpleUserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	public void onApplicationEvent(ApplicationEvent event) {
		if (event instanceof AuthenticationFailureBadCredentialsEvent) {
			AuthenticationFailureBadCredentialsEvent authEvent = (AuthenticationFailureBadCredentialsEvent) event;
			org.springframework.security.Authentication authentication = (Authentication) (Authentication) authEvent
					.getSource();
			String username = (String) authentication.getPrincipal();

			addCount(username);
		}

		if (event instanceof AuthenticationSuccessEvent) {
			AuthenticationSuccessEvent authEvent = (AuthenticationSuccessEvent) event;
			org.springframework.security.Authentication authentication = (Authentication) (Authentication) authEvent
					.getSource();
			util.security.Authentication userInfo = (util.security.Authentication) authentication
					.getPrincipal();

			String username = userInfo.getName();

			cleanCount(userInfo.getUsername());
		}
	}

	@Transactional(propagation = Propagation.SUPPORTS)
	protected void addCount(String username) {
		Map<String, Integer> lockUserMap = getLockUserMap();
		Integer count = lockUserMap.get(username);

		if (count == null) {
			lockUserMap.put(username, Integer.valueOf(1));
		} else {
			int resultCount = count.intValue() + 1;

			if (resultCount >sign ) {
				util.security.Authentication userInfo = (util.security.Authentication) userDetailsService
						.loadUserByUsername(username);
				userInfo.setAccountNonLocked(false);
				userDetailsService.updateTheUser(userInfo);

			} else {
				lockUserMap.put(username, Integer.valueOf(resultCount));
			}
		}
	}

	protected void cleanCount(String username) {
		Map<String, Integer> lockUserMap = getLockUserMap();

		if (lockUserMap.containsKey(username)) {

			lockUserMap.remove(username);
		}
	}

	protected Map<String, Integer> getLockUserMap() {
		Map<String, Integer> lockUserMap = (Map<String, Integer>) servletContext
				.getAttribute("LOCK_USER_MAP");

		if (lockUserMap == null) {
			lockUserMap = new HashMap<String, Integer>();
			servletContext.setAttribute("LOCK_USER_MAP", lockUserMap);
		}

		return lockUserMap;
	}
}
