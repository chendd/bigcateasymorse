package com.easymorse;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FristActivity extends Activity {
    
	@SuppressWarnings("unused")
	private Button button;
	
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button) findViewById(R.id.mybutton);
        
    }
	public void toSecond(View view){
		Intent intent = new Intent(this,SecondActivity.class);
		startActivity(intent);
	}
}