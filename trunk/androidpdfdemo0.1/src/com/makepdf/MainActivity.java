package com.makepdf;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
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

import dalvik.system.VMRuntime;

public class MainActivity extends Activity {
	private Button scanButton;
	private Button makePdfButton;
	private ImageView imageView;
	String imageName = null;
	
	private final static int CWJ_HEAP_SIZE = 16* 1024* 1024 ;
	private final static float TARGET_HEAP_UTILIZATION = 0.75f;
	private List<String> imageNameList = new ArrayList<String>();
	private static final String PATH = Environment
	.getExternalStorageDirectory().getPath();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        VMRuntime.getRuntime().setTargetHeapUtilization(TARGET_HEAP_UTILIZATION);
        setContentView(R.layout.main);
        scanButton = (Button)findViewById(R.id.scan);
        makePdfButton = (Button)findViewById(R.id.makepdf);
        imageView = (ImageView)findViewById(R.id.scanImage);
        VMRuntime.getRuntime().setMinimumHeapSize(CWJ_HEAP_SIZE);
        scanButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				imageName = "pdf"+System.currentTimeMillis()+".jpg";
				imageNameList.add(imageName);
				Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
				
				intent.putExtra(MediaStore.EXTRA_OUTPUT,
						Uri.fromFile(new File(Environment
								.getExternalStorageDirectory(), imageName)));

				intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 0);
				Log.v("path-----",
						">>>>>" + Environment.getExternalStorageDirectory());
				startActivityForResult(intent, 0);
				
			}
		});
        
        makePdfButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				makePdf("pdfdemo.pdf",imageNameList);
				sendMail("pdfdemo.pdf");
			}
        	
        });
    }
    
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
			 dialogs = ProgressDialog
				.show(MainActivity.this, "",
						"处理图片...", true);
		 
			new Thread(new Runnable() {

			    @Override 
			    public void run() { 
			    	Message message = sendImageHandler.obtainMessage();
			    	message.arg1= zoomImage(imageName,595, 842, "finals"+imageName);
			    	
			    	sendImageHandler.sendMessage(message);
			    } 
			}).start(); 
			
			
			this.imageView.setImageDrawable(Drawable.createFromPath(new File(
					Environment.getExternalStorageDirectory(), "finals"+imageName)
					.getAbsolutePath()));

		}
	}
	public void makePdf( String pdfName,List<String> imageList){
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(PATH + File.separator + pdfName);

			PDF pdf = new PDF(fos);
			int width =0;
			for(String fileName:imageList){
				
				width = zoomImage(fileName,595, 842, "final"+fileName);
				
				BufferedInputStream bis1 = new BufferedInputStream(
						new FileInputStream(
								new File(PATH,
										"final"+fileName)));
				Image image1 = new Image(pdf, bis1, ImageType.JPEG);

				Page page = new Page(pdf, A4.PORTRAIT);

				image1.setPosition(15, 10);
				image1.scaleBy(550D / Double.valueOf(width));
				image1.drawOn(page);
			}
			

			pdf.flush();
			fos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/***
	 * 图片的缩放方法
	 * 
	 * @param bgimage
	 *            ：源图片资源
	 * @param newWidth
	 *            ：缩放后宽度
	 * @param newHeight
	 *            ：缩放后高度
	 * @return
	 */
	public int zoomImage(String fileName, int newWidth, int newHeight,
			String finalFileName) {
		Bitmap bgimage= null;
		BitmapFactory.Options   options = new BitmapFactory.Options();
		//options.inSampleSize=10;
		//options.inJustDecodeBounds = true;
		bgimage= BitmapFactory.decodeFile(PATH
				+ File.separator + fileName, options);
		//bgimage.recycle();
		// 获取这个图片的宽和高
		//options.outHeight
	
		int width = bgimage.getWidth();
		int height = bgimage.getHeight();
		// 创建操作图片用的matrix对象
		Matrix matrix = new Matrix();
		// 计算缩放率，新尺寸除原始尺寸
		float scaleWidth = ((float) newWidth) / options.outWidth;
		float scaleHeight = ((float) newHeight) / options.outHeight;
		// 缩放图片动作
		matrix.postScale(scaleWidth, scaleHeight);
		matrix.setRotate(90);
		
		Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, (int)width, (int)height,
				matrix, false);

		File destFile = new File(PATH + File.separator + finalFileName);
		// 创建文件输出流
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream(destFile);
			// 存储
			bitmap.compress(CompressFormat.JPEG, 25, outputStream);
			// 关闭流
			outputStream.close();
			//bitmap.recycle();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bitmap.getWidth();
	}
	/**
	 *  发送邮件
	 */
	public void sendMail(String attachment) {
		Intent intent = new Intent(android.content.Intent.ACTION_SEND);

		File file = new File(PATH + File.separator +attachment);
		intent.setType("application/octet-stream");
		intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
		startActivity(intent);
	}

	
	ProgressDialog dialogs;
	/**
	 *  声明一个Handler 
	 */
	 Handler sendImageHandler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				
				if(msg.arg1 !=0 ){
					  dialogs.dismiss();
				}else{
					/**
					 * 提示框
					 */
				}
			}
			 
		 };
}