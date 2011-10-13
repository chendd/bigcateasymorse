package org.androidpn.server.console.vo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

public class AutoSendMessage {

//	private static final String IP_ADDRESS=  "192.168.1.133";
	private static final String IP_ADDRESS=  "218.5.81.140";
	
	private static final int PORT = 7070;
	
	
	
	/**
	 * 
	* @Title: getPostMethod
	* @Description:  模拟post请求，发送通知到客户端  
	* @author dengyanhui
	* @date 2011-9-2    
	* @return HttpMethod    
	* @throws
	 */
	public static HttpMethod getPostMethod(String userName,String sign) throws IOException {
		PostMethod post = new PostMethod("/notification.do?action=send");
		
		
		NameValuePair simcard = new NameValuePair("broadcast", "N");
		NameValuePair simcard0 = new NameValuePair("username", userName);
		NameValuePair simcard1 = new NameValuePair("title", sign);
		NameValuePair simcard2 = new NameValuePair("message", "test message ....");
		NameValuePair simcard3 = new NameValuePair("uri", "http://www.baidu.com");
	
		
		post.setRequestBody(new NameValuePair[] { simcard,simcard0 ,simcard1,simcard2,simcard3});

		return post;
	}
	
	public static void sendMessage(String userName,String sign) throws IOException{
		HttpClient client = new  HttpClient();
		client.getHostConfiguration().setHost(IP_ADDRESS, PORT, "http");
		
		HttpMethod method = getPostMethod(userName,sign);
		client.executeMethod(method);
		// 打印服务器返回的状态
		System.out.println(method.getStatusLine());
		// 打印结果页面
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

		method.releaseConnection();
	}
	public static void main(String[] args) throws IOException {
		
	}
}