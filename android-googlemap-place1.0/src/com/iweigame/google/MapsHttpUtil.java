package com.iweigame.google;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;

import android.util.Log;

/**
 * 
 * @Description:
 * @author:dengyanhui
 * @see:
 * @since:
 * @copyright
 * @Date:2012-3-13
 */
public class MapsHttpUtil {

	private static final String KEY = "you key";

	public static String getGetRoundPlace(String location, String radius, String types) throws IOException {

		/* URL可以随意改 */
		//
		String url = "https://maps.googleapis.com/maps/api/place/search/json?location=" + location + "&radius=" + radius + "&types=" + types + "&language=zh-CN" + "&sensor=false&key=" + KEY;

		/* 建立HTTP Get对象 */
		HttpPost httpRequest = new HttpPost(url);
		HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);

		int res = httpResponse.getStatusLine().getStatusCode();
		if (res == 200) {
			/*
			 * 当返回码为200时，做处理 得到服务器端返回json数据，并做处理
			 */
			StringBuilder builder = new StringBuilder();
			BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			for (String s = bufferedReader2.readLine(); s != null; s = bufferedReader2.readLine()) {
				builder.append(s);
			}

			Log.i("tag", ">>>>response string is:>>" + builder.toString());
			return builder.toString();

		}
		return null;
	}

	public static String getGetdPlaceDetailMessage(String refranceString) throws IOException {

		/* URL可以随意改 */
		//
		String url = "https://maps.googleapis.com/maps/api/place/details/json?" 
			+ "reference=" + refranceString 
			+ "&language=zh-CN" 
			+ "&sensor=false&key=" + KEY;

		/* 建立HTTP Get对象 */
		HttpPost httpRequest = new HttpPost(url);
		HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);

		int res = httpResponse.getStatusLine().getStatusCode();
		if (res == 200) {
			/*
			 * 当返回码为200时，做处理 得到服务器端返回json数据，并做处理
			 */
			StringBuilder builder = new StringBuilder();
			BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			for (String s = bufferedReader2.readLine(); s != null; s = bufferedReader2.readLine()) {
				builder.append(s);
			}

			Log.i("tag", ">>>>place detail:>>" + builder.toString());
			return builder.toString();

		}
		return null;
	}

}
