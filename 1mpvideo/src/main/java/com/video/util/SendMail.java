package com.video.util;
import javax.mail.*; 
import javax.mail.internet.*; 

import java.text.SimpleDateFormat;
import java.util.*; 

public class SendMail 
{ 
	
public static void main(String[] args) {
	Long i = new Date().getTime();
	System.out.println(i);
	Date date = new Date(i);
	System.out.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date));
}
	
	public void sendMessage(List<String> address,String subject,String words){
		String host = "mail.1mp.com"; 
        String from =  "zhenghj@1mp.com"; 
        String to = "jarrywin@live.cn"; 
        String username = "zhenghj@1mp.com"; 
        String password = "abc123"; 

        // Get system properties 
        // Properties props = System.getProperties(); 很多例子中是这样的，其实下面这句更好，可以用在applet中 
        Properties props = new Properties(); 

        // Setup mail server 
        props.put("mail.smtp.host", host); 
        props.put("mail.smtp.auth", "true"); //这样才能通过验证 

        // Get session 
        Session session = Session.getDefaultInstance(props); 

        // watch the mail commands go by to the mail server 
      //  session.setDebug(true); 

        // Define message 
        MimeMessage message = new MimeMessage(session); 
        try {
			message.setFrom(new InternetAddress(from));
			
	   
	     Address addresses[] =new Address[address.size()] ;
	    
	       int i=0;
	     for(String strAddr:address){
	    	 Address addr = new InternetAddress(strAddr);
	    	 addresses[i]=addr;
	    	 i++;
	     }
	         
	        sun.misc.BASE64Encoder enc = new sun.misc.BASE64Encoder();

	        message.setSubject(subject);
	        BodyPart bp = new MimeBodyPart(); 
	        MimeMultipart mp = new MimeMultipart();
	        MimeBodyPart mbp = new MimeBodyPart(); 
	       


			bp.setContent(""+words,"text/html;charset=UTF-8"); 

			mp.addBodyPart(bp); 
			message.setContent(mp);
	       

	       // message.setText("=?GB2312?B?"+enc.encode(words.getBytes())+"?="); 
	        message.addRecipients(Message.RecipientType.TO, addresses);
	        // Send message 
	        message.saveChanges(); 
	        Transport transport = session.getTransport("smtp"); 
	        transport.connect(host, username, password); 
	        transport.sendMessage(message, message.getAllRecipients()); 
	        transport.close(); 
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		} 
        
      
	}

}



