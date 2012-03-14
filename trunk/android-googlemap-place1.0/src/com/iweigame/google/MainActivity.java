package com.iweigame.google;

import org.json.JSONException;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity {

	/** Called when the activity is first created. */

	String resultString;

	ListView resultListView;

	private ResultListAdapter resultListAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		resultListView = (ListView) findViewById(R.id.resultList);
		adapterListener(resultListView);
	}

	public void toUniversity(View view) {
		try {

			resultString = MapsHttpUtil.getGetRoundPlace(Tools.getLocation(getApplicationContext()), "2000", "university");
			resultListAdapter = new ResultListAdapter(Tools.formatJsonTOBean(resultString), getApplicationContext());
			resultListView.setAdapter(resultListAdapter);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void toPark(View view) {
		try {

			resultString = MapsHttpUtil.getGetRoundPlace(Tools.getLocation(getApplicationContext()), "2000", "park");
			resultListAdapter = new ResultListAdapter(Tools.formatJsonTOBean(resultString), getApplicationContext());
			resultListView.setAdapter(resultListAdapter);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void toFood(View view) {
		try {

			resultString = MapsHttpUtil.getGetRoundPlace(Tools.getLocation(getApplicationContext()), "1000", "food");
			// resultListView = (ListView) findViewById(R.id.resultList);
			resultListAdapter = new ResultListAdapter(Tools.formatJsonTOBean(resultString), getApplicationContext());
			resultListView.setAdapter(resultListAdapter);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void toATM(View view) {
		try {

			resultString = MapsHttpUtil.getGetRoundPlace(Tools.getLocation(getApplicationContext()), "2000", "atm");
			// resultListView = (ListView) findViewById(R.id.resultList);
			resultListAdapter = new ResultListAdapter(Tools.formatJsonTOBean(resultString), getApplicationContext());
			resultListView.setAdapter(resultListAdapter);

		} catch (Exception e) {

			e.printStackTrace();
		}
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
}