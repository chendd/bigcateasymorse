/*
 * Copyright 2010 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.easymorse.myc2dm;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;

import com.google.android.c2dm.C2DMBaseReceiver;

public class C2DMReceiver extends C2DMBaseReceiver {
    public C2DMReceiver() {
    	
        super(DeviceRegistrar.SENDER_ID);
        Log.v("tag","c2dm>>>>>C2DMReceiver");
    }

    @Override
    public void onRegistered(Context context, String registration) {
        DeviceRegistrar.registerWithServer(context, registration);
        Log.v("tag","c2dm>>>>>C2DMReceiver>>>>>>>onRegistered and the id is : "+registration);
    }

    @Override
    public void onUnregistered(Context context) {
      
        String deviceRegistrationID = null;
        DeviceRegistrar.unregisterWithServer(context, deviceRegistrationID);
        Log.v("tag","c2dm>>>>>C2DMReceiver>>>>>>>onUnregistered");
    }

    @Override
    public void onError(Context context, String errorId) {
        context.sendBroadcast(new Intent("com.google.ctp.UPDATE_UI"));
    }

    @Override
    public void onMessage(Context context, Intent intent) {
    	 Log.v("tag","c2dm>>>>>C2DMReceiver>>>>>>>onMessage");
        Bundle extras = intent.getExtras();
        if (extras != null) {
            String url = (String) extras.get("url");
            Log.v("tag","c2dm>>>>>C2DMReceiver>>>>>>>onMessage>>>>url is "+url);
            Editor sharedata = getSharedPreferences(
					"myc2dm", 0).edit();
			sharedata.putString("serverdata",url);    
			
		      NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); 
		        Notification notification = new Notification(R.drawable.icon, 
		                "收到消息", System.currentTimeMillis()); 
		        notification.setLatestEventInfo(getApplicationContext(), "消息内容", 
		        		url, PendingIntent.getActivity(
		                        C2DMReceiver.this, 0, 
		                        new Intent(C2DMReceiver.this,MainActivity.class), 0)); 
		        notification.flags|=Notification.FLAG_AUTO_CANCEL; 
		        notification.defaults |= Notification.DEFAULT_SOUND; 
		        manager.notify(1, notification); 

        }
    }
}
