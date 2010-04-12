package cn.vsp.sendsms;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


public class SendSmsServlet extends HttpServlet {

	private static final Logger logger = Logger.getLogger(SendSmsServlet.class);

	

	String smsSign;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		logger.debug(">>>>>执行到了这里 sendsms,电话号码是："
				+ req.getParameter("phonenum") + ">> 短信内容是:"
				+ req.getParameter("msg"));
		if (null != req.getParameter("phonenum")
				&& !"".equals(req.getParameter("phonenum"))) {
			if (null != req.getParameter("msg")
					&& !"".equals(req.getParameter("msg"))) {
				
				smsSign = req.getParameter("phonenum")+System.currentTimeMillis();
				//req.setAttribute("smsSign", smsSign);
				resp.sendRedirect("success.jsp?smsSign="+smsSign);
				
				RedirectThread t = new RedirectThread();
				//String smsMessage  = new String(req.getParameter("msg").getBytes("iso8859-1"),"utf-8");
				t.phone = req.getParameter("phonenum");
				t.message = req.getParameter("msg");
				if(null != req.getParameter("smsPort") && !"".equals(req.getParameter("smsPort"))){
					t.smsPort = Integer.valueOf(req.getParameter("smsPort"));
				}else{
					t.smsPort = -1;
				}
				
				//logger.debug("转化后的短信内容是>>>>"+smsMessage);
				t.smsSign = smsSign;
				t.start();
				
			}

		}

	}

}
