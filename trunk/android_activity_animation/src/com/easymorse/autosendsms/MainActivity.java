package com.easymorse.autosendsms;


import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		findViewById(R.id.sendButton).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				 startActivity(new Intent(MainActivity.this,SecondActivity.class));

		         overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
				
				
			}
		});

	}
}