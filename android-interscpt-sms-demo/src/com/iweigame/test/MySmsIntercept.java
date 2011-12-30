package com.iweigame.test;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * 
 * @author dahui <a href="mailto:jiessiedyh@gmail.com">jiessiedyh@gmail.com</a> 
 *
 */
public class MySmsIntercept extends BroadcastReceiver {


	@Override
	public void onReceive(Context context, Intent intent) {

			
			Intent service = new Intent(context, MySmsServices.class);
			context.startService(service);
		}
	

}
