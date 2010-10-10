package com.myflashlight;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;


public class PreView extends SurfaceView implements SurfaceHolder.Callback {

	private SurfaceHolder holder = null;
	private Camera mCamera = null;
	private Bitmap mBitmap = null;

	public PreView(Context context) {
		super(context);
		Log.i("TAG", "PreView()");
		// TODO Auto-generated constructor stub
		holder = this.getHolder();
		holder.addCallback(this);
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		Log.i("TAG", "surfaceChanged");
		// TODO Auto-generated method stub
		if(mCamera != null){
		Camera.Parameters parameters = mCamera.getParameters();
		parameters.setPictureFormat(PixelFormat.JPEG);//设置图片格式
		//parameters.setPreviewSize(320, 480);//设置尺寸
//		parameters.setPictureSize(320, 480);//设置分辨率
		parameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
		mCamera.setParameters(parameters);
		mCamera.startPreview();//开始预览
		}
	}

	public void surfaceCreated(SurfaceHolder holder) {
		Log.i("TAG", "surfaceCreated");
		// TODO Auto-generated method stub
		try{
		mCamera = Camera.open();//启动服务
		}catch(Exception e){
					
		}
//		try {
//			mCamera.setPreviewDisplay(holder);//设置预览
//		} catch (IOException e) {
//			mCamera.release();//释放
//			mCamera = null;
//		}
	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.i("TAG", "surfaceDestroyed");
		// TODO Auto-generated method stub
		mCamera.stopPreview();//停止预览
		mCamera = null;
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(keyCode==KeyEvent.KEYCODE_DPAD_CENTER){
			if(mCamera !=null){
				mCamera.takePicture(null, null,pic);
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	//拍照后输出图片
	public Camera.PictureCallback pic = new Camera.PictureCallback(){

		public void onPictureTaken(byte[] data, Camera camera) {
			// TODO Auto-generated method stub
			mBitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
			File f = new File(android.os.Environment.getExternalStorageDirectory()+"/camera1.jpg");
			try {
				BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(f));
				mBitmap.compress(Bitmap.CompressFormat.JPEG, 80, os);
				os.flush();
				os.close();
				Canvas canvas = holder.lockCanvas();
				canvas.drawBitmap(mBitmap, 0, 0, null);
				holder.unlockCanvasAndPost(canvas);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	};
}

