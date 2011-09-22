package com35.push;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    	Intent intent = new Intent();  
		intent.setAction("com35.push.intent.REGISTRATION");
		//intent.addCategory("com35.push.test");
		intent.putExtra("register_id" , "mmmm");
		  
		sendBroadcast(intent);
    }
}