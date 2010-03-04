package com.video.util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MsnHelper {
	
	
	public static List<String> getMsnFriendList(String msnCount,String password){
		List<String> friends = new ArrayList<String>();
		    System.getenv();
		    String message="你好，欢迎访问www.1mp.net.cn,更多精彩尽在其中!";
		    String command="java -cp /opt/jml.jar: net.sf.jml.example.SimpleMsn "+msnCount+" "+password+" "+message;
		    System.out.println(command);
		 try {
		  Process p=Runtime.getRuntime().exec(command);
		  BufferedInputStream in = new BufferedInputStream(p.getInputStream());
		  BufferedReader br = new BufferedReader(new InputStreamReader(in));
		  String content=br.readLine();
		  while(content!=null){
			  friends.add(content);
		  
		  content=br.readLine();
		  }
		 } catch (IOException e) {
		  e.printStackTrace();
		 }
		return friends;
	}

}
