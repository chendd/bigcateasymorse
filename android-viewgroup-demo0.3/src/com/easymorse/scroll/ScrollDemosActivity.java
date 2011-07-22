package com.easymorse.scroll;

import android.app.ActivityGroup;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;

public class ScrollDemosActivity extends ActivityGroup {

	@SuppressWarnings("unused")
	private static final String TAG = "scroller";

	private MyViewGroup viewGroup;

	private int[] drawableResources = new int[] { R.drawable.a1, R.drawable.a2,
			R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6 };

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		viewGroup = new MyViewGroup(this);
		setContentView(viewGroup);

		for (int drawableId : drawableResources) {
			ImageView imageView = new ImageView(this);
			imageView.setImageDrawable(getResources().getDrawable(drawableId));

			//viewGroup.addView(imageView);
		}

//		View view = (View) getLayoutInflater().inflate(R.layout.textlayout,
//				null);
//		
		Log.v("tag", "add view >>>>>>>>>>>>>>>>>>>");

		View scene_other_view = (View) getLayoutInflater().inflate(
				R.layout.tabhostlayout, null);

		TabHost scene_other_tabHost = (TabHost) scene_other_view
				.findViewById(R.id.mytabhost);

		scene_other_tabHost.setup(getLocalActivityManager());

		Intent scene_other_calls = new Intent(this, CallActivity.class);
		scene_other_calls.putExtra("scene_type", "tag");
		scene_other_tabHost.addTab(scene_other_tabHost
				.newTabSpec("tab_dia_scene5")
				.setIndicator("通话记录",
						getResources().getDrawable(R.drawable.icon))
				.setContent(scene_other_calls));
		viewGroup.addView(scene_other_view);

		
		scene_other_view = (View) getLayoutInflater().inflate(
				R.layout.tabhostlayout, null);
		
		scene_other_tabHost = (TabHost) scene_other_view
				.findViewById(R.id.mytabhost);

		scene_other_tabHost.setup(getLocalActivityManager());

		scene_other_calls = new Intent(this, CallActivity.class);
		scene_other_calls.putExtra("scene_type", "tag");
		scene_other_tabHost.addTab(scene_other_tabHost
				.newTabSpec("tab_dia_scene4")
				.setIndicator("通话记录",
						getResources().getDrawable(R.drawable.icon))
				.setContent(scene_other_calls));
		viewGroup.addView(scene_other_view);

		scene_other_view = (View) getLayoutInflater().inflate(
				R.layout.tabhostlayout, null);
		scene_other_tabHost = (TabHost) scene_other_view
				.findViewById(R.id.mytabhost);

		scene_other_tabHost.setup(getLocalActivityManager());

		scene_other_calls = new Intent(this, CallActivity.class);
		scene_other_calls.putExtra("scene_type", "tag");
		scene_other_tabHost.addTab(scene_other_tabHost
				.newTabSpec("tab_dia_scene3")
				.setIndicator("通话记录",
						getResources().getDrawable(R.drawable.icon))
				.setContent(scene_other_calls));
		viewGroup.addView(scene_other_view);

	}
}