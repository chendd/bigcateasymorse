package com.android.gifview;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.SurfaceHolder;

public class GifThread extends Thread {
	
	private SurfaceHolder mHolder;  
    private boolean mRunning;  
    private Canvas canvas; 
    private Paint p; 
    private Bitmap bmp;
    private Bitmap bmp2;
    public Resources res;
    private boolean isRunning = false; 

    int i = 0; 
    
    public GifThread(){
    	
    }
	
	public GifThread(SurfaceHolder surfaceHolder, Resources res){
		this.mHolder = surfaceHolder;
		this.res = res;
		
	}
	
	@Override
	public void run() {
//		while (isRunning) { 
//			doDraw();
//		}
		
	}

	public void setRunning(boolean b) {
		isRunning = b;
	}
	


}
