package com.android.gifview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.Scroller;

public class SurfaceActivity extends Activity implements OnGestureListener{
	
	private GitView gitView = null;
	
	private  GestureDetector myGesture;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        gitView = new GitView(this);
        setContentView(gitView);
        
        myGesture = new GestureDetector(this);
    }
    
    
    
    
    @Override
	public boolean onTouchEvent(MotionEvent event) {
		return myGesture.onTouchEvent(event);
	}
	public boolean onDown(MotionEvent e) {
		return false;
	}

	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		Log.i("velocityX====>", velocityX + "");
		gitView.onFling((int)-velocityX);
		return true;
	}

	public void onLongPress(MotionEvent e) {
		
	}
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		Log.i("distanceX====>", distanceX + "");
		Log.i("distanceY====>", distanceY + "");
		gitView.handleScroll(-1*(int)distanceX);
		return true;
	}
	public void onShowPress(MotionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO Auto-generated method stub
		return false;
	}

}

