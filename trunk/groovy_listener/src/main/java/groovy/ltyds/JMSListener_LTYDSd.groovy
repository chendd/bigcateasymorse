package groovy.ltyds;
import groovy.sql.Sql;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import groovy.xml.MarkupBuilder;
import org.apache.log4j.Logger;
import groovy.lang.Grab;
//@Grab(group="org.apache.activemq",module="activemq-core",version="5.3.0")
class JMSListener implements MessageListener{
	
	public void onMessage(Message message) {
		println """
收到消息,是以D为开头的短信上行: ${message}  
"""
//		println """
//有加了新的东西了。。。》》》》》》》》》》》
//"""
	}
}