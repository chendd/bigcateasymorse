package com.easymorse;

import org.smslib.GatewayException;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.Message.MessageEncodings;
import org.smslib.modem.SerialModemGateway;

public class SmsLibTest {

	
	
	public static void main  (String[] args) {
		Service srv; 
		OutboundMessage msg; 
		srv = new Service(); 
		SerialModemGateway gateway = new SerialModemGateway("modem.com5", 
		        "/dev/ttyS0", 115200, "WAVECOM", "–"); 
		gateway.setInbound(true); 
		gateway.setOutbound(true); 
		try {
			srv.addGateway(gateway);
			srv.startService(); 
			 msg = new OutboundMessage("15210133976", "测试"); 
			msg.setEncoding(MessageEncodings.ENCUCS2); 
			msg.setStatusReport(true); 
			msg.setDstPort(77); 
			srv.sendMessage(msg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
	}
}
