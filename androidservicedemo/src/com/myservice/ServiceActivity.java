package com.myservice;



import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ServiceActivity extends Activity {
	
	private Button button ;
	private EditText editText;
	Intent intent;
	Bundle bundle = new Bundle();
	private ICountService countService;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    	intent = this.getIntent();

	

		this.bindService(new Intent("com.myservice.CountService"),
				this.serviceConnection, BIND_AUTO_CREATE);
        
        button  = (Button)findViewById(R.id.send);
        editText = (EditText)findViewById(R.id.name);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				bundle.putString("name", editText.getText().toString());
				intent.putExtras(bundle);
				countService.getCount(intent);
				
				
			}
		});
        
    }
    private ServiceConnection serviceConnection = new ServiceConnection() {

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			countService = (ICountService) service;

		}

		@Override
		public void onServiceDisconnected(ComponentName name) {
			Log.v("CountService", "//////////////////////////////////");
			countService = null;
		}

	};
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		Log.v("CountService", "哈哈哈啊哈    ");
	}
	
	
}