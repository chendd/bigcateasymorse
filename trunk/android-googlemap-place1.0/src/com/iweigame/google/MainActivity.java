package com.iweigame.google;

import java.io.IOException;

import org.json.JSONException;


import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	/** Called when the activity is first created. */

	String resultString;

	ListView resultListView;

	private ResultListAdapter resultListAdapter;

	ProgressDialog progressDialog;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		progressDialog = new ProgressDialog(this);
		progressDialog.setMessage("Loading...");
		resultListView = (ListView) findViewById(R.id.resultList);
		adapterListener(resultListView);
	}

	public void toUniversity(View view) {
			progressDialog.show();
			new GetMessageFromServer().execute("2000,university");
	
	}

	public void toPark(View view) {
			progressDialog.show();
			new GetMessageFromServer().execute("2000,park");
		
	}

	public void toFood(View view) {
		progressDialog.show();
		new GetMessageFromServer().execute("2000,food");
		
	}

	public void toATM(View view) {
		progressDialog.show();
		new GetMessageFromServer().execute("2000,atm");
	}

	public void adapterListener(ListView listView) {
		
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				try {
					String refranceString = Tools.formatJsonTOBean(resultString).get(position).getReference();
					
					Intent intent = new Intent(MainActivity.this,PlaceDetailActivity.class);
					intent.putExtra(Tools.PLACE_REFRANCE, refranceString);
					startActivity(intent);
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}
	
	
	private class GetMessageFromServer extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... parameters) {
			try {
				resultString = MapsHttpUtil.getGetRoundPlace(Tools.getLocation(getApplicationContext()), parameters[0].split(",")[0],parameters[0].split(",")[1] );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return resultString;
		}

		@Override
		protected void onPostExecute(String result) {
			// 作UI线程的修改。
			try {
				resultListAdapter = new ResultListAdapter(Tools.formatJsonTOBean(resultString), getApplicationContext());
				resultListView.setAdapter(resultListAdapter);
				progressDialog.dismiss();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			super.onPostExecute(result);
		}

	}
}