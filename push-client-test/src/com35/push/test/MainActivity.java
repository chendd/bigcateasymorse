package com35.push.test;



import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    	Intent registrationIntent = new Intent();
    	//com35.ippush.client.activity.MessageService
    	registrationIntent.setClassName("org.androidpn.demoapp", "com35.ippush.client.activity.MessageService");
		registrationIntent.putExtra("packagename", PendingIntent.getBroadcast(this, 0, new Intent(), 0)); // boilerplate
		registrationIntent.putExtra("applicationid", "0123456789");
		registrationIntent.putExtra("clientid", "");
		registrationIntent.putExtra("reset", true);
		

		startService(registrationIntent);
    }
}