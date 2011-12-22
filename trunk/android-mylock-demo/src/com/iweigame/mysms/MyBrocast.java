package com.iweigame.mysms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class MyBrocast extends BroadcastReceiver

{

	public static final String TAG = "ImiChatSMSReceiver";

	// android.provider.Telephony.Sms.Intents

	public static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";

	@Override
	public void onReceive(Context context, Intent intent)

	{

		Log.v("tag", " my brocast reciever sms ");
		
		   Bundle bundle = intent.getExtras();
	        Object messages[] = (Object[]) bundle.get("pdus");
	        SmsMessage smsMessage[] = new SmsMessage[messages.length];
	        for (int n = 0; n < messages.length; n++) {
	            smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
	            if(smsMessage[n].getMessageBody().contains("hahaha")){
	            	this.abortBroadcast();
	            }
	        }

	}

	

}