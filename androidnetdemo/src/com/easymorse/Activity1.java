package com.easymorse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class Activity1 extends Activity {
    /** Called when the activity is first created. */
	
	private Button button ;
	
	private Button smsButton;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
      
        button = (Button)this.findViewById(R.id.sendbutton);
        button.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				recievdJson();
				
			}
		});
        smsButton  = (Button)this.findViewById(R.id.smsbutton);
        smsButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sendJson();
				
			}
		});
    }
    public void recievdJson(){
      
      HttpClient client = new DefaultHttpClient();
      
      StringBuilder builder = new StringBuilder();
      
      HttpGet get = new HttpGet("http://api.douban.com/book/subject/1220562?apikey=0f760660e3172b0e2e621322a945812a&alt=json");
      try {
          HttpResponse response = client.execute(get);
          BufferedReader reader = new BufferedReader(new InputStreamReader(
                  response.getEntity().getContent()));
          for (String s = reader.readLine(); s != null; s = reader.readLine()) {
              Log.v("response", s);
              builder.append(s);
          }
          
          JSONObject jsonObject = new JSONObject(builder.toString());
          Log.v("response", jsonObject.getString("db:tag"));
           Log.v("response", jsonObject.getString("category"));
           TextView title = (TextView)findViewById(R.id.title);
           JSONArray auJson = (JSONArray)jsonObject.get("author");
           title.setText("作者："+auJson.getJSONObject(0).getJSONObject("name").getString("$t"));
          
      } catch (Exception e) {
          e.printStackTrace();
      }
  }
    
    public void sendJson(){
    	HttpClient httpClient = new DefaultHttpClient();
    	try {
    	HttpPost get = new  HttpPost("http://192.168.0.57:8088/websms1.0/sendsms.jsp");
    	HttpParams httpParams = new BasicHttpParams();
    	List<NameValuePair> nameValuePair = new ArrayList<NameValuePair>();
    	nameValuePair.add(new BasicNameValuePair("phonenum","15210133976"));
    	nameValuePair.add(new BasicNameValuePair("msg","测试"));
    	
//    	httpParams.setParameter("phonenum","15210133976");
//    	httpParams.setParameter("msg","测试");
    	get.setEntity(new UrlEncodedFormEntity(nameValuePair));
    	get.setParams(httpParams);
    	
    	Log.v("myhttp","发送http");
    	
    	
			httpClient.execute(get);
		} catch (Exception e) {
			
		} 
    	
    }
}