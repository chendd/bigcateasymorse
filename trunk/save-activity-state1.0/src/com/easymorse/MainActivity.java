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

		if (savedInstanceState != null
				&& savedInstanceState.getInt("currentposition") != 0) {

			videoView.seekTo(savedInstanceState.getInt("currentposition"));
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
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Log.v("tag", "onRestoreInstanceState");
		super.onRestoreInstanceState(savedInstanceState);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		outState.putInt("currentposition", videoView.getCurrentPosition());
		Log.v("tag", "onSaveInstanceState");
		super.onSaveInstanceState(outState);
	}

}