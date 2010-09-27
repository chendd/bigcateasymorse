package com.iphone.test;

import org.json.JSONException;

import javapns.back.PushNotificationManager;
import javapns.back.SSLConnectionHelper;
import javapns.data.Device;
import javapns.data.PayLoad;

public class Main {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		 PayLoad simplePayLoad = new PayLoad();
		 
		// Get PushNotification Instance
         PushNotificationManager pushManager = PushNotificationManager.getInstance();
         // Link iPhone's UDID (64-char device token) to a stringName
         pushManager.addDevice("iPhone", "027dcce4 5ecd9a2a 0b33a886 4adee8df 49a59201 23706dc0 aeae1c82 8a5d79ce");
         
		 simplePayLoad.addAlert("My alert message测试");
		 simplePayLoad.addBadge(1);
		 simplePayLoad.addSound("default");
		 Device client = PushNotificationManager.getInstance().getDevice("iPhone");
		 PushNotificationManager.getInstance().initializeConnection("gateway.sandbox.push.apple.com", 2195, "/home/ubuntu/mypush.p12", "password", SSLConnectionHelper.KEYSTORE_TYPE_PKCS12);
		 PushNotificationManager.getInstance().sendNotification(client, simplePayLoad);
		 

	}

}
