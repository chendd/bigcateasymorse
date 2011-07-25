package com.tal.mms.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class MyActivity extends Activity {
	
	private Button mms_button_check_linkman = null;
	private EditText mms_edit_number = null;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mms_edit_number = (EditText)findViewById(R.id.mms_edit_number);
        mms_button_check_linkman = (Button)findViewById(R.id.mms_button_check_linkman);
        mms_button_check_linkman.setOnClickListener(mms_button_check_linkman_onClickListener);
    }
    
    
    OnClickListener mms_button_check_linkman_onClickListener = new OnClickListener(){
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			//直接调用系统联系人界面
			/*startActivityForResult
		      (
		          new Intent(Intent.ACTION_PICK, 
		              android.provider.ContactsContract.Contacts.CONTENT_URI),
		              PICK_CONTACT_SUBACTIVITY); 
		      }*/
			
			Intent intent = new Intent();
			intent.setClass(MyActivity.this, LinkManActivity.class);
			startActivityForResult(intent, 0);
		}};
		
		
		protected void onActivityResult(int requestCode, int resultCode, Intent data) {
			
			switch (resultCode) {
			case RESULT_OK:

				System.out.println("33333333333333333333");
				String tag = data.getStringExtra("tag");
				mms_edit_number.setText(tag);
				break;

			default:
				break;
			}
		};
		
	
}