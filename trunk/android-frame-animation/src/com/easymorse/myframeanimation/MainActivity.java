package com.easymorse.myframeanimation;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
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

				ImageView rocketImage = (ImageView) findViewById(R.id.myImage);
				rocketImage.setBackgroundResource(R.drawable.myframeanimation);

				AnimationDrawable rocketAnimation = (AnimationDrawable) rocketImage
						.getBackground();
				rocketAnimation.start();

			}
		});
	}
}