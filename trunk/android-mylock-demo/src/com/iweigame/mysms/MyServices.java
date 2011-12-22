package com.iweigame.mysms;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

public class MyServices extends Service {

	@Override
	public void onCreate() {

		IntentFilter localIntentFilter = new IntentFilter(
				"android.provider.Telephony.SMS_RECEIVED");
		localIntentFilter.setPriority(2147483647);
	//	MyBrocast myService = new MyBrocast();
		//MyBrocast localMessageReceiver = myService;
		Log.v("tag", "onCreate  myservices");
		registerReceiver( new MyBrocast(),
				localIntentFilter);

		super.onCreate();
	}

	@Override
	public void onStart(Intent intent, int startId) {
		Log.v("tag", "onStart  myservices");
		super.onStart(intent, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		Log.v("tag", "onBind  myservices");
		return null;
	}

}
