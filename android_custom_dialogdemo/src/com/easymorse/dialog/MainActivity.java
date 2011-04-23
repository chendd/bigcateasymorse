package com.easymorse.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class MainActivity extends Activity {



	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		GifDialog customDialog = new GifDialog(this,R.style.CustomDialogStyle);
		customDialog.setTitle("自定义Dialog");
		
		customDialog.setContentView(R.drawable.animation, new LayoutParams(
				600, 200));
		customDialog.show();

	}

	

}