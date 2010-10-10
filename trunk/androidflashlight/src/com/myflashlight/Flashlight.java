package com.myflashlight;

import android.app.Activity;
import android.os.Bundle;

public class Flashlight extends Activity {
	
	private PreView preView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
      preView = new PreView(this);  
      setContentView(preView);  
    }
}