package com.easymorse.mygallery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.SpinnerAdapter;

public class MainActivity extends Activity {

	private ImageView imageView1;

	private ImageView imageView2;
	
	private View mContainer;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	    mContainer = (View)findViewById(R.id.mContener);
		SpinnerAdapter spinnerAdapter = new SimpleAdapter(this, getData(),
				R.layout.myfont_layout, new String[] { "mydata" },
				new int[] { android.R.id.text1 });
		Gallery myGallery1 = (Gallery) findViewById(R.id.mygallery1);
		myGallery1.setAdapter(spinnerAdapter);

		imageView1 = (ImageView) findViewById(R.id.album_corver1);
		imageView2 = (ImageView) findViewById(R.id.album_corver2);

		Bitmap bmp = ((BitmapDrawable) getResources().getDrawable(
				R.drawable.powter_album)).getBitmap();

		imageView1.setImageBitmap(this.createReflectedImage(bmp));

		bmp = ((BitmapDrawable) getResources().getDrawable(R.drawable.the_radar))
				.getBitmap();

		imageView2.setImageBitmap(this.createReflectedImage(bmp));
	}

	public List<Map<String, String>> getData() {
		List<Map<String, String>> myList = new ArrayList<Map<String, String>>();
		Map myMap = new HashMap<String, String>();
		myMap.put("mydata", "欧美");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "华语");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "粤语");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "古典");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "音乐人");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "法语");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "日语");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "韩语");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "爵士");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "电子");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "R&B");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "说唱");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "摇滚");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "民谣");
		myList.add(myMap);

		myMap = new HashMap<String, String>();
		myMap.put("mydata", "电影原声");
		myList.add(myMap);

		return myList;
	}

	public static Bitmap createReflectedImage(Bitmap originalImage) {

		final int reflectionGap = 4;

		int width = originalImage.getWidth();
		int height = originalImage.getHeight();

		Matrix matrix = new Matrix();
		matrix.preScale(1, -1);

		Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0,
				height / 2, width, height / 2, matrix, false);

		Bitmap bitmapWithReflection = Bitmap.createBitmap(width,
				(height + height / 2), Config.ARGB_8888);

		Canvas canvas = new Canvas(bitmapWithReflection);

		canvas.drawBitmap(originalImage, 0, 0, null);

		Paint defaultPaint = new Paint();
		canvas.drawRect(0, height, width, height + reflectionGap, defaultPaint);

		canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);

		Paint paint = new Paint();
		LinearGradient shader = new LinearGradient(0,
				originalImage.getHeight(), 0, bitmapWithReflection.getHeight()
						+ reflectionGap, 0x70ffffff, 0x00ffffff,
				TileMode.MIRROR);

		paint.setShader(shader);

		paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));

		canvas.drawRect(0, height, width, bitmapWithReflection.getHeight()
				+ reflectionGap, paint);

		return bitmapWithReflection;
	}

	private void applyRotation(int position, float start, float end) {

		final float centerX = mContainer.getWidth() / 2.0f;
		final float centerY = mContainer.getHeight() / 2.0f;

		final Rotate3dAnimation rotation = new Rotate3dAnimation(start, end,
				centerX, centerY);
		rotation.setDuration(300);
		rotation.setFillAfter(true);

		rotation.setAnimationListener(new DisplayNextView(position));

		mContainer.startAnimation(rotation);
		Log.v("tag", ">>>>>>>>>>start animation");
	}

	public void showContent(View view) {
		applyRotation(1, 0, 90);
	}

	public void showPicture(View view) {
		applyRotation(-1, 0, 90);
	}

	private final class DisplayNextView implements Animation.AnimationListener {
		private final int mPosition;

		private DisplayNextView(int position) {
			mPosition = position;
		}

		public void onAnimationStart(Animation animation) {
		}

		public void onAnimationEnd(Animation animation) {
			Log.v("tag", ">>>>>>>>>>start animation listener");
			mContainer.post(new SwapViews(mPosition));
		}

		public void onAnimationRepeat(Animation animation) {
		}
	}

	/**
	 * This class is responsible for swapping the views and start the second
	 * half of the animation.
	 */
	private final class SwapViews implements Runnable {
		private final int mPosition;

		public SwapViews(int position) {
			mPosition = position;
		}

		public void run() {
			final float centerX = mContainer.getWidth() / 2.0f;
			final float centerY = mContainer.getHeight() / 2.0f;
			Rotate3dAnimation rotation;

			if (mPosition > -1) {
				imageView2.setVisibility(View.VISIBLE);
				imageView1.setVisibility(View.GONE);

			} else {
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.GONE);

			}
			rotation = new Rotate3dAnimation(270, 360, centerX, centerY);
			rotation.setDuration(300);
			rotation.setFillAfter(true);
			mContainer.startAnimation(rotation);
		}
	}

}