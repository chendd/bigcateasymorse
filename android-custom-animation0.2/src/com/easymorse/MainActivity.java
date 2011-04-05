package com.easymorse;




import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static final String TAG= "transtion demo";
	
	private ImageView imageView1;
	
	private ImageView imageView2;
	
	
	private View mContainer;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mContainer = (View)findViewById(R.id.mContener);
        
        imageView1 = (ImageView)findViewById(R.id.picture_tiankong);
        
        imageView2 = (ImageView)findViewById(R.id.picture_qian);
        
    }
    private void applyRotation(int position, float start, float end) {
       
        final float centerX = mContainer.getWidth() / 2.0f;
        final float centerY = mContainer.getHeight() / 2.0f;

        final Rotate3dAnimation rotation =
                new Rotate3dAnimation(start, end, centerX, centerY);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
   
        rotation.setAnimationListener(new DisplayNextView(position));

        mContainer.startAnimation(rotation);
        Log.v("tag", ">>>>>>>>>>start animation");
    }

    public void showContent(View view){
    	   applyRotation(1, 0, 90);
    }
    
    public void showPicture(View view){
    	 applyRotation(-1, 0, 90);
    }
    
    
    
    private final class DisplayNextView implements Animation.AnimationListener {
        private final int mPosition;

        private DisplayNextView(int position) {
            mPosition = position;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
        	Log.v("tag", ">>>>>>>>>>start animation listener");
            mContainer.post(new SwapViews(mPosition));
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /**
     * This class is responsible for swapping the views and start the second
     * half of the animation.
     */
    private final class SwapViews implements Runnable {
        private final int mPosition;

        public SwapViews(int position) {
            mPosition = position;
        }

        public void run() {
            final float centerX = mContainer.getWidth() / 2.0f;
            final float centerY = mContainer.getHeight() / 2.0f;
            Rotate3dAnimation rotation;
            
            if (mPosition > -1) {
            	 imageView2.setVisibility(View.VISIBLE);
                 imageView1.setVisibility(View.GONE);

            } else {
            	 imageView1.setVisibility(View.VISIBLE);
                 imageView2.setVisibility(View.GONE);
                
            }
            rotation = new Rotate3dAnimation(270, 360, centerX, centerY);
            rotation.setDuration(500);
            rotation.setFillAfter(true);
            mContainer.startAnimation(rotation);
        }
    }

}