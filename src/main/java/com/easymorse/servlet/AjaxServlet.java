package com.easymorse.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.easymorse.hotel.HotelBeanDao;
import com.easymorse.hotel.HotelBeanDaoImpl;
import com.easymorse.hotel.HotelController;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA. User: Administrator Date: 2008-12-16 Time: 20:48:59
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class AjaxServlet extends HttpServlet {
	

	

	
	protected void doGet(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws ServletException,
			IOException {

		this.doPost(httpServletRequest, httpServletResponse);
	}

	
	protected void doPost(HttpServletRequest httpServletRequest,
			HttpServletResponse httpServletResponse) throws ServletException,
			IOException {
		// To change body of overridden methods use File | Settings | File
		// Templates.
		httpServletResponse.setContentType("text/html");
		httpServletResponse.setCharacterEncoding("utf-8");
		PrintWriter out = httpServletResponse.getWriter();

		String userName = httpServletRequest.getParameter("hotel_name").trim();
		// String name = new String (userName.getBytes("iso8859-1"),"UTF-8");

	
		if ("".equals(userName) || null == userName) {
			out.print("m");
		} else {
			if ("hui".equals(userName)) {
				out.print("n");

			} else {
				out.print("y");
			}
		}
	}
}
