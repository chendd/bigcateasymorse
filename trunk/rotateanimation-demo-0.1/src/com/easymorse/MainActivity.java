package com.easymorse;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;

public class MainActivity extends Activity {

	private View mView;

	private static final String TAG = "transtion demo";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mView = (View) findViewById(R.id.mContener);
	}

	public void showAnimation(View view) {
		Log.v(TAG, "showContent>>>");

		final float centerX = mView.getWidth() / 2.0f;
		final float centerY = mView.getHeight() / 2.0f;
		RotateAnimation rotateAnimation = new RotateAnimation(0, 180, centerX,
				centerY);
		rotateAnimation.setDuration(1000 * 20);
		rotateAnimation.setFillAfter(true);
		mView.startAnimation(rotateAnimation);
	}
}