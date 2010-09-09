package com.showtime;  
  
import junit.framework.TestCase;  
  
public class IPtest extends TestCase {  
      
    public void testIp(){  
                //指定纯真数据库的文件名，所在文件夹  
        IPSeeker ip=new IPSeeker("QQWry.Dat","/home/ubuntu");  
         //测试IP 58.20.43.13  
        
System.out.println(ip.getIPLocation("209.85.255.80").getCountry()+":"+ip.getIPLocation("209.85.255.80").getArea());  
    }  
}  