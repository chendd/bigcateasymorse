package com.mymail;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.widget.ListView;

public class MyAlertDialog extends ListView{

	public MyAlertDialog(Context context) {
		super(context);
		
		Builder builder = new AlertDialog.Builder(context);
		builder.setTitle("About me");
		builder.setMessage("Westyi");
		builder.setCancelable(true);
		builder.create().show();
	}

}
