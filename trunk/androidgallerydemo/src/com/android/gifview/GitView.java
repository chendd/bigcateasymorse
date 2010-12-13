package com.android.gifview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Region;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.Scroller;

public class GitView extends SurfaceView implements Callback, Runnable {
	// GifThread是用来绘制的后台线程，一般使用SurfaceView都会使用一个
	// 后台线程来做绘制的工作
	private GifThread mGifThread;
	private Canvas canvas;

	private Bitmap bitmap;
	private Bitmap nBitmap;
	private Bitmap fBitmap;
	private boolean mbLoop;
	private Context mContext;
	SurfaceHolder mSurfaceHolder = null;

	public int OffsetX = 0;
	public int OffsetY = 0;
	
	private int slideX = 0;
	private int slideWidth = 0;
	private int slideWait = 0;

	public static int postion = 0;
	private boolean mRun = true;
	int mLastFlingX = 0;
	boolean OffsetRight = false;

	private Scroller scroller;

	/**
	 * 构造函数，读者可以自己实现另外的构造函数以方便在xml layout中使用GifView。
	 * 
	 * @param context
	 * @param gifId
	 *            需要显示的Gif图片id，放置在Raw目录下的资源文件
	 */
	public GitView(Context context) {
		super(context);
		// 获取SurfaceHolder
		mSurfaceHolder = this.getHolder();
		// 如果有必要可以设置合适的SurfaceType
		// holder.setType(SurfaceHolder.SURFACE_TYPE_HARDWARE);
		// 设置回调函数
		mSurfaceHolder.addCallback(this);
		// 创建Gif绘制线程
		mbLoop = true;
		this.setFocusable(true);
		
		mContext = context;

		scroller = new Scroller(context);
		scroller.abortAnimation();

	}
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		// TODO Auto-generated method stub
		Log.i("TAG----------------", "surfaceChanged");

	}

	public void surfaceCreated(SurfaceHolder holder) {
		Log.i("TAG----------------", "surfaceCreated");
		bitmap = getBitmap(postion);
		if (postion > 0) {
			postion = postion - 1;
			fBitmap = getBitmap(postion);
		}
		if (postion < 6) {
			postion = postion + 1;
			nBitmap = getBitmap(postion);
		}
		new Thread(this).start();

	}

	public void surfaceDestroyed(SurfaceHolder holder) {
		Log.i("TAG----------------", "surfaceDestroyed");
		// TODO Auto-generated method stub
		// 当Surface即将摧毁的时候，停止绘制线程
		mbLoop = false;
	}

	public void handleScroll(int deltaX) {
		Log.i("TAG----------------", "handleScroll");
		Log.i("deltaX", deltaX + "");

		if (deltaX > 0) {
			OffsetX -= -deltaX;
		} else {
			OffsetX += deltaX;
		}

	}

	public void onFling(int paramFloat1) {
		Log.i("TAG----------------", paramFloat1 + "-------");
		if (OffsetX > 100) {
			if (fBitmap != null) {
				nBitmap = bitmap;
				bitmap = fBitmap;
				fBitmap = null;
			}
		} else if (OffsetX < -100) {
			fBitmap = bitmap;
			bitmap = nBitmap;
			nBitmap = null;
		}
		OffsetX = 0;
		if(fBitmap == null && OffsetX == 0){
			if (postion > 0) {
				postion = postion - 1;
			}else{
				postion = 5;
			}
			fBitmap = getBitmap(postion);
		}else if(nBitmap == null && OffsetX==0){
			if (postion < 5) {
				postion = postion + 1;
			}else{
				postion = 0;
			}
			nBitmap = getBitmap(postion);
		}
	}

	public void run() {
		while (mRun) {
			Canvas canvas = null;
			try {
				canvas = mSurfaceHolder.lockCanvas(null);
				synchronized (mSurfaceHolder) {
					// updateData();
					doDraw(canvas);
				}
			} finally {
				if (canvas != null) {
					mSurfaceHolder.unlockCanvasAndPost(canvas);
				}
			}
		}

	}

	public void doDraw(Canvas canvas) {
		if (mSurfaceHolder == null || canvas == null) {
			return;
		}
		Paint p = new Paint();
		canvas.drawColor(Color.BLACK);
//		Log.i("=360 + OffsetX", 360 + "");
		if (OffsetX < 0) {
			if (nBitmap != null) {
				canvas.drawBitmap(nBitmap, 352 + OffsetX, 0, p);
			}
		} else if (OffsetX > 0) {
			if (fBitmap != null) {
				canvas.drawBitmap(fBitmap, -352 + OffsetX, 0, p);
			}
		}
		if(bitmap != null && OffsetX <= slideWidth){
			canvas.drawBitmap(bitmap, OffsetX, OffsetY, p);
		}
	}

	public Bitmap getBitmap(int currentPos) {
		Bitmap[] bitmap = {
				BitmapFactory
						.decodeResource(mContext.getResources(), R.drawable.g1),
				BitmapFactory
						.decodeResource(mContext.getResources(), R.drawable.g2),
				BitmapFactory
						.decodeResource(mContext.getResources(), R.drawable.g3),
				BitmapFactory
						.decodeResource(mContext.getResources(), R.drawable.g4),
				BitmapFactory
						.decodeResource(mContext.getResources(), R.drawable.g7),
				BitmapFactory
						.decodeResource(mContext.getResources(), R.drawable.g8) };
		if (currentPos > bitmap.length) {
			return null;
		}
	     Bitmap currBitmap = bitmap[currentPos];
		 int k = 320;
		 int l = currBitmap.getWidth();
		 int i1 = (k - l) / 2;
		 OffsetX = i1;
		 slideWidth = l * bitmap.length + 32;
		 int i2 = 480;
		 int i3 = currBitmap.getHeight();
		 int i4 = (i2 - i3) / 2;
		 OffsetY = i4;
		 
		return currBitmap;
	}

}
