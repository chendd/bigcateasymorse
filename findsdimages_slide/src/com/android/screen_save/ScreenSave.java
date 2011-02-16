package com.android.screen_save;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

public class ScreenSave extends Activity {
 
	private ImageView imageView; 
	private LayoutInflater layoutInflater; 
	private View view; 
	private EditText editText1,editText2; 
	private static final int MENU_ABOUT = Menu.FIRST; 
	private static final int MENU_EXIT = Menu.FIRST+1; 
	private Handler handler1 = new Handler(); 
	private Handler handler2 = new Handler(); 
	private Handler handler3 = new Handler(); 
	private Handler handler4 = new Handler(); 
	private int counter1,counter2; 
	private int counter3,counter4; 
	private int screenProtectPicId = 0; 
	private Date lastOpratorTime; 
	private long freeTime; 
	private float toScreenProtectSecond = (float)5; 
	private boolean isRunningSave; 
	private boolean fadein,fadeout; 
	private long intervalScreenSaver = 2000; 
	private long intervalKeypadSaver = 1000; 
	private long intervalFade = 100; 
	private int screenWidth,screenHeight; 
	private int changePicSecond = 6; 
	public  List<String> imageS =ListViewActivity.imageS;
//	private static int[] screenDrawable = new int[]
//	 {R.drawable.screen1,
//	  R.drawable.screen2,
//	  R.drawable.screen3,
//	  R.drawable.screen4,
//	  R.drawable.screen5
//	 }; 

	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
    	
        super.onCreate(savedInstanceState);
        
        setFullScreen();
        
        setContentView(R.layout.main);
        
        findViews();
        
        lastOpratorTime = new Date(System.currentTimeMillis()); 
        
