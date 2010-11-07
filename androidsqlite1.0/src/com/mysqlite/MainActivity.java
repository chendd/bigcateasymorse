package com.mysqlite;

import java.io.File;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private DBHelper dbHelper;
	private EditText editText;
	private TextView textView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		// 创建数据库和数据表
		dbHelper = new DBHelper(this);
		// 插入一条数据
		dbHelper.save("中国");
	//	dbHelper.close();
		textView = (TextView) findViewById(R.id.mytextview);
		editText = (EditText) findViewById(R.id.myname);
		Button button = (Button) findViewById(R.id.mybutton);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//查询数据
				
				textView.setText("从数据库中查询的结果是:  " +dbHelper.select(editText.getText().toString()));
				
			}
		});

	}
}