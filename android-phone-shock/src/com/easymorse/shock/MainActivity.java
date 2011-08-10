package com.easymorse.shock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MainActivity extends Activity {
	Intent intent ;
	
	TelephonyManager telephonyManager;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// intent = new Intent(MainActivity.this,ShockService.class);
		 
		telephonyManager = (TelephonyManager) this.getSystemService(TELEPHONY_SERVICE);
		telephonyManager.listen(new MyPhoneStateListener(),
				PhoneStateListener.LISTEN_CALL_STATE);
		
	}

	@Override
	protected void onDestroy() {
		//stopService(intent);
		super.onDestroy();
	}
	
	class MyPhoneStateListener extends PhoneStateListener {

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE:
				 Toast.makeText(MainActivity.this, "开始拨号",
						 Toast.LENGTH_LONG)
						 .show();
				

				break;
			case TelephonyManager.CALL_STATE_RINGING:

				 Toast.makeText(MainActivity.this,
				 "手机铃声响了，来电号码:" + incomingNumber, Toast.LENGTH_LONG)
				 .show();
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK:
				
				 Toast.makeText(MainActivity.this, "电话被挂起了",
				 Toast.LENGTH_LONG)
				 .show();
				
				//startService(intent);
				 PhoneShock.onCreate(MainActivity.this);

			default:
				break;
			}

			super.onCallStateChanged(state, incomingNumber);
		}
	}
	
}

