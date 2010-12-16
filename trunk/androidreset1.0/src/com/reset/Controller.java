package com.reset;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Controller extends Activity {
	static final int RESULT_ENABLE = 1;

	DevicePolicyManager mDPM;
	
	ComponentName mDeviceAdminSample;

	Button mEnableButton;
	Button mDisableButton;

	Button mWipeDataButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		mDPM = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);
		
		mDeviceAdminSample = new ComponentName(Controller.this,
				DeviceAdminSample.class);

		setContentView(R.layout.device_admin_sample);

		// Watch for button clicks.
		mEnableButton = (Button) findViewById(R.id.enable);
		mEnableButton.setOnClickListener(mEnableListener);

		mDisableButton = (Button) findViewById(R.id.disable);
		mDisableButton.setOnClickListener(mDisableListener);

		mWipeDataButton = (Button) findViewById(R.id.wipe_data);
		mWipeDataButton.setOnClickListener(mWipeDataListener);

	}

	void updateButtonStates() {
		boolean active = mDPM.isAdminActive(mDeviceAdminSample);
		if (active) {
			mEnableButton.setEnabled(false);
			mDisableButton.setEnabled(true);
			mWipeDataButton.setEnabled(true);
		} else {
			mEnableButton.setEnabled(true);
			mDisableButton.setEnabled(false);
			mWipeDataButton.setEnabled(false);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();

		updateButtonStates();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case RESULT_ENABLE:
			if (resultCode == Activity.RESULT_OK) {
				Log.i("DeviceAdminSample", "Admin enabled!");
			} else {
				Log.i("DeviceAdminSample", "Admin enable FAILED!");
			}
			return;
		}

		super.onActivityResult(requestCode, resultCode, data);
	}

	private OnClickListener mEnableListener = new OnClickListener() {
		public void onClick(View v) {
			// Launch the activity to have the user enable our admin.
			Intent intent = new Intent(
					DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
			intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,
					mDeviceAdminSample);
			intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
					"此操作是为了保证在您的手机丢失的时候，能够将手机的私人信息删除，以防他人盗用。");
			startActivityForResult(intent, RESULT_ENABLE);
		}
	};

	private OnClickListener mDisableListener = new OnClickListener() {
		public void onClick(View v) {
			mDPM.removeActiveAdmin(mDeviceAdminSample);
			updateButtonStates();
		}
	};

	private OnClickListener mWipeDataListener = new OnClickListener() {
		public void onClick(View v) {

			boolean active = mDPM.isAdminActive(mDeviceAdminSample);
			if (active) {
				// 如需真的恢复出厂，将下边这句注释去掉即可
				 mDPM.wipeData(0);
			}

		}
	};

}