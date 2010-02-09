package groovy;
import groovy.sql.Sql;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import groovy.xml.MarkupBuilder;
import org.apache.log4j.Logger;
import groovy.lang.Grab;

//@Grab(group="log4j",module="log4j",version="1.2.12")
//(group="org.apache.activemq",module="activemq-core",version="5.3.0")
class JMSService{
	
	private static connectionFactory
	
	def url="tcp://localhost:61616"
	def username=""
	def password=""
	
	def initConnectionFactory(){
		connectionFactory=new ActiveMQConnectionFactory(url)
	}
	
	def getConnectionFactory(){
		if(!connectionFactory){
			initConnectionFactory()
		}
		connectionFactory
	}
}