package com.easymorse.rotate;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView imageView;

	//View view;

	int i = 0;
	int j = -1;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		imageView = (ImageView) findViewById(R.id.myImageView);

	}

	public void showAnimation(View view) {
	//	this.view = view;
		 i = 0;
		new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// 耗时操作，
				try {
					for (int a = 0; a < 3; a++) {
						Thread.sleep(4 * 1000);
					
						
						j++;
						i =10 * j;
						myHandler.sendMessage(myHandler.obtainMessage());
					}

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

	}

	
	private Handler myHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			
			if(i==0){
				imageView.setImageResource(R.drawable.hawana_0);
			}
			if(i==1){
				imageView.setImageResource(R.drawable.hawana_1);
			}
			if(i==2){
//				imageView.
				imageView.setImageResource(R.drawable.hawana_2);
			}
			
			// 作UI线程的修改。
			Display display = getWindowManager().getDefaultDisplay();
//			display.getHeight()
			Log.v("tag",">>>>>>>>>>>>>>>>>"+i+">>>>>>>>>>>>"+(i + 10));
			final float centerY = display.getHeight() / 2.0f;
			final float centerX = display.getWidth() / 2.0f;
//			final float centerX = view.getHeight() / 2.0f;
//			final float centerY = view.getWidth() / 2.0f;
			// final float centerX = display.getHeight() / 2.0f;
			// final float centerY = display.getWidth()/ 2.0f;
			Rotate3dAnimation rotation = new Rotate3dAnimation(i, i + 10,
					centerX, centerY);
			rotation.setDuration(4000);
			//imageView.startAnimation(rotation);
			super.handleMessage(msg);
		}

	};
}