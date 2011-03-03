package com.easymorse;

import android.util.Log;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;

public class GestureDeal implements OnGestureListener {

	private static final String TAG = "tag";

	private View view;

	private TranslateAnimation inAnimation, outAnimation;

	private boolean sign;

	public GestureDeal(View view) {
		this.view = view;
		inAnimation = new TranslateAnimation(0, 480, 50, 50);
		inAnimation.setDuration(20000);
		inAnimation.setFillBefore(true);
		inAnimation.setFillAfter(true);

		outAnimation = new TranslateAnimation(480, 0, 50, 50);
		outAnimation.setDuration(20000);
		outAnimation.setFillBefore(true);
		outAnimation.setFillAfter(true);
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	//清扫
	@Override
	public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		Log.v(TAG, "onFling>>>>x=" + arg2 + "  y=" + arg3);
		if (arg2 < 0 && !sign) {
			this.view.startAnimation(outAnimation);
			sign = true;
		} else {
			if (sign && arg2 > 0) {
				this.view.startAnimation(inAnimation);
				sign = false;
			}

		}

		return false;
	}

	//长按
	@Override
	public void onLongPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		Log.v(TAG, "onLongPress>>>>");
	}

	//滑动
	@Override
	public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
			float arg3) {
		// TODO Auto-generated method stub
		Log.v(TAG, "onScroll>>>>x=" + arg2 + "  y=" + arg3);
		return false;
	}

	//短按
	@Override
	public void onShowPress(MotionEvent arg0) {
		// TODO Auto-generated method stub
		Log.v(TAG, "onShowPress>>>>");
	}

	//点击
	@Override
	public boolean onSingleTapUp(MotionEvent arg0) {
		// TODO Auto-generated method stub
		Log.v(TAG, "onSingleTapUp>>>>");
		return false;
	}
}
