package com.easymorse.scroll;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class CallActivity extends Activity {

	int i=0;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.textlayout);
		EditText deEditText = (EditText)findViewById(R.id.username);
		deEditText.setText(">>>"+(i++));
		Log.v("tag", ">>>>>>>>>>...................CallActivity>  onCreate>>>>");
	}
	
	@Override
	protected void onResume() {
		Log.v("tag", ">>>>>>>>>>...................CallActivity>  onResume>>>>");
		super.onResume();
	}
}
