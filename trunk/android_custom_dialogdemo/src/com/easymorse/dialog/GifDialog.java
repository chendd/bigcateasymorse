package com.easymorse.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class GifDialog extends Dialog {

	private Movie mMovie;

	private long mMovieStart;

	private Context contexts;

	private int reourceId;
	
	
	
	public int getReourceId() {
		return reourceId;
	}


	public void setReourceId(int reourceId) {
		this.reourceId = reourceId;
	}


	public GifDialog(Context context) {
		super(context);
		this.contexts = context;
		
		
	}

	
	public GifDialog(Context context, int theme) {
		super(context, theme);
		this.contexts = context;
		setCancelable(false);
	}


	public void setContentView(int resourceId, LayoutParams params) {
		// TODO Auto-generated method stub
		this.reourceId = resourceId;
	//	setReourceId(reourceId);		
		setContentView(new CustomGifView(contexts), params);
	}

	@Override
	public void setContentView(View view) {
		// TODO Auto-generated method stub
		super.setContentView(view);
	}

	class CustomGifView extends View {

		public CustomGifView(Context context) {
			super(context);
//			setBackgroundColor(R.color.dialogbackgournd);
			mMovie = Movie.decodeStream(getResources().openRawResource(
					reourceId));

		}
		
		
		public void onDraw(Canvas canvas) {

			long now = android.os.SystemClock.uptimeMillis();

			if (mMovieStart == 0) { // first time
				mMovieStart = now;
			}
			if (mMovie != null) {

				int dur = mMovie.duration();
				if (dur == 0) {
					dur = 1000;
				}
				int relTime = (int) ((now - mMovieStart) % dur);
				mMovie.setTime(relTime);
				mMovie.draw(canvas, Gravity.CENTER, Gravity.CENTER);
				invalidate();
			}
		}

	}

}
