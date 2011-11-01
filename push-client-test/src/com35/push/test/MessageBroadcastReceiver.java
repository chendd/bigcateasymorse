package com35.push.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MessageBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		
		String clientId = intent.getStringExtra("clientid");
		
		Log.v("tag", "received message from push client!!!!!  and client id is " + clientId);
	
		String pushMessage = intent.getStringExtra("pushmessage");
		
		Log.v("tag", "received message " + pushMessage);

	}

}
