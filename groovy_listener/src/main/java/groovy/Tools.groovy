package groovy;

import groovy.sql.Sql;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import groovy.xml.MarkupBuilder;
import org.apache.log4j.Logger;
import groovy.lang.Grab;

//@Grab(group="log4j",module="log4j",version="1.2.12")
//@Grab(group="org.apache.activemq",module="activemq-core",version="5.3.0")
class Tools{
	
	def classloader=new GroovyClassLoader()
	def connectionFactory=classloader.parseClass(new File("JMSService.groovy")).newInstance().connectionFactory
	
	def connection
	def session
	def message
	def destination
	def producer
	def queueName
	def consumerProperty
	/**
	 * 根据情况，监听不同的队列
	 */
	def getSessionAndConsumer(def queues,def recevierSign,def jmsListener){
		connection=getConnection()
		session=connection.createSession(true,javax.jms.Session.AUTO_ACKNOWLEDGE)
		destination=session.createQueue(queues)
		def consumer=session.createConsumer(destination)
		//def consumer=session.createConsumer(destination)
		consumer.setMessageListener(jmsListener)
	}
	def getSessionAndProducter(def queueName,def sign){
		connection=getConnection()
		session=connection.createSession(true,javax.jms.Session.AUTO_ACKNOWLEDGE)
		destination=session.createQueue(queueName)
		producer=session.createProducer(destination)
		producer.setDeliveryMode(javax.jms.DeliveryMode.PERSISTENT)
		message = session.createTextMessage("my queue test")
		message.setStringProperty("receiver", sign)
		producer.send(message)
		//consumer.setMessageListener(this)
	}
	def getConnection(){
		if(null == connection){
			connection=connectionFactory.createConnection()
			connection.start()
			println """
开启了新的connection
"""
		}
		
		connection
	}
	def dealSession(){
		session.commit()
	}
	def closeListener(){
		session.close()
	}
}
