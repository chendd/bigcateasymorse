package com.easymorse;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.util.Log;
import android.view.View;

public class SecondActivity extends Activity {

	private static final int REQUEST_CODE = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
	}

	public void toFrist(View view) {
		Log.v("tag", "to frist activity");
		Intent intent = new Intent(Intent.ACTION_PICK,Contacts.CONTENT_URI);
		startActivityForResult(intent, REQUEST_CODE);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
			Cursor cursor = getContentResolver()
					.query(data.getData(),
							new String[] { android.provider.ContactsContract.Contacts.DISPLAY_NAME },
							null, null, null);
			if(cursor.moveToFirst()){
				String name = cursor.getString(cursor.getColumnIndex(Contacts.DISPLAY_NAME));
				Log.v("tag", "contact name is "+name);
			}
		}
	}
}
