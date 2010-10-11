package com.send.camera;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class SendCamera extends Activity {
	private Button openCamera;

	private ImageView imageView ;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		openCamera = (Button) findViewById(R.id.cameraButton);
		imageView = (ImageView)findViewById(R.id.preview);
		openCamera.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
				intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri
						.fromFile(new File(Environment
								.getExternalStorageDirectory(), "camera.jpg")));
				intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
				Log.v("path-----",">>>>>"+Environment
						.getExternalStorageDirectory());
				startActivityForResult(intent, 0);

			}

		});

	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
			this.imageView.setImageDrawable(Drawable.createFromPath(new File(
					Environment.getExternalStorageDirectory(), "camera.jpg")
					.getAbsolutePath()));
			
			Log.v("status>>>>>",">>>"+HttpUtil.sendFileToServer("my.jsp",new File(
					Environment.getExternalStorageDirectory(), "camera.jpg")));

		}
	}
}