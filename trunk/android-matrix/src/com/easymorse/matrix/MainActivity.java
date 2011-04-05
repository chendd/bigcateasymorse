package com.easymorse.matrix;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ImageView imageView;
		Matrix mMatrix = new Matrix();
		imageView = (ImageView) findViewById(R.id.myimage);

		Bitmap bmp = ((BitmapDrawable) getResources().getDrawable(
				R.drawable.picture1)).getBitmap();
		//旋转60度
		//mMatrix.setRotate(60);
		//倾斜
		//mMatrix.postSkew(0.3f, 0.7f);
		//放大缩小
		//mMatrix.setScale(0.5f, 2.5f);
		
		
		mMatrix.setTranslate(260f, 500f);
		
		Bitmap bm = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(),
				bmp.getHeight(), mMatrix, true);

		imageView.setImageBitmap(bm);
	}
}