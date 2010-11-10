package com.send.camera;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
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

import com.pdfjet.A4;
import com.pdfjet.CodePage;
import com.pdfjet.Embed;
import com.pdfjet.Font;
import com.pdfjet.Image;
import com.pdfjet.ImageType;
import com.pdfjet.PDF;
import com.pdfjet.Page;
import com.pdfjet.TextLine;

public class SendCamera extends Activity {
	private Button openCamera;

	private ImageView imageView ;
	
	private static final String PATH = Environment
	.getExternalStorageDirectory().getPath();

	
	
	AssetManager assetManager;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		assetManager = this.getAssets();
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
	
	
	public void Example_03() throws Exception {
		Log.v("path-----",">>>>>"+Environment
				.getExternalStorageDirectory());
		FileOutputStream fos = new FileOutputStream(PATH + File.separator
				+ "aaa.pdf");

		PDF pdf = new PDF(fos);

		// If PDF/A is not required use Helvetica:
		// Font f1 = new Font(pdf, "Helvetica");

		Font f1 = new Font(pdf, new BufferedInputStream(
				assetManager.open("DroidSans.otf")), CodePage.UNICODE,
				Embed.YES);

	
		BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(new File(Environment
				.getExternalStorageDirectory(), "camera.jpg")));
		Image image1 = new Image(pdf, bis1, ImageType.JPEG);

	

		Page page = new Page(pdf, A4.PORTRAIT);

		TextLine text = new TextLine(f1,
				"The map below is an embedded PNG image");
		text.setPosition(90, 30);
		text.drawOn(page);

		image1.setPosition(90, 40);
		image1.drawOn(page);

		text.setText("JPG image file embedded once and drawn 3 times");
		text.setPosition(90, 550);
		text.drawOn(page);


		text.setText("The map on the right is an embedded BMP image");
		text.setUnderline(true);
		text.setStrikeLine(true);
		text.setTextDirection(15);
		text.setPosition(90, 800);
		text.drawOn(page);


		pdf.flush();
		fos.close();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
			this.imageView.setImageDrawable(Drawable.createFromPath(new File(
					Environment.getExternalStorageDirectory(), "camera.jpg")
					.getAbsolutePath()));
			try {
				Example_03();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			Log.v("status>>>>>",">>>"+HttpUtil.sendFileToServer("camera.jsp",new File(
//					Environment.getExternalStorageDirectory(), "camera.jpg")));

		}
	}
}