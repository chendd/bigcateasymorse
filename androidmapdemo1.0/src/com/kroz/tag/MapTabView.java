package com.kroz.tag;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MapTabView extends MapActivity {
	MapView mapView;
	MapController mapController;

	@Override
	protected void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.maptabview);
		this.mapView = (MapView) this.findViewById(R.id.mapview);
		this.mapView.setBuiltInZoomControls(true);// 可以多点触摸放大
		// mapView.setSatellite(true);//使用卫星图
		mapView.setSatellite(false);
		GeoPoint point = new GeoPoint(39000000, 116000000);
		this.mapController = mapView.getController();
		this.mapController.setZoom(18);
		this.mapController.animateTo(this.getCurrentGeoPoint());// 通过动画方式移动到指定坐标s
		Log.i("welcome", "created map activity!");
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	private void updateView() {
		Double lat = 31.23717 * 1E6;
		Double lng = 121.50811 * 1E6;

		GeoPoint point = new GeoPoint(39000000, 116000000);
		mapController.animateTo(point);
	}
	
	private GeoPoint getCurrentGeoPoint() { 
	    LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE); 
	    Location location = locationManager 
	            .getLastKnownLocation(LocationManager.NETWORK_PROVIDER); 
	    return new GeoPoint((int) (location.getLatitude() * 1e6), 
	            (int) (location.getLongitude() * 1e6)); 
	}
}