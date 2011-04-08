package com.easymorse.quickaction;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;

public class MainActivity extends Activity {

	private ViewGroup myView;

	private PopupWindow popupWindow;
	View target;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// 加载布局文件
		myView = (ViewGroup) getLayoutInflater().inflate(R.layout.quickaction,
				null);
		target = (View) myView.findViewById(R.id.tracks);

		popupWindow = new PopupWindow(myView, 400, 135);
		popupWindow.setOutsideTouchable(true);

	}

	public void showQuickAction(View view) {
		// popupWindow.dismiss();
		if (popupWindow.isShowing()) {
			popupWindow.dismiss();
			myView = (ViewGroup) getLayoutInflater().inflate(
					R.layout.quickaction, null);
			target = (View) myView.findViewById(R.id.tracks);
			popupWindow = new PopupWindow(myView, 400, 135);
		} else {
			popupWindow.showAsDropDown(myView, 20, 180);
		}

		Animation animation = new TranslateAnimation(150, 5.0f, 0.0f, 0.0f);
		animation.setDuration(700);
		animation.setFillAfter(true);
		animation.setInterpolator(AnimationUtils.loadInterpolator(this,
				android.R.anim.bounce_interpolator));

		target.startAnimation(animation);

	}
}