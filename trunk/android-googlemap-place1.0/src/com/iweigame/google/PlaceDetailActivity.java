package com.iweigame.google;

import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PlaceDetailActivity extends Activity {

	/** Called when the activity is first created. */

	String refranceString;

	TextView placeName, placeAddress, phoneNumber;

	String mapURL;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.place_detail);

		placeName = (TextView) findViewById(R.id.detailNameString);

		placeAddress = (TextView) findViewById(R.id.detailAddressString);
		phoneNumber = (TextView) findViewById(R.id.phoneString);

		refranceString = getIntent().getStringExtra(Tools.PLACE_REFRANCE);

		try {
			String localDetailString = MapsHttpUtil.getGetdPlaceDetailMessage(refranceString);

			JSONObject jsonObject = new JSONObject(localDetailString);
			JSONObject resultJsonObject = new JSONObject(jsonObject.getString("result"));
			placeName.setText("名称： " + resultJsonObject.getString("name"));
			placeAddress.setText("地址： " + resultJsonObject.getString("formatted_address"));
			phoneNumber.setText("电话： " + resultJsonObject.getString("formatted_phone_number"));
			mapURL = resultJsonObject.getString("url");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void toGoogleMap(View view) {
		Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(mapURL));
		startActivity(i);
	}
}