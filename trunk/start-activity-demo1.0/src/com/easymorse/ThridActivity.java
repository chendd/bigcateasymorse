package com.easymorse;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ThridActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
	}
	
	public void toFrist(View view){
		Log.v("tag", "to frist activity");
		
	}
}
