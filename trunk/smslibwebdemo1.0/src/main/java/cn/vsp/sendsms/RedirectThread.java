package cn.vsp.sendsms;

import java.io.IOException;

import javax.servlet.RequestDispatcher;

import org.apache.log4j.Logger;

import cn.vsp.bean.SmsBean;
import cn.vsp.dao.SmsBeanDao;

public class RedirectThread extends Thread {

	public String phone;
	public String message;
	
	public String smsSign;

	SmsBean smsBean;
	
	private static final Logger logger = Logger.getLogger(RedirectThread.class);

	@Override
	public void run() {
		try {
			
			DealGetMsg dealGetMsg = new DealGetMsg();
			if (dealGetMsg.dealGet(phone,message )) {
				
				logger.debug("发送成功");
			
				SmsBeanDao smsBeanDao = new SmsBeanDao();
				smsBean = new SmsBean();
				smsBean.setPhoneNum(phone);
				smsBean.setMessage(message);
				smsBean.setSmsSign(smsSign);
				smsBeanDao.insetSms(smsBean);
			

			} else {
				

				logger.debug("发送失败!");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
