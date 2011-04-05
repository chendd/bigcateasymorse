package com.easymorse.matrix;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView imageView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		imageView = (ImageView) findViewById(R.id.myimage);

	}

	public void showAnimation(View view) {
		Log.v("tag", ">>>>>>>>>>>>>" + view.getWidth());
		final float centerX = view.getWidth() / 2.0f;
		final float centerY = view.getHeight() / 2.0f;

		final Rotate3dAnimation rotation = new Rotate3dAnimation(0, 180,
				centerX, centerY);
		rotation.setDuration(1000);
		rotation.setFillAfter(true);

		imageView.startAnimation(rotation);
	}
}