#!/usr/bin/env groovy

import groovy.lang.Grab;
import com.easymorse.*;

@Grab(group="log4j",module="log4j",version="1.2.12")
@Grab(group="org.apache.activemq",module="activemq-core",version="5.3.0")
class  MsaConsole{
	
	//private static Logger logger=Logger.getLogger(MsaConsole.class)
	
   def getMsgFromMoQueue
   def moIpQueue
   def moUpQueue

	def start(){
	//	logger.debug("start getMsgFromMoqueue")
		getMsgFromMoQueue = new GetMsgFromMoQueue()
		new Thread(getMsgFromMoQueue).start()
		moIpQueue = new BuildMoIpQueue()
		new Thread(moIpQueue).start()
		moUpQueue = new BuildMoUpQueue()
		new Thread(moUpQueue).start()
	}
	def close(){
	//	logger.info("closing mst service ...")
		getMsgFromMoQueue.close()		
	//	logger.info("closed mst service")
	}
}

class ShutdownThread extends Thread{
	
	//private static final Logger logger=Logger.getLogger(ShutdownThread.class)
	
	def console
	
	ShutdownThread(console){
		this.console=console
	}
	public void run(){
		//logger.debug("shutdown mst console ...")
	//	console.close()
		//logger.debug("msa console has shutdown.")
	}
}
//PropertyConfigurator.configure("log4j.properties")
def msaConsole = new MsaConsole()
def shutdownThread=new ShutdownThread(msaConsole)
Runtime.runtime.addShutdownHook(shutdownThread)
msaConsole.start()