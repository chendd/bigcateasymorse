package com.nea.nehe.lesson06;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * The initial Android Activity, setting and initiating the OpenGL ES Renderer
 * Class @see Lesson06.java
 * 
 * @author Savas Ziplies (nea/INsanityDesign)
 */
public class Run extends Activity {

	/** The OpenGL View */
	private GLSurfaceView glSurface;

	private Lesson06 lesson06;

	private final float TOUCH_SCALE_FACTOR = 180.0f / 320;

	private final float TRACKBALL_SCALE_FACTOR = 36.0f;

	private float mPreviousX;

	private float mPreviousY;

	  private MediaPlayer mMp;
	
	/**
	 * Initiate the OpenGL View and set our own Renderer (@see Lesson06.java)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Create an Instance with this Activity
		glSurface = new HelloOpenGLES20SurfaceView(this);
		// Set our own Renderer and hand the renderer this Activity Context
		// glSurface.setRenderer(new Lesson06(this));
		// Set the GLSurface as View to this Activity
		setContentView(glSurface);

		  mMp = MediaPlayer.create(this, R.raw.drop);
		
		DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
		Log.i("view", "height" + displayMetrics.heightPixels);
		Log.i("view", "width" + displayMetrics.widthPixels);
		Global.height = displayMetrics.heightPixels;
		Global.width = displayMetrics.widthPixels;

	}

	/**
	 * Remember to resume the glSurface
	 */
	@Override
	protected void onResume() {
		super.onResume();
		glSurface.onResume();
	}

	/**
	 * Also pause the glSurface
	 */
	@Override
	protected void onPause() {
		super.onPause();
		glSurface.onPause();
	}

	class HelloOpenGLES20SurfaceView extends GLSurfaceView {

		private Vibrator vibrator = null;

		private SensorManager sensorMgr;
		Sensor sensor;
		private float x, y, z, last_x, last_y, last_z;

		private static final int SHAKE_THRESHOLD = 1000;

		private long lastUpdate;

		public HelloOpenGLES20SurfaceView(Context context) {
			super(context);

			// Create an OpenGL ES 2.0 context.
			// setEGLContextClientVersion(2);
			lesson06 = new Lesson06(context);
			setRenderer(lesson06);
			setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);

			initMethod();
		}

		// @Override
		// public boolean onTrackballEvent(MotionEvent e) {
		// lesson06.xrot += e.getX() * TRACKBALL_SCALE_FACTOR;
		// lesson06.yrot += e.getY() * TRACKBALL_SCALE_FACTOR;
		// requestRender();
		// return true;
		// }
//
//		@Override
//		public boolean onTouchEvent(MotionEvent e) {
//			float x = e.getX();
//			float y = e.getY();
//			switch (e.getAction()) {
//			case MotionEvent.ACTION_MOVE:
//				float dx = x - mPreviousX;
//				float dy = y - mPreviousY;
//				lesson06.xrot += dx * TOUCH_SCALE_FACTOR;
//				lesson06.yrot += dy * TOUCH_SCALE_FACTOR;
//				requestRender();
//			}
//			mPreviousX = x;
//			mPreviousY = y;
//			return true;
//		}
boolean startSign;
		public void initMethod() {
			vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
			sensorMgr = (SensorManager) getSystemService(SENSOR_SERVICE);
			sensor = sensorMgr.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
			SensorEventListener lsn = new SensorEventListener() {

				public void moveCube(float speed,float dx,float dy){
					while(speed>10){
						lesson06.xrot += (int)dx * speed;
						lesson06.yrot += (int)dy * speed;
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						requestRender();
						new Thread(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								 mMp.start();
							}
						}).start();
						
						speed = speed*0.6f;
					}
					startSign = false;
				}
				
				public void onSensorChanged(SensorEvent e) {
					x = e.values[SensorManager.DATA_X];
					y = e.values[SensorManager.DATA_Y];
					z = e.values[SensorManager.DATA_Z];
					
					float dx = x - mPreviousX;
					float dy = y - mPreviousY;

					long curTime = System.currentTimeMillis();
					// 每100毫秒检测一次
					if ((curTime - lastUpdate) > 100) {
						long diffTime = (curTime - lastUpdate);
						lastUpdate = curTime;

						float speed = Math.abs(x + y + z - last_x - last_y
								- last_z)
								/ diffTime * 10000;
						if(startSign){
							moveCube(speed,dx,dy);
						}
						
						if (speed > SHAKE_THRESHOLD) {
							Log.d("sensor", "shake detected w/ speed: " + speed);
							startSign = true;
							//vibrator.vibrate(3500);
//							lesson06.xrot += (int)dx * speed;
//							lesson06.yrot += (int)dy * speed;
////							lesson06.xrot += (int)dx * (int)TOUCH_SCALE_FACTOR;
////							lesson06.yrot += (int)dy * (int)TOUCH_SCALE_FACTOR;
//							requestRender();
						}
						last_x = x;
						last_y = y;
						last_z = z;

					}
					mPreviousX = x;
		    		mPreviousY = y;
		                

				}

				public void onAccuracyChanged(Sensor s, int accuracy) {
				}
			};
			// 注册listener，第三个参数是检测的精确度
			sensorMgr.registerListener(lsn, sensor,
					SensorManager.SENSOR_DELAY_GAME);
		}
	}

}