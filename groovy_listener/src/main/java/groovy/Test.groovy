#!/usr/bin/env groovy
import groovy.sql.Sql;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import groovy.xml.MarkupBuilder;
import org.apache.log4j.Logger;
import groovy.lang.Grab;
//@Grab(group="org.apache.activemq",module="activemq-core",version="5.3.0")
class Testss {
	
	def classloader=new GroovyClassLoader()
	def connectionFactory=classloader.parseClass(new File("JMSService.groovy")).newInstance().connectionFactory
	def connection
	def session
	def message
	def destination
	def producer
	def queueName
	def sendMt() {
		session = getSession()
	//	String mtMsg = "phonenumber:"+message.getStringProperty("phonenumber")+",longcode:10660123,linkid:"+message.getStringProperty("linkid")+",taskname:LTYDS,messagecontent:8A"
		println """
		send mt message 
"""
		//短信内容需要使用英文字母
		Message msg = session.createTextMessage("这是一条测试短信!!!")
		//msg.setStringProperty("ucPkTotal", "1")
msg.setStringProperty("ucPkTotal", "1")


		
		producer.send(msg)
		session.commit()
		
		
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
	def doTheGroovy(){
		session = getSession()
	}
}
def theTest = new Testss()
theTest.sendMt()