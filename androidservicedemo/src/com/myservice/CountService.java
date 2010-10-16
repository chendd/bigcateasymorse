package com.myservice;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.RemoteViews;

public class CountService extends Service implements ICountService {

	private boolean threadDisable;

	private int count;

	private ServiceBinder serviceBinder = new ServiceBinder();
	private Intent myintent;

	public class ServiceBinder extends Binder implements ICountService {
		@Override
		public int getCount(Intent intent) {
			myintent = intent;
			return count;
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return serviceBinder;
	}

	@Override
	public void onCreate() {
		super.onCreate();

		new Thread(new Runnable() {

			@Override
			public void run() {
				while (!threadDisable) {
					try {
						Thread.sleep(1000 * 5);
					} catch (InterruptedException e) {
					}
					count++;
					Log.v("CountService", "Count is>>>>>>>>>>>>>>>>>>> "
							+ count);
					if (myintent != null && myintent.getExtras() != null) {
						Log.v("intent name", "intent>>>>>>>>>>>>>>>>>> "
								+ myintent.getExtras().getString("name"));

					}

				}
			}
		}).start();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		this.threadDisable = true;
		Log.v("CountService", "on destroy");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.easymorse.ICountService#getCount()
	 */
	public int getCount(Intent intent) {

		return count;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);

		this.myintent = intent;
	}

}
