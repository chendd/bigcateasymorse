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
    	
    	registrationIntent.setClassName("com35.push", "com35.push.MessageService");
		registrationIntent.putExtra("appid", PendingIntent.getBroadcast(this, 0, new Intent(), 0)); // boilerplate
		registrationIntent.putExtra("key", "123456");
		
		startService(registrationIntent);
    }
}