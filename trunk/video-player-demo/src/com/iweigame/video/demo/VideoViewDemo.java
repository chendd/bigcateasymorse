/*
 * Copyright (C) 2011 VOV IO (http://vov.io/)
 */

package com.iweigame.video.demo;

import java.net.URI;

import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.MediaPlayer.OnPreparedListener;
import io.vov.vitamio.MediaPlayer.OnSubtitleUpdateListener;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;
import android.app.Activity;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

public class VideoViewDemo extends Activity {

//	private String path = Environment.getExternalStorageDirectory() + "/Moon.mp4";
//	 private String path  = "http://www.pffair.com/1.divx";
	 private String path  = "http://192.168.1.56/1.mp4";
	private VideoView mVideoView;

	@Override
	public void onCreate(Bundle icicle) {
		
		Bundle bunde = this.getIntent().getExtras();  
    	String urls = bunde.getString("url");
		super.onCreate(icicle);
		
		setContentView(R.layout.videoview);
		
		
		
		mVideoView = (VideoView) findViewById(R.id.surface_view);
//		mVideoView.setVideoPath(path);
		mVideoView.setVideoURI(Uri.parse(path));
		mVideoView.setOnPreparedListener(new OnPreparedListener() {
			@Override
			public void onPrepared(MediaPlayer mp) {
				mVideoView.setSubPath("/sdcard/Video/238_mongoid.srt");
				mVideoView.setSubShown(true);
			}
		});
		mVideoView.setOnSubtitleUpdateListener(new OnSubtitleUpdateListener() {
			@Override
			public void onSubtitleUpdate(String arg0) {
				Log.i("VitamioDemo", arg0);
			}

			@Override
			public void onSubtitleUpdate(byte[] arg0, int arg1, int arg2) {
			}
		});
		mVideoView.setMediaController(new MediaController(this));
		mVideoView.requestFocus();
	}

	private int mLayout = VideoView.VIDEO_LAYOUT_ZOOM;

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		if (mVideoView != null)
			mVideoView.setVideoLayout(mLayout, 0);
		super.onConfigurationChanged(newConfig);
	}
}
