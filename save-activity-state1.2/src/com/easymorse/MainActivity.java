package com.easymorse;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap.Config;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Log.v("tag","onCreate" );
    }
    
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		Log.v("tag","onStart" );
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.v("tag","onResume" );
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.v("tag","onPause" );
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.v("tag","onStop" );
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.v("tag","onDestroy" );
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Log.v("tag","onRestart" );
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		//Checks the orientation of the screen
		if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
			
			Toast.makeText(this, "landscapte",Toast.LENGTH_SHORT).show();
			
		}else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
			
			Toast.makeText(this,"portrait",Toast.LENGTH_SHORT).show();
			
		}
		//Checks whether a hardware keyboard is available
		if(newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO){
			
			Toast.makeText(this, "keyboard visible",Toast.LENGTH_SHORT).show();
			
		}else if(newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES){
			
			Toast.makeText(this,"keyboard hidden",Toast.LENGTH_SHORT).show();
			
		}
		
	}
}