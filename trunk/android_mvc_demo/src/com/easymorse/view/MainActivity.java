package com.easymorse.view;


import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.easymorse.data.MainContentProvider;
import com.easymorse.mvc.R;

public class MainActivity extends Activity {
	
	private static final String TAG = "demo";
	
	private EditText product_name;
	
	private EditText product_price;
	
	private Button addButton;
	
	private Button selectAllButton;
	
	private TextView textView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        product_name = (EditText)findViewById(R.id.product_name);
        
        product_price = (EditText)findViewById(R.id.product_price);
        
        addButton = (Button) findViewById(R.id.add_button);
        
        selectAllButton = (Button) findViewById(R.id.select_all_button);
        
        addButton.setOnClickListener(onClickListener);
        
        selectAllButton.setOnClickListener(onClickListener);
       
        textView = (TextView)findViewById(R.id.results);
       
        //update
        
        //delete
        
    }
    
    private OnClickListener onClickListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			if(v.getId() == R.id.add_button){
				Log.v(TAG, "add >>>>>");
				//操作数据库
		        //insert db
		        ContentValues values = new ContentValues();
		        values.put(MainContentProvider.PRODUCT_NAME, product_name.getText().toString());
		        values.put(MainContentProvider.PRODUCT_PRICE,product_price.getText().toString() );
		        getContentResolver().insert(MainContentProvider.CONTENT_PRODUCT_ADD, values);
			}
			
			if(v.getId() == R.id.select_all_button){
				Log.v(TAG, "select >>>>>");
				//操作数据库
				 //select 
		        Cursor cursor = getContentResolver().query(MainContentProvider.CONTENT_PRODUCT_QUERY, null, null,null, null);
		        StringBuilder stringBuilder = new StringBuilder();
		        if(cursor.moveToFirst()){
		        	while(cursor.moveToNext()){
		        		Log.v(TAG, cursor.getString(cursor.getColumnIndex(MainContentProvider.PRODUCT_NAME)));
		        		stringBuilder.append("名称： "+cursor.getString(cursor.getColumnIndex(MainContentProvider.PRODUCT_NAME))
		        				+"  价格: "+cursor.getString(cursor.getColumnIndex(MainContentProvider.PRODUCT_PRICE))+"\n");
		        		
		        	}
		        }
		        cursor.close();
		        textView.setText(stringBuilder);
			}
		}
	};
}