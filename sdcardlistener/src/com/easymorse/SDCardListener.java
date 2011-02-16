package com.easymorse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SDCardListener extends BroadcastReceiver {

	public static final String TAG = "sdcard listenter";
	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Log.v(TAG, ">>>>>>>>>sd card status >>>>"+intent.getAction());
	}

}
