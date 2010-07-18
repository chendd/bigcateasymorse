package cn.vsp.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

public class MyMaps {

	private static HttpMethod getGetMethod() throws IOException {
		PostMethod post = new PostMethod("/maps/api/geocode/xml");
		GetMethod get = new GetMethod("/maps/api/geocode/json");
		
		NameValuePair simcard = new NameValuePair("latlng", "40.714224,-73.961452");
		NameValuePair simcard1 = new NameValuePair("sensor", "false");
		NameValuePair simcard2 = new NameValuePair("language", "zh-CN");
		get.setQueryString(new NameValuePair[] { simcard, simcard1,simcard2});
		
		//InputStream input = new FileInputStream(new File("/home/ubuntu/my.txt"));
		//"".getBytes("ISO8859-1")
		//InputStream input = new StringBufferInputStream("my test aaaaaaaaaa");
		//post.setRequestBody(input);
		return get;
	}
	private static HttpMethod getPostMethod() throws IOException {
		PostMethod post = new PostMethod("/maps/api/geocode/xml");
		
		//latlng=40.714224,-73.961452&sensor=false&&language=zh-TW
		NameValuePair simcard = new NameValuePair("latlng", "40.714224,-73.961452");
		NameValuePair simcard1 = new NameValuePair("sensor", "false");
		NameValuePair simcard2 = new NameValuePair("language", "zh-CN");
		
		post.setRequestBody(new NameValuePair[] { simcard, simcard1,simcard2});
		//InputStream input = new FileInputStream(new File("/home/ubuntu/my.txt"));
		//"".getBytes("ISO8859-1")
		//InputStream input = new StringBufferInputStream("my test aaaaaaaaaa");
		//post.setRequestBody(input);
		return post;
	}
	public static void main(String[] args) throws IOException {
		HttpClient client = new  HttpClient();
		client.getHostConfiguration().setHost("ditu.google.com", 80, "http");
		
		HttpMethod method = getGetMethod();// 使用GET方式提交数据
		client.executeMethod(method);
		// 打印服务器返回的状态
		System.out.println(method.getStatusLine());
		// 打印结果页面
		;
//		
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(),
					"UTF-8"));

			StringBuffer sb = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				sb.append(line);

			}
			rd.close();
			System.out.println("接受到的流是：" + sb);
		} catch (IOException e) {
			throw new RuntimeException("error", e);
		}
//		String response = method.getResponseBodyAsString();
//		// 打印返回的信息
//		System.out.println(response);
		method.releaseConnection();
	}
}
