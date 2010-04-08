package cn.vsp.receivesms;

import org.apache.log4j.Logger;
import org.smslib.AGateway;
import org.smslib.IInboundMessageNotification;
import org.smslib.InboundMessage;
import org.smslib.OutboundMessage;
import org.smslib.Service;
import org.smslib.Message.MessageTypes;

import cn.vsp.sendsms.SendSmsServlet;

public class ReciveSmsListener implements IInboundMessageNotification {

	private static final Logger logger = Logger
			.getLogger(ReciveSmsListener.class);

	public Service srv;

//	public void process(String gatewayId, MessageTypes msgType,
//			InboundMessage msg) {
//		logger.debug(">>>>自定义的监听器");
//		if (msgType == MessageTypes.INBOUND)
//
//			logger.debug(">>> New Inbound message detected from Gateway: "
//					+ gatewayId);
//		
//		else if (msgType == MessageTypes.STATUSREPORT)
//			
//			logger.debug(">>> New Inbound Status Report message detected from Gateway: "
//							+ gatewayId);
//		logger.debug("message>>>>"+msg);
//		try {
//			srv.findGateway(gatewayId).deleteMessage(msg);
//		} catch (Exception e) {
//			throw new RuntimeException(e);
//		}
//	}

	@Override
	public void process(AGateway arg0, MessageTypes arg1, InboundMessage arg2) {
		logger.debug(">>>>>>>>>>>>>>执行的到了继承的方法，短消息是"+arg2);

	}

}
