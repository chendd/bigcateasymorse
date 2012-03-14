package com.iweigame.google;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;


public class Tools {

	public static final String PLACE_REFRANCE = "refranceString";
	
	 public static String getLocation(Context context){
	    	LocationManager locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
			Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
			
			if(location == null){
				return "";
			}
			//经度
			double longitude = location.getLongitude();
			//维度
			double latitude = location.getLatitude();
			Log.i("tag", "location is " + longitude + "," + latitude);
			return latitude+","+longitude;
//			return "39.904214,116.407413";
		}
	 
	 
	 public static List<MyGoogleBean> formatJsonTOBean(String resultString) throws JSONException{
		 List<MyGoogleBean> myGoogleBeans = new ArrayList<MyGoogleBean>();
		 JSONObject clientResonseJsonObjetc = new JSONObject(resultString);
		 JSONArray jsonArray = clientResonseJsonObjetc.getJSONArray("results");

			for (int i = 0; i < jsonArray.length(); i++) {
				// 遍历JSONArray
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				// 消息内容
				String name = jsonObject.getString("name");
				String address = jsonObject.getString("vicinity");
				String reference = jsonObject.getString("reference");
				myGoogleBeans.add(new MyGoogleBean(name, address,reference));
			}
		 return myGoogleBeans;
	 }
}
