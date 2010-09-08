package util;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class IPToRegionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = Logger.getLogger(IPToRegionServlet.class);

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.debug("start ip to region servelt ");
		if(request.getParameter("ip") != null && !request.getParameter("ip").isEmpty()){
			request.setAttribute("regionModel",CountryLookup.formatIpToRegion(request.getParameter("ip")));
			RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp"); 
			dispatcher .forward(request, response); 
		}
		
	}

	
}
