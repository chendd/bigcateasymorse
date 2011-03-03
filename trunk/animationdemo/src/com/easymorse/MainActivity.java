package com.easymorse;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity  {
	
	GestureDeal gestureDeal;
	
	private GestureDetector gestureDetector;
	
	private static final String TAG="tag";
	
	private TextView textView;
	
	private ImageView imageView;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		textView = (TextView) findViewById(R.id.animation_text);
		imageView =(ImageView) findViewById(R.id.imageViews);
		textView.setLongClickable(true);
		textView.setOnTouchListener(new OnTouchListener() {
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return gestureDetector.onTouchEvent(event); 
			}
		});
		gestureDeal = new GestureDeal(imageView);
		gestureDetector=new GestureDetector(gestureDeal);
	}

}