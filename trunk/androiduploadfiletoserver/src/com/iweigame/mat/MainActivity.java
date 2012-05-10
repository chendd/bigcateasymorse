package com.iweigame.mat;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.StringPart;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

public class MainActivity extends Activity {

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		WindowManager manage = getWindowManager();
		Display display = manage.getDefaultDisplay();
		Log.v("tag", ">>>>" + display.getWidth());
		executorService.submit(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				sendFileToServer("", new File(Environment.getExternalStorageDirectory().toString() + File.separator + "aa.zip"));
			}
		});
		executorService.submit(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				sendFileToServer("", new File(Environment.getExternalStorageDirectory().toString() + File.separator + "aa.zip"));
			}
		});
		executorService.shutdown();
	}

	public static int sendFileToServer(String url, File file) {

		int status = 0;
		try {
			PostMethod filePost = new PostMethod(url);

			Part[] parts = { new FilePart("dataFile", file, null, "UTF-8"),
					new StringPart("uuid", "12123123213", "UTF-8"),
					new StringPart("dataBizType", "errorlog", "UTF-8"), 
					new StringPart("authCode", "973C8C45BB7F3DFB26CC87C7A993622B", "UTF-8") };
			MultipartRequestEntity multipartRequestEntity = new MultipartRequestEntity(parts, filePost.getParams());

			filePost.setRequestEntity(multipartRequestEntity);
			HttpClient clients = new HttpClient();

			status = clients.executeMethod(filePost);

			BufferedReader rd = new BufferedReader(new InputStreamReader(filePost.getResponseBodyAsStream(), "UTF-8"));
			StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
			}
			rd.close();
			// 这里需要解析json格式的字符串
			Log.i("cat", stringBuffer.toString());
		} catch (Exception e) {
			return 500;
		}
		return status;
	}
}