package com.easymorse.ria.server;


import java.util.ArrayList;
import java.util.List;

import com.easymorse.ria.beans.User;
import com.easymorse.ria.client.rpc.GreetingService;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {
	
	public String greetServer(String input) {
	//	String serverInfo = getServletContext().getServerInfo();
	//	String userAgent = getThreadLocalRequest().getHeader("User-Agent");
	//	return "Hello, " + input + "!<br><br>I am running " + serverInfo
	//			+ ".<br><br>It looks like you are using:<br>" + userAgent;
		List<User> userList = new ArrayList<User>();
		User user = new User();
		
		user.setId(String.valueOf(System.currentTimeMillis()));
		user.setName(input);
		userList.add(user);
		return String.valueOf(userList.get(0).getName());
	}
}
