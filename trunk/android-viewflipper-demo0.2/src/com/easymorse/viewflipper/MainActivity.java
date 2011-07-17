package com.easymorse.viewflipper;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

public class MainActivity extends Activity {
	
	ViewFlipper viewFlipper ;
	
	GestureDetector gestureDetector;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        viewFlipper = (ViewFlipper)findViewById(R.id.myViewFlipper);
        
        viewFlipper.addView(getLayoutInflater().inflate(R.layout.textlayout, null),viewFlipper.getChildCount());
        
        gestureDetector = new GestureDetector(new OnGestureListener() {
			
			@Override
			public boolean onSingleTapUp(MotionEvent e) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onShowPress(MotionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
					float distanceY) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onLongPress(MotionEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
					float velocityY) {
				Log.v("tag", ">>>>>>>>>>>>>>>>>velocityX>>>"+velocityX);
				if(velocityX>0){
					
					viewFlipper.setInAnimation(getApplicationContext(), R.anim.push_right_in);
					viewFlipper.setOutAnimation(getApplicationContext(), R.anim.push_right_out);
					viewFlipper.showPrevious();
				}else {
				
					viewFlipper.setInAnimation(getApplicationContext(), R.anim.push_left_in);
					viewFlipper.setOutAnimation(getApplicationContext(), R.anim.push_left_out);
					viewFlipper.showNext();
					
				}
				return false;
			}
			
			@Override
			public boolean onDown(MotionEvent e) {
				// TODO Auto-generated method stub
				return false;
			}
		});
    }
    
    @Override
    public boolean onTouchEvent(MotionEvent event) {
    	gestureDetector.onTouchEvent(event);
    	return super.onTouchEvent(event);
    }
}