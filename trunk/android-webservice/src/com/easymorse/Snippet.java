package com.easymorse;

import java.io.IOException;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.AndroidHttpTransport;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Log;

public class Snippet {
	
	private static final String METHOD_NAME = "Login";
	private static final String SOAP_ACTION = "http://tempuri.org/"+METHOD_NAME;
	private static final String NAMESPACE = "http://tempuri.org/";    
	private static final String URL = "http://192.168.0.111/testserver/AuthService.asmx";
	
	public void loginServer() throws Exception  {
		
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
	
	    PropertyInfo propertyInfo = new PropertyInfo();
	    propertyInfo.setName("username");
	    propertyInfo.setValue("zhangsan");            
	    request.addProperty(propertyInfo);
	    
	    propertyInfo = new PropertyInfo();
	    propertyInfo.setName("password");
	    propertyInfo.setValue("1234");            
	    request.addProperty(propertyInfo);
	
	    SoapSerializationEnvelope envelope = 
	        new SoapSerializationEnvelope(SoapEnvelope.VER11);
	    envelope.dotNet = true;
	    envelope.setOutputSoapObject(request);
	    
	    AndroidHttpTransport androidHttpTransport = new AndroidHttpTransport(URL);
	    androidHttpTransport.call(SOAP_ACTION, envelope);
	    
	    SoapPrimitive result = (SoapPrimitive)envelope.getResponse();
	    Log.v("tag", "the soap result is >>>>>"+result.toString());
	
	}
}

