package com.easymorse;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.widget.LinearLayout;

public class MyLayout extends LinearLayout {

	public MyLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	protected void dispatchDraw(Canvas canvas) {

		super.dispatchDraw(canvas);
		Log.v("tag", ">>>>>>>>>>>>>>>>>>>>>>");
		Path mPath = new Path();
		mPath.moveTo(20, 150);
		mPath.lineTo(60, 200);
		mPath.lineTo(100, 350);
		mPath.lineTo(200, 60);
		mPath.lineTo(140, 160);
		mPath.close();

		Paint paint = new Paint();

		canvas.drawColor(Color.WHITE);

		paint.setAntiAlias(true);
		paint.setColor(Color.BLACK);
		paint.setStyle(Paint.Style.STROKE);

		// 画布上用指定画笔绘出路径
		canvas.drawPath(mPath, paint);

	}

}
