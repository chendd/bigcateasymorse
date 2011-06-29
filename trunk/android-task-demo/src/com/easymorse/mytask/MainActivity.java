package com.easymorse.mytask;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private ProgressDialog progressDialog ;
	
	
	private Handler myHandler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			progressDialog.dismiss();
			super.handleMessage(msg);
		}
		
	};
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        new DownloadFilesTask().execute(null);
//        new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				//这里作比较耗时的工作，暂时用线程休眠2秒作替代。
//				try {
//					Thread.sleep(4*1000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				myHandler.sendMessage(myHandler.obtainMessage());
//			}
//		}).start();
    }
    
    
	private class DownloadFilesTask extends AsyncTask<Void, Void, Void> {

		@Override
		protected Void doInBackground(Void... params) {
			//耗时操作，
			try {
				Thread.sleep(4*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			//作UI线程的修改。
			progressDialog.dismiss();
			super.onPostExecute(result);
		}
		
		
		
	}
}