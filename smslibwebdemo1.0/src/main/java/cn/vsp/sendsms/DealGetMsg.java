package cn.vsp.sendsms;

import org.apache.log4j.Logger;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.Message.MessageEncodings;
import org.smslib.modem.SerialModemGateway;

public class DealGetMsg {

	private static final Logger logger = Logger.getLogger(DealGetMsg.class);
	public String phone;
	public String message;
	
	static Service srv;
	static OutboundMessage msg;
	static SerialModemGateway gateway ;
	
	

	public boolean dealGet(String phonenum, String message,int port) {
		
		
		gateway.setInbound(true);
		gateway.setOutbound(true);
		try {
			logger.debug("端口是>>>>>>>>"+port);
			msg = new OutboundMessage(phonenum, message);
			msg.setEncoding(MessageEncodings.ENCUCS2);
			msg.setStatusReport(true);
			msg.setDstPort(port);
			msg.setSrcPort(port);
			return srv.sendMessage(msg);
			
			//srv.stopService();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	static {
		
		srv = new Service();
		gateway = new SerialModemGateway("modem.com5",
				"/dev/ttyS0", 115200, "WAVECOM", "–");
		try {
			srv.addGateway(gateway);
		//	ReciveSmsListener reciveSmsListener = new ReciveSmsListener();
		//	reciveSmsListener.srv = srv;
		//	srv.setInboundMessageNotification(reciveSmsListener);
			srv.startService();
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}
		
	}
}
