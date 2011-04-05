package com.easymorse.matrix;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
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

		Camera camera = new Camera();
		camera.save();
		//camera.rotateY(50f);
		//camera.rotateX(50f);
		camera.rotateZ(50f);
		camera.getMatrix(mMatrix);
		camera.restore();

		Bitmap bm = Bitmap.createBitmap(bmp, 0, 0, bmp.getWidth(),
				bmp.getHeight(), mMatrix, true);

		imageView.setImageBitmap(bm);
	}
}