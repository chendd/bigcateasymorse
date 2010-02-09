#!/usr/bin/env groovy
import java.util.Arrays;

import groovy.lang.Grab; 
import org.apache.log4j.* 
import javax.jms.* 
import org.apache.activemq.ActiveMQConnectionFactory 
import com.lightspeedleader.*;
import com.lightspeedleader.directorywatcher.*

PropertyConfigurator.configure("log4j.properties");
/**
 * 目录监听
 */
//@Grab(group="com.lightspeedleader",module="directorywatcher",version="1.0")
@Grab(group="log4j",module="log4j",version="1.2.12") 
@Grab(group="org.apache.activemq",module="activemq-core",version="5.3.0")
class Monitor extends BaseListener implements IFileListener{ 
    private static Logger logger=Logger.getLogger(Monitor.class)

  
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
       
    } 
    public void onDelete(Object deletedResource) { 
        logger.debug("监控目录有资源被删除，资源名称：${deletedResource}") 
    } 
}

class ShutdownThread extends Thread{ 
    private static final Logger logger=Logger.getLogger(ShutdownThread.class) 
    def dw 
    ShutdownThread(dw){ 
        this.dw=dw 
    } 
    public void run(){ 
        logger.debug("关闭文件目录监控…") 
        this.dw.stop() 
        logger.debug("已关闭。") 
    } 
}
class FileListenerTools(){
	def dw
}
DirectoryWatcher dw = new DirectoryWatcher("ltyds/", 3); 
dw.addListener(new Monitor()); 
dw.start(); 
Runtime.runtime.addShutdownHook(new ShutdownThread(dw))