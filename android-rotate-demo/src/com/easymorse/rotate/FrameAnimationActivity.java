package com.easymorse.rotate;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class FrameAnimationActivity extends Activity {

	AnimationDrawable rocketAnimation; 

	ImageView imageView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		imageView = (ImageView) findViewById(R.id.myImageView);
	//	imageView.setBackgroundResource(R.drawable.frameanimation);
//		rocketAnimation = (AnimationDrawable) imageView.getBackground();
		rocketAnimation = (AnimationDrawable) imageView.getDrawable();
		}

		public boolean onTouchEvent(MotionEvent event) {
		  if (event.getAction() == MotionEvent.ACTION_DOWN) {
		    rocketAnimation.start();
		    return true;
		  }
		  if (event.getAction() == MotionEvent.ACTION_UP) {
			    rocketAnimation.stop();
			    return true;
			  }
		  return super.onTouchEvent(event);
		}
	

	

	
}