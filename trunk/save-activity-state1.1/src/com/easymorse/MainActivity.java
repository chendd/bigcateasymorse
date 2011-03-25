package com.easymorse;

import java.io.File;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends Activity {

	private VideoView videoView;
	private static final String VIDEO_PATH = Environment
			.getExternalStorageDirectory()
			+ File.separator
			+ "mymovie"
			+ File.separator + "shenghuaweiji.mp4";

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Log.v("tag", "onCreate");
		
		if (videoView == null) {
			videoView = (VideoView) this.findViewById(R.id.myvideo);
			MediaController controller = new MediaController(this);
			videoView.setMediaController(controller);
			videoView.setVideoPath(VIDEO_PATH);
			videoView.requestFocus();
		}


		final MyDateObject myDateObject = (MyDateObject)getLastNonConfigurationInstance();
		if(myDateObject != null){
			videoView.seekTo(myDateObject.getMoviePosition());
		}
		videoView.start();

	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		Log.v("tag", "onDestroy");
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		Log.v("tag", "onPause");
		super.onPause();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		Log.v("tag", "onRestart");
		super.onRestart();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		Log.v("tag", "onResume");
		super.onResume();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		Log.v("tag", "onStart");
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		Log.v("tag", "onStop");
		super.onStop();
	}


	@Override
	public Object onRetainNonConfigurationInstance() {
		// TODO Auto-generated method stub
		Log.v("tag", "onRetainNonConfigurationInstance");
		final MyDateObject myDateObject = new MyDateObject();
		myDateObject.setMoviePosition(videoView.getCurrentPosition());
		return myDateObject;
	}
	
	 class MyDateObject{
		
		 private int moviePosition;

		public int getMoviePosition() {
			return moviePosition;
		}

		public void setMoviePosition(int moviePosition) {
			this.moviePosition = moviePosition;
		}
		 
		 
	}
	
}
