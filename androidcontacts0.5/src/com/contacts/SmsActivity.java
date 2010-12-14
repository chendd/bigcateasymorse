package com.contacts;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class SmsActivity  extends Activity{
	String[] names;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Uri allMessage = Uri.parse("content://sms/");
		ContentResolver cr = getContentResolver();
		Cursor c = cr.query(allMessage, null, null, null, null);
		
		while  (c.moveToNext()) {
			 names= c.getColumnNames();
			
		  
		  
		   Log.v(">>>", ">>>>>>>>>"
				   +c.getString(0)+">>>>"
				   +c.getString(1)+">>>>"
				   +c.getString(2)+">>>>"
				   +c.getString(3)+">>>>"
				   +c.getString(4)+">>>>"
				   +c.getString(5)+">>>>"
				   +c.getString(6)+">>>>"
				   +c.getString(7)+">>>>"
				   +c.getString(8)+">>>>"
				   +c.getString(9)+">>>>"
				   +c.getString(10)+">>>>"
				   +c.getString(11)+">>>>"
				   +c.getString(12)+">>>>"
				   +c.getString(13)+">>>>"
				   +c.getString(14)+">>>>"
				   +c.getString(15)+">>>>"
				   +c.getColumnCount());
		}
		for(String s:names){
			Log.v(">>>", ">>>>>>>>>>>>>"+s);
		}
	}
	

}
