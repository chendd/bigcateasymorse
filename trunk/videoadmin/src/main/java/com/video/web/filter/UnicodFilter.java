package com.video.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class UnicodFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		request.setCharacterEncoding("UTF-8");

		chain.doFilter(request, response);

		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.addHeader("pragma", "no-cache");
		httpServletResponse.addHeader("cache-control", "no-cache");
		httpServletResponse.addHeader("expires", "0");

	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
