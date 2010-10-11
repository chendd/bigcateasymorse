package com.send.camera;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.util.Log;



public class HttpUtil {


	private static final String BASIC_URL = "http://192.168.0.8:8080/mavenproto/";
	
	private static HttpClient httpClient = new DefaultHttpClient();

	/**
	 * 发送http请求
	 * 
	 * @return
	 */
	public static BufferedReader getResponse(String httpUrl) {

		try {
			return new BufferedReader(new InputStreamReader(httpClient
					.execute(new HttpGet(BASIC_URL+httpUrl)).getEntity()
					.getContent()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	  public static int sendFileToServer(String url,File file){
	    	HttpClient httpClient = new DefaultHttpClient();
	    	try {
	    
	    	HttpPost httpPost = new  HttpPost(BASIC_URL+url);
	    	
	    	httpPost.setEntity(new FileEntity(file, "application/octet-stream"));
	    	//Log.v("status","----   "+httpClient.execute(httpPost).getStatusLine().getStatusCode());
	    	return httpClient.execute(httpPost).getStatusLine().getStatusCode();
			} catch (Exception e) {
				throw new RuntimeException(e);
			} 
	  }
}
