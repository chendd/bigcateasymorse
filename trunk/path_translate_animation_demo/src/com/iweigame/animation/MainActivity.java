package com.iweigame.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	
	ImageView cameraImage , musicImage ,placeImage,sleepImage,thoughtImage,withImage;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        cameraImage = (ImageView)findViewById(R.id.picture_tiankong);
        
        musicImage = (ImageView)findViewById(R.id.music);
        
        placeImage = (ImageView)findViewById(R.id.place);
        
        sleepImage = (ImageView)findViewById(R.id.sleep);
        
        thoughtImage = (ImageView)findViewById(R.id.thought);
        
        withImage = (ImageView)findViewById(R.id.with);
    }
    
    public void myanimation(View view){
//    	 final float centerX = cameraImage.getWidth() / 2.0f; 
//    	    final float centerY = cameraImage.getHeight() / 2.0f; 
//    	    RotateAnimation rotateAnimation = new RotateAnimation(0, 180, centerX, 
//    	            centerY); 
//    	    rotateAnimation.setDuration(1000 * 20); 
//    	    rotateAnimation.setFillAfter(true); 
//    	    cameraImage.startAnimation(rotateAnimation); 
    	    
//    	    cameraImage.get
    	    
    	    TranslateAnimation translateAnimation = new TranslateAnimation(0,0, 0, 200);
    	    translateAnimation.setInterpolator(new OvershootInterpolator());
    	    translateAnimation.setDuration(200 * 1); 
    	    translateAnimation.setFillAfter(true); 
    	    cameraImage.startAnimation(translateAnimation); 
    	    
    	    
    	    TranslateAnimation translateAnimation1 = new TranslateAnimation(0,60, 0, 190);
    	    translateAnimation1.setInterpolator(new OvershootInterpolator());
    	    translateAnimation1.setDuration(200 * 1); 
    	    translateAnimation1.setStartOffset(30);
    	    translateAnimation1.setFillAfter(true); 
    	    musicImage.startAnimation(translateAnimation1); 
    	    
    	    
    	    TranslateAnimation translateAnimation2 = new TranslateAnimation(0,120, 0, 165);
    	    translateAnimation2.setInterpolator(new OvershootInterpolator());
    	    translateAnimation2.setDuration(200 * 1); 
    	    translateAnimation2.setStartOffset(60);
    	    translateAnimation2.setFillAfter(true); 
    	    placeImage.startAnimation(translateAnimation2);
    	    
    	    TranslateAnimation translateAnimation3 = new TranslateAnimation(0,170, 0, 120);
    	    translateAnimation3.setInterpolator(new OvershootInterpolator());
    	    translateAnimation3.setDuration(200 * 1); 
    	    translateAnimation3.setStartOffset(90);
    	    translateAnimation3.setFillAfter(true); 
    	    sleepImage.startAnimation(translateAnimation3);
    	    
    	    TranslateAnimation translateAnimation4 = new TranslateAnimation(0,190, 0, 60);
    	    translateAnimation4.setInterpolator(new OvershootInterpolator());
    	    translateAnimation4.setDuration(200 * 1); 
    	    translateAnimation4.setStartOffset(120);
    	    translateAnimation4.setFillAfter(true); 
    	    thoughtImage.startAnimation(translateAnimation4);
    	    
    	    TranslateAnimation translateAnimation5 = new TranslateAnimation(0,200, 0, 0);
    	    translateAnimation5.setInterpolator(new OvershootInterpolator());
    	    translateAnimation5.setDuration(200 * 1); 
    	    translateAnimation5.setStartOffset(140);
    	    translateAnimation5.setFillAfter(true); 
    	    withImage.startAnimation(translateAnimation5);
    }
}