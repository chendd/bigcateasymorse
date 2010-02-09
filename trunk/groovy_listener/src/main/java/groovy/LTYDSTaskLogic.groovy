#!/usr/bin/env groovy

import groovy.sql.Sql;
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.*;
import groovy.xml.MarkupBuilder;
import org.apache.log4j.Logger;
import groovy.lang.Grab;
import com.lightspeedleader.directorywatcher.*

//@Grab(group="log4j",module="log4j",version="1.2.12")
//@Grab(group="org.apache.activemq",module="activemq-core",version="5.3.0")
class DealMoMsg extends BaseListener implements IFileListener{
	def classloader=new GroovyClassLoader()
	def tools =classloader.parseClass(new File("Tools.groovy")).newInstance()
	def jmsListener_LTYDS8 = classloader.parseClass(new File("ltyds/JMSListener_LTYDS8.groovy")).newInstance()
	def jmsListener_LTYDSd = classloader.parseClass(new File("ltyds/JMSListener_LTYDSd.groovy")).newInstance()
	private static Logger logger=Logger.getLogger(DealMoMsg.class)

	def tests(){
		
			logger.debug("开始监听LTYDS队列")
			tools.getSessionAndConsumer("LTYDS","d",jmsListener_LTYDSd)
			tools.getSessionAndConsumer("LTYDS","8",jmsListener_LTYDS8)
			tools.dealSession()		
		
	} 
	  
	  public void onStart(Object monitoredResource) { 
	        logger.debug("开始监控目录资源，目录为：${monitoredResource}") 
	    }
	  
	    public void onStop(Object notMonitoredResource) { 
	        logger.debug("停止监控目录资源，目录为：${notMonitoredResource}") 
	        connection.close() 
	    } 
	    
	    public void onAdd(Object newResource) { 
	        logger.debug("监控目录增加了新资源，资源名称：${newResource}") 
	    
	    }

	    public void onChange(Object changedResource) { 
	        logger.debug("监控目录有资源发生变化，资源名称：${changedResource}")
	        def changedFile = changedResource.toString().split("/")[changedResource.toString().split("/").length-1]
	        tools.closeListener()
			logger.debug("改变 的文件名称是"+changedFile)
	        def classloaders=new GroovyClassLoader()
	        def j= classloaders.parseClass(new File("ltyds/${changedFile}")).newInstance()
			tools.getSessionAndConsumer("LTYDS","d",j)
			tools.dealSession()
	       
	    } 
	    public void onDelete(Object deletedResource) { 
	        logger.debug("监控目录有资源被删除，资源名称：${deletedResource}") 
	    } 
}
def deal = new DealMoMsg()
DirectoryWatcher dw = new DirectoryWatcher("ltyds/", 5); 
dw.addListener(deal); 
dw.start(); 
deal.tests()