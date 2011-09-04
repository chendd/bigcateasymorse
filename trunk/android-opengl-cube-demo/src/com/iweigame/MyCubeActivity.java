package com.iweigame;



import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;

public class MyCubeActivity extends Activity {

	 private GLSurfaceView mGLSurfaceView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		  mGLSurfaceView = new TouchSurfaceView(this);
	        setContentView(mGLSurfaceView);
	        mGLSurfaceView.requestFocus();
	        mGLSurfaceView.setFocusableInTouchMode(true);
	}
	
}

/**
 * Implement a simple rotation control.
 *
 */
class TouchSurfaceView extends GLSurfaceView {

	  	private MyCubeRenderer mRenderer;
	  
	  	private final float TOUCH_SCALE_FACTOR = 180.0f / 320;
	    private final float TRACKBALL_SCALE_FACTOR = 36.0f;
	    
	    private float mPreviousX;
	    private float mPreviousY;
	  
    public TouchSurfaceView(Context context) {
        super(context);
        mRenderer = new MyCubeRenderer();
        setRenderer(mRenderer);
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }

    @Override 
    public boolean onTrackballEvent(MotionEvent e) {
        mRenderer.mAngleX += e.getX() * TRACKBALL_SCALE_FACTOR;
        mRenderer.mAngleY += e.getY() * TRACKBALL_SCALE_FACTOR;
        requestRender();
        return true;
    }

    @Override public boolean onTouchEvent(MotionEvent e) {
        float x = e.getX();
        float y = e.getY();
        switch (e.getAction()) {
        case MotionEvent.ACTION_MOVE:
            float dx = x - mPreviousX;
            float dy = y - mPreviousY;
            mRenderer.mAngleX += dx * TOUCH_SCALE_FACTOR;
            mRenderer.mAngleY += dy * TOUCH_SCALE_FACTOR;
            requestRender();
        }
        mPreviousX = x;
        mPreviousY = y;
        return true;
    }
}
