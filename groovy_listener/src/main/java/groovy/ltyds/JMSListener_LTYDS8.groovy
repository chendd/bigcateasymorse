package groovy.ltyds;
import groovy.sql.Sql;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import groovy.xml.MarkupBuilder;
import org.apache.log4j.Logger;
import groovy.lang.Grab;
//@Grab(group="org.apache.activemq",module="activemq-core",version="5.3.0")
class JMSListener implements MessageListener{
	
	def classloader=new GroovyClassLoader()
	def connectionFactory=classloader.parseClass(new File("JMSService.groovy")).newInstance().connectionFactory
	def connection
	def session
	def message
	def destination
	def producer
	def queueName
	public void onMessage(Message message) {
		println """
收到消息,是以8为开头的短信上行: ${message}
		进行业务逻辑处理，并且生成下发mt信息，记录数据库
"""
		session = getSession()
	//	String mtMsg = "phonenumber:"+message.getStringProperty("phonenumber")+",longcode:10660123,linkid:"+message.getStringProperty("linkid")+",taskname:LTYDS,messagecontent:8A"
		println """
		the mt message is :>>>>>${mtMsg}
"""
		Message msg = session.createTextMessage("测试短信!!!")
	//	msg.setStringProperty("ucPkTotal", "1")
msg.setStringProperty("ucPkTotal", "1")
msg.setStringProperty("ucPkNumber", "1")
msg.setStringProperty("ucRegisterDelivery", "1")
msg.setStringProperty("ucMsgLevel", "1")
msg.setStringProperty("sServiceId", "LTYDS")
msg.setStringProperty("ucFeeUserType", "0")
msg.setStringProperty("sFeeTerminalId", "手机号码")/////////
msg.setStringProperty("ucFeeTermType", "0")
msg.setStringProperty("ucTpPid", "0")
msg.setStringProperty("ucTpUdhi", "0")
msg.setStringProperty("ucMsgFmt", "15")
msg.setStringProperty("sMsgSrc","901709")
msg.setStringProperty("sFeeType", "02")
msg.setStringProperty("sFeeCode", "100")
msg.setStringProperty("sAtTime", "")//////
msg.setStringProperty("sSrcTerminalId", "10660123")
msg.setStringProperty("ucDstTermType", "0")
msg.setStringProperty("sLinkId", "")//////////

		
		producer.send(msg)
		session.commit()
		
		//((TextMessage)message)
	}
	def getSession(){
		connection=getConnection()
		session=connection.createSession(true,javax.jms.Session.AUTO_ACKNOWLEDGE)
		destination=session.createQueue("LTYDS")
		producer = session.createProducer(destination)
		producer.setDeliveryMode(javax.jms.DeliveryMode.PERSISTENT)
		session
	}
	def getConnection(){
		if(null == connection){
			connection=connectionFactory.createConnection()
			connection.start()
		}
		
		connection
	}
}