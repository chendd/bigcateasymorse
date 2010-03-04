package com.video.web.filter;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.video.domain.User;

public class LoginFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		User user = (User) httpServletRequest.getSession().getAttribute(
				"sessionUser");
		if (user == null || user.getId() == null) {
			StringBuffer send = new StringBuffer();
			send.append(httpServletRequest.getRequestURI());
			if (httpServletRequest.getQueryString() != null) {
				send.append("?" + httpServletRequest.getQueryString());
			}
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/toLogin.do?send="
							+ URLEncoder.encode(send.toString(), "utf-8"));
			dispatcher.forward(request, response);
			return;
		}

		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
