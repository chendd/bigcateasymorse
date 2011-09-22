package com35.push.net;

import java.util.UUID;

/**
 * 
* @ClassName: ConnectToServerInterfaceImpl
* @Description: 连接实现类 
* @author:dengyanhui
* @date 2011-9-21 上午11:33:39
*
 */
public class ConnectToServerInterfaceImpl implements ConnectToServerInterface {

	
	
	@Override
	public void connectToServer() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void heartLive() {
		
		
	}

	@Override
	public String registerToServer() {
		//TODO 注册服务器，返回注册id
		return UUID.randomUUID().toString();
	}

}
