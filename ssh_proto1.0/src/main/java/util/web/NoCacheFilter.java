package util.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class NoCacheFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		chain.doFilter(request, response);

		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.addHeader("pragma", "no-cache");
		httpServletResponse.addHeader("cache-control", "no-cache");
		httpServletResponse.addHeader("expires", "0");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

}
