package com.iweigame.test;

import java.security.Provider;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

/**
 * 
 * @author dahui <a href="mailto:jiessiedyh@gmail.com">jiessiedyh@gmail.com</a> 
 *
 */
public class MySmsServices extends Service {

	private static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";
	
	private static final int SMS_PRIORITY = 2147483647;
	
	@Override
	public void onCreate() {
		
		IntentFilter localIntentFilter = new IntentFilter(SMS_RECEIVED_ACTION);
		// 设置动态优先级
		localIntentFilter.setPriority(SMS_PRIORITY);
		// 创建ASSmsBroadcast()广播
		registerReceiver(new MySmsBroadcast(), localIntentFilter);
		super.onCreate();
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
}
