package com35.push.net;
/**
 * 连接服务器
* @ClassName: ConnectToServerInterface
* @Description: 描述 
* @author:dengyanhui
* @date 2011-9-21 上午11:29:49
*
 */
public interface ConnectToServerInterface {

	/**
	 * 于服务器保持长连
	* @Title: connectToServer
	* @Description:  描述 
	* @author dengyanhui
	* @date 2011-9-21    
	* @return void    
	* @throws
	 */
	public void connectToServer();
	
	/**
	 * 心跳保持，保证和服务器的连接能够持续
	* @Title: heartLive
	* @Description:  描述 
	* @author dengyanhui
	* @date 2011-9-21    
	* @return void    
	* @throws
	 */
	public void heartLive();
}
