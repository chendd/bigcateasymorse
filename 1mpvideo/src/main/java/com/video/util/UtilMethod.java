package com.video.util;

import java.util.Date;

public class UtilMethod {
	
	public static Integer getAge(Date birthday){
		Double age = Math.ceil((new Date().getTime()-birthday.getTime())/1000/31536000);
		return age.intValue();
	}
	
	public static int intFormat(String strValue){
		int intValue = 1;
		try{
			intValue = Integer.parseInt(strValue);
		}
		catch (Exception e) {
			
		}
		return  intValue;
	}
	
	public static long longFormat(String strValue){
		Long longValue = new Long(0);
		try{
			longValue = Long.parseLong(strValue);
		}
		catch (Exception e) {
			
		}
		return  longValue;
	}

}
