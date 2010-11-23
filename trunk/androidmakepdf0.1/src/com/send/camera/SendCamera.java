package com.send.camera;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
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
import com.pdfjet.Image;
import com.pdfjet.ImageType;
import com.pdfjet.PDF;
import com.pdfjet.Page;

public class SendCamera extends Activity {
	private Button openCamera;
	private Button sendMail;
	private ImageView imageView;

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
		sendMail = (Button) findViewById(R.id.sendButton);
		imageView = (ImageView) findViewById(R.id.preview);
		
		openCamera.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
				intent.putExtra(MediaStore.EXTRA_OUTPUT,
						Uri.fromFile(new File(Environment
								.getExternalStorageDirectory(), "camera.jpg")));

				intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
				
				startActivityForResult(intent, 0);

			}

		});
		sendMail.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				sendMail();
			}
		});

	}

	public void makePdf(String fileName,String pdfName,int width)  {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(PATH + File.separator
					+ pdfName);
		

		PDF pdf = new PDF(fos);


		BufferedInputStream bis1 = new BufferedInputStream(new FileInputStream(
				new File(Environment.getExternalStorageDirectory(),
						fileName)));
		Image image1 = new Image(pdf, bis1, ImageType.JPEG);

		Page page = new Page(pdf, A4.PORTRAIT);


		image1.setPosition(15, 10);
		image1.scaleBy(550D/Double.valueOf(width));
		image1.drawOn(page);
		
		pdf.flush();
		fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
			String fileName = "camera.jpg";
			String finalFileName = "endimage.jpg";
			int width = compressImage(fileName,finalFileName);
			this.imageView.setImageDrawable(Drawable.createFromPath(new File(
					Environment.getExternalStorageDirectory(), finalFileName)
					.getAbsolutePath()));

			try {
				makePdf(finalFileName,"myfrist.pdf",width);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int compressImage(String fileName,String finalFileName){
		
		BitmapFactory.Options opts = new BitmapFactory.Options();
		BitmapFactory.decodeFile(PATH+File.separator+fileName ,opts);
		int srcWidth = opts.outWidth;
		
		int srcHeight = opts.outHeight;
		int destWidth = 0 ;
		int destHeight = 0;
		double ratio = 0.0;
		int maxLength = 1024;
		if(srcWidth >srcHeight) {
			ratio = srcWidth / maxLength;
			destWidth = maxLength;
			destHeight = (int) (srcHeight / ratio);
			}
			else {
			ratio = srcHeight / maxLength;
			destHeight = maxLength;
			destWidth = (int) (srcWidth / ratio); 
			}
		
		//对图片进行压缩，是在读取的过程中进行压缩，而不是把图片读进了内存再进行压缩
		BitmapFactory.Options newOpts = new BitmapFactory.Options();
		//缩放的比例，缩放是很难按准备的比例进行缩放的，目前我只发现只能通过inSampleSize来进行缩放，其值表明缩放的倍数，SDK中建议其值是2的指数值
		newOpts.inSampleSize = (int) ratio + 1;
		//inJustDecodeBounds设为false表示把图片读进内存中
		newOpts.inJustDecodeBounds = false;
		//设置大小，这个一般是不准确的，是以inSampleSize的为准，但是如果不设置却不能缩放
		newOpts.outHeight = destHeight;
		newOpts.outWidth = destWidth;
		//添加尺寸信息，
	
		//获取缩放后图片
		Bitmap destBm = BitmapFactory.decodeFile(PATH+File.separator+fileName, newOpts);
			
		File destFile = new File(PATH+File.separator+finalFileName);
		//创建文件输出流
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(destFile);
			//存储
			destBm.compress(CompressFormat.JPEG ,50 ,outputStream);
			//关闭流
			outputStream.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BitmapFactory.Options options = new BitmapFactory.Options();
		BitmapFactory.decodeFile(PATH+File.separator+finalFileName ,options);
		return options.outWidth;
	
	}
public void sendMail(){
	Intent intent = new Intent(android.content.Intent.ACTION_SEND);
	
	File file = new File(Environment
			.getExternalStorageDirectory().getPath()+File.separator+"myfrist.pdf");
	 
	//intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"723375446@qq.com"});
	//intent.putExtra(android.content.Intent.EXTRA_TEXT, "测试");
	 intent.setType("application/octet-stream");
	 intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file)); 
	startActivity(intent);
}
}