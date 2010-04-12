package cn.vsp.server;

import org.apache.log4j.Logger;

import cn.vsp.bean.SmsBean;
import cn.vsp.client.GreetingService;
import cn.vsp.dao.SmsBeanDao;
import cn.vsp.util.DealGetMsg;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements
		GreetingService {

	SmsBean smsBean;

	private static final Logger logger = Logger
			.getLogger(GreetingServiceImpl.class);

	public String greetServer(String input) {
		String serverInfo = getServletContext().getServerInfo();
		String userAgent = getThreadLocalRequest().getHeader("User-Agent");
		return "Hello, " + input + "!<br><br>I am running " + serverInfo
				+ ".<br><br>It looks like you are using:<br>" + userAgent;
	}

	@Override
	public String dealSms(String phoneNum, String message, String smsSign) {

		logger.debug("手机号码是：" + phoneNum + "短信内容是" + message);

//		try {
//			new Thread().sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		DealGetMsg dealGetMsg = new DealGetMsg();
		if (dealGetMsg.dealGet(phoneNum, message)) {
		//if(true){
			SmsBeanDao smsBeanDao = new SmsBeanDao();
			smsBean = new SmsBean();
			smsBean.setPhoneNum(phoneNum);
			smsBean.setMessage(message);
			smsBean.setSmsSign(smsSign);
			smsBeanDao.insetSms(smsBean);
			return "success";
		} else {
			return "failure";
		}

	}

	@Override
	public String findSmsBean(String smsSign) {
	
		SmsBeanDao smsBeanDao = new SmsBeanDao();
		SmsBean smsBean = smsBeanDao.findSmsBeanBysmsSign(smsSign);
		return smsBean.getPhoneNum()+","+smsBean.getMessage();
	}
}
