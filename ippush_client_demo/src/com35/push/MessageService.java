package com35.push;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com35.push.net.ConnectToServerInterface;
import com35.push.net.ConnectToServerInterfaceImpl;
import com35.push.util.Global;

public class MessageService  extends Service {

	ConnectToServerInterface connectToServerInterface;
	
	@Override
	public IBinder onBind(Intent intent) {
		
		return null;
	}
	
	@Override
	public void onCreate() {
		
		super.onCreate();
		
		connectToServerInterface = new ConnectToServerInterfaceImpl();
		
		Log.v(Global.TAG, ">>>>messageservice onCreate ");
	}

	@Override
	public void onStart(Intent intent, int startId) {
		
		super.onStart(intent, startId);
		Log.v(Global.TAG, ">>>>messageservice onStart ");
		PendingIntent pendingIntent = (PendingIntent)intent.getExtras().get(Global.APPLICATION_ID);
		String applicationId = pendingIntent.getTargetPackage();
		String key =  intent.getStringExtra(Global.KEY);
		Log.v(Global.TAG, ">>>>messageservice applicationID is  "+applicationId +"  key is :" +key );	
		
		String registerID = connectToServerInterface.registerToServer();
		
		//TODO 广播registerid到app
		sendRegisterIDToApp(registerID);
	}
	
	public void sendRegisterIDToApp(String registerID){
		 
		Intent intent = new Intent();  
		intent.setAction("com35.push.intent.REGISTRATION");
		intent.putExtra("register_id" , registerID);
		  
		sendBroadcast(intent);
     
	}
}
