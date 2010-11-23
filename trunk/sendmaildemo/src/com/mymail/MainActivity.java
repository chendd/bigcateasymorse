package com.mymail;

import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {
	
	private EditText mailto;
	
	private EditText mailContent;
	
	private Button send;
	
	
	
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      
        send = (Button)findViewById(R.id.send);
        mailto = (EditText)findViewById(R.id.text01);
        mailContent = (EditText)findViewById(R.id.text02);
        
        send.setOnClickListener(new Button.OnClickListener(){

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(android.content.Intent.ACTION_SEND);
				
				File file = new File(Environment
						.getExternalStorageDirectory().getPath()+File.separator+"camera.jpg");
				 
				intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{mailto.getText().toString()});
				intent.putExtra(android.content.Intent.EXTRA_TEXT, mailContent.getText().toString());
				 intent.setType("application/octet-stream");
				 intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file)); 
				startActivity(intent);
				
			}
        	
        });
    }
    
}