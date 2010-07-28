package cn.vsp.mytest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;



public class HttpTest {
	
	
	private static HttpMethod getGetMethod() throws IOException {
	//	PostMethod post = new PostMethod("/maps/api/geocode/xml");
		GetMethod get = new GetMethod("/welcomedemos/browsenews.json");

		NameValuePair simcard = new NameValuePair("exponews",
				"true");
//		NameValuePair simcard1 = new NameValuePair("sensor", "false");
//		NameValuePair simcard2 = new NameValuePair("language", "zh-CN");
		get.setQueryString(new NameValuePair[] { simcard});

		// InputStream input = new FileInputStream(new
		// File("/home/ubuntu/my.txt"));
		// "".getBytes("ISO8859-1")
		// InputStream input = new
		// StringBufferInputStream("my test aaaaaaaaaa");
		// post.setRequestBody(input);
		return get;
	}

	private static HttpMethod getPostMethod() throws IOException {
		PostMethod post = new PostMethod("/maps/api/geocode/xml");

		// latlng=40.714224,-73.961452&sensor=false&&language=zh-TW
		NameValuePair simcard = new NameValuePair("latlng",
				"40.714224,-73.961452");
		NameValuePair simcard1 = new NameValuePair("sensor", "false");
		NameValuePair simcard2 = new NameValuePair("language", "zh-CN");

		post
				.setRequestBody(new NameValuePair[] { simcard, simcard1,
						simcard2 });
		// InputStream input = new FileInputStream(new
		// File("/home/ubuntu/my.txt"));
		// "".getBytes("ISO8859-1")
		// InputStream input = new
		// StringBufferInputStream("my test aaaaaaaaaa");
		// post.setRequestBody(input);
		return post;
	}

	public static void main(String[] args) throws IOException {
		HttpClient client = new HttpClient();
		client.getHostConfiguration().setHost("mp.myvsp.cn", 80, "http");

	
		HttpMethod method = getGetMethod();
		client.executeMethod(method);
		String statusLine = method.getStatusLine().toString();
		method.releaseConnection();
		if(statusLine.indexOf("200")==-1){
			try {
				new Thread().sleep(10*1000);
				
				HttpMethod method1 = getGetMethod();
				client.executeMethod(method1);
				String statusLine1 = method1.getStatusLine().toString();
				method1.releaseConnection();
				if(statusLine1.indexOf("200")==-1){
					HttpClient client2 = new HttpClient();
					client2.getHostConfiguration().setHost("192.168.0.56", 8088, "http");

				
					HttpMethod method2 = getGetMethod56();
					client2.executeMethod(method2);
					String statusLine2= method2.getStatusLine().toString();
					method2.releaseConnection();
					
					/**
					 * 	
					 *  
					 * */
					HttpMethod method3 = getGetMethod56jordy();
					client2.executeMethod(method3);
					String statusLine3= method3.getStatusLine().toString();
					method3.releaseConnection();
					
					
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	private static HttpMethod getGetMethod56() throws IOException {
		//	PostMethod post = new PostMethod("/maps/api/geocode/xml");
		//http://192.168.0.56:8088/websms1.0/sendsms.jsp?phonenum=15210133976&msg=asdfasd&smsPort=
			GetMethod get = new GetMethod("/websms1.0/sendsms.jsp");

			NameValuePair simcard = new NameValuePair("phonenum",
					"15210133976");
			NameValuePair simcard1 = new NameValuePair("msg", "mp服务器上的welcome 错误");
//			NameValuePair simcard2 = new NameValuePair("language", "zh-CN");
			get.setQueryString(new NameValuePair[] { simcard,simcard1});

			// InputStream input = new FileInputStream(new
			// File("/home/ubuntu/my.txt"));
			// "".getBytes("ISO8859-1")
			// InputStream input = new
			// StringBufferInputStream("my test aaaaaaaaaa");
			// post.setRequestBody(input);
			return get;
		}
	private static HttpMethod getGetMethod56jordy() throws IOException {
		//	PostMethod post = new PostMethod("/maps/api/geocode/xml");
		//http://192.168.0.56:8088/websms1.0/sendsms.jsp?phonenum=15210133976&msg=asdfasd&smsPort=
			GetMethod get = new GetMethod("/websms1.0/sendsms.jsp");

			NameValuePair simcard = new NameValuePair("phonenum",
					"15210795342");
			NameValuePair simcard1 = new NameValuePair("msg", "mp服务器上的welcome 错误");
//			NameValuePair simcard2 = new NameValuePair("language", "zh-CN");
			get.setQueryString(new NameValuePair[] { simcard,simcard1});

			// InputStream input = new FileInputStream(new
			// File("/home/ubuntu/my.txt"));
			// "".getBytes("ISO8859-1")
			// InputStream input = new
			// StringBufferInputStream("my test aaaaaaaaaa");
			// post.setRequestBody(input);
			return get;
		}
}