        recoverOriginalLayout();
       
    }
    
    public void setFullScreen()
    {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
    	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); 
    }
    
    public void findViews()
    {
    	imageView = (ImageView)findViewById(R.id.image);
    }
    
    public void recoverOriginalLayout()
	{ 
		imageView.setVisibility(View.GONE); 
	} 
    
	private void hideOriginalLayout()
	{ 
		
		
	} 
    
    private Runnable monitorUsersOperateThread = new Runnable()
    {
    	public void run()
    	{ 
    		
    		counter1++; 
    		
    		Date nowDate = new Date(System.currentTimeMillis()); 
    		
    		freeTime = (long)nowDate.getTime() - (long)lastOpratorTime.getTime(); 
    		
    		float freeTimeSecond = (float)freeTime/1000; 
    		
    		if (freeTimeSecond>toScreenProtectSecond) 
    		{ 
    			Log.v(">>>>",">>freeTimeSecond>toScreenProtectSecond.............>>>>");
    			if (isRunningSave==false) 
    			{ 
    				
    				handler2.postDelayed(screenProtectThread, intervalScreenSaver); 
    		
    					if (counter1%(changePicSecond)==0) 
    					{ 
    						
    						fadeout = true; 

    						handler3.postDelayed(fadeoutThread, intervalFade); 
    		
    					}
    					else 
    					{ 
    		
    						if (fadeout) 
    						{ 
    							fadein = true; 
    							
    							handler4.postDelayed(fadeinThread, intervalFade); 
    		
    						}
    						else 
    						{ 
					    		fadein = false; 
					    		
					    		counter4 = 0; 
					    		
					    		handler4.removeCallbacks(fadeinThread); 
    						} 
    		
				    		counter3 = 0; 
				    		
				    		fadeout = false; 
    		
    					} 
    		
    					isRunningSave = true; 
    		
    			}
    			else 
    			{ 
    		
    				if (counter1%(changePicSecond)==0) 
    				{ 
    					fadeout = true; 
    		
    					handler3.postDelayed(fadeoutThread, intervalFade); 
    		
    				}
    				else 
    				{ 

    					if (fadeout) 
    					{ 
    		
    						fadein= true; 
    		
    						handler4.postDelayed(fadeinThread, intervalFade); 
    		
    					}else 
    					{ 

    						fadein = false; 
    		
    						counter4=0; 
    		
    						handler4.removeCallbacks(fadeinThread); 
    		
    					} 
    		
    					counter3=0; 
    		
    					fadeout=false; 
    		
    				} 
    		
    			} 
    		
    		}
    		else 
    		{ 
    
	    		isRunningSave = false; 
	    		
	    		recoverOriginalLayout(); 
    		
    		} 
    		
    		Log.i("HIPPO", "Counter1:"+Integer.toString(counter1+1)+"/"+Float.toString(freeTimeSecond)); 
  
    		handler1.postDelayed(monitorUsersOperateThread, intervalKeypadSaver); 
    		
    		}
    };
    
    private Runnable screenProtectThread = new Runnable()
    {

		@Override
		public void run() 
		{ 
			
			if (isRunningSave) 
			{ 	
				counter2++; 
			
				hideOriginalLayout(); 
			
				showScreenProtection(); 
			
				handler2.postDelayed(screenProtectThread, intervalScreenSaver); 
			
			}
			else 
			{ 
			
				handler2.removeCallbacks(screenProtectThread); 
			
			} 
			
		} 
			
    	
    };
    
	private Runnable fadeoutThread = new Runnable()
	{ 
		
		public void run() 
		{ 
		
			if (isRunningSave&&fadeout) 
			{ 
		
				counter3++; 
		
				imageView.setAlpha(255-counter3*28); 
		
				Log.i("HIPPO", ">>>>>fadeout>>>"+Integer.toString(counter3)); 
		
				handler3.postDelayed(fadeoutThread, intervalFade); 
		
			}
			else 
			{ 
		
				handler3.removeCallbacks(fadeoutThread); 
		
			} 
		
		} 
		
	}; 
	
	private Runnable fadeinThread = new Runnable()
	{ 
		
		public void run() 
		{ 
		
			if (isRunningSave&&fadein)
			{ 
		
				counter4++; 
		
				imageView.setAlpha(counter4*28); 
		
				handler4.postDelayed(fadeinThread, intervalFade); 
		
				Log.i("HIPPO", "fadein thread:"+Integer.toString(counter4)); 
		
			}
			else 
			{ 
		
				handler4.removeCallbacks(fadeinThread); 
		
			} 
		
		} 
		
	}; 	
	
	private void showScreenProtection()
	{ 
		
		if (screenProtectPicId>=imageS.size())
		{ 
		
			screenProtectPicId = 0; 
		
		} 
		
		DisplayMetrics displayMetrics = new DisplayMetrics(); 
		
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics); 
		
		screenWidth = displayMetrics.widthPixels; 
		
		screenHeight = displayMetrics.heightPixels; 
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = 2;
		
		Bitmap bitmap = BitmapFactory.decodeFile(imageS.get(screenProtectPicId),options);
		
		//Bitmap bitmap = BitmapFactory.decodeResource(getResources(),screenDrawable[screenProtectPicId] ); 

		float scaleWidth = (float)screenWidth/bitmap.getWidth(); 
		
		float scaleHeight = (float)screenHeight/bitmap.getHeight(); 
		
		Matrix matrix = new Matrix(); 
		
		matrix.postScale(scaleWidth, scaleHeight); 
		
		Bitmap resizeBitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true); 

		BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmap); 
		
		imageView.setImageDrawable(bitmapDrawable); 
		
		imageView.setVisibility(View.VISIBLE); 
	
		if (counter2%changePicSecond==0) 
		{ 
		
			screenProtectPicId++; 
		
		} 
		
	} 	
	
	private void onUserWakeup()
	{ 
		
		finish();
		
	}
	
	private void tipError()
	{ 
		
		new AlertDialog
		.Builder(this)
		.setTitle("test")
		.setMessage("测试曾许")
		.setPositiveButton("bbb", new DialogInterface.OnClickListener()
		{ 
		
			public void onClick(DialogInterface dialog, int which) 
			{ 
		
			} 
		
		})
		.show(); 
		
	}
	
	private void updateTimeOfUserLastAction()
	{ 
		
		Date nowDate = new Date(System.currentTimeMillis()); 
		
		freeTime = (long)nowDate.getTime()-lastOpratorTime.getTime(); 
		
		lastOpratorTime.setTime(nowDate.getTime()); 
		
	} 
	
	private void resetScreenProtectListener()
	{ 
		
		handler1.removeCallbacks(monitorUsersOperateThread); 
		
		handler2.removeCallbacks(screenProtectThread); 
	
		updateTimeOfUserLastAction(); 

		isRunningSave = false; 

		counter1=0; 
		
		counter2=0; 
		
		recoverOriginalLayout(); 
		
		handler1.postDelayed(monitorUsersOperateThread, intervalKeypadSaver); 
		
	} 
	
	@Override 
	public boolean onKeyDown(int keyCode, KeyEvent event) 
	{ 
	
		if (isRunningSave&&keyCode!=4) 
		{ 
		
			onUserWakeup(); 
		
		}
		else 
		{ 
			updateTimeOfUserLastAction(); 
			
		} 
		
		return super.onKeyDown(keyCode, event); 
	
	} 
	
	@Override 
	public boolean onTouchEvent(MotionEvent event) 
	{ 
	
		if (isRunningSave) 
		{ 
		
			onUserWakeup(); 
		
		}
		else 
		{ 
		
			updateTimeOfUserLastAction(); 
		
		} 
		
		return super.onTouchEvent(event); 
	
	} 
	
	@Override 
	protected void onResume() 
	{ 
		Log.v("Tag screen", "activity resume>>>>");
		handler1.postDelayed(monitorUsersOperateThread, intervalKeypadSaver); 
		
		super.onResume(); 
	
	} 
	
	@Override 
	
	protected void onPause() 
	{ 
	
		try { 
			Log.v("Tag screen", "activity pause>>>>");
				handler1.removeCallbacks(monitorUsersOperateThread); 
				
				handler2.removeCallbacks(screenProtectThread); 
				
				handler3.removeCallbacks(fadeoutThread); 
				
				handler4.removeCallbacks(fadeinThread); 
	
			} 
		catch (Exception e) 
		{ 
	
			e.printStackTrace(); 
	
		} 
	
		super.onPause(); 
	
	} 
	

}