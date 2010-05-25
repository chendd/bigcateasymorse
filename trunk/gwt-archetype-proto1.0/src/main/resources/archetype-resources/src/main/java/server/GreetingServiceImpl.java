#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ${package}.server.dao.UserDao;

import ${package}.beans.User;

import ${package}.client.rpc.GreetingService;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	private static final Logger logger = Logger
			.getLogger(GreetingServiceImpl.class);

	public String greetServer(String input) {
		// String serverInfo = getServletContext().getServerInfo();
		// String userAgent = getThreadLocalRequest().getHeader("User-Agent");
		// return "Hello, " + input + "!<br><br>I am running " + serverInfo
		// + ".<br><br>It looks like you are using:<br>" + userAgent;
		List<User> userList = new ArrayList<User>();
		User user = new User();

		user.setId(String.valueOf(System.currentTimeMillis()));
		user.setName(input);
		userList.add(user);
		return String.valueOf(userList.get(0).getName());
	}

	@Override
	public String login(String userInfo) {
		logger.debug("user info is :" + userInfo);
		User user = new User();

		user.setName(userInfo.split("-")[0]);
		user.setPassword(userInfo.split("-")[1]);
		

		String result = new UserDao().findUser(user);
		if ("success".equals(result.split("-")[0])) {
			this.getThreadLocalRequest().getSession().setAttribute("username",
					user.getName() +"-"+ result.split("-")[1]);
		}
		logger.debug("查询数据的结果是" + result);
		return result;
	}

	@Override
	public String isLogined(String message) {
		if (this.getThreadLocalRequest().getSession().getAttribute("username") != null) {
			return "logined"+"-"+this.getThreadLocalRequest().getSession().getAttribute("username").toString().split("-")[1];
		} else {
			return "notlogin";
		}

	}

}
