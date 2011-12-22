package com.iweigame.mysms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsMessage;
import android.util.Log;

public class SMSReceiver extends BroadcastReceiver

{

	public static final String TAG = "ImiChatSMSReceiver";

	// android.provider.Telephony.Sms.Intents

	public static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";

	@Override
	public void onReceive(Context context, Intent intent)

	{

		Log.v("tag", "testtttttttttttt");
		//if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
			Intent service = new Intent();
			service.setClassName("com.iweigame.mysms", "com.iweigame.mysms.MyServices");
			context.startService(service);
	//	}
//		// 然后在service重新注册一个接收短信的广播接收者，优先级2147483647


	}

	public final SmsMessage[] getMessagesFromIntent(Intent intent)

	{

		Object[] messages = (Object[]) intent.getSerializableExtra("pdus");

		byte[][] pduObjs = new byte[messages.length][];

		for (int i = 0; i < messages.length; i++)

		{

			pduObjs[i] = (byte[]) messages[i];

		}

		byte[][] pdus = new byte[pduObjs.length][];

		int pduCount = pdus.length;

		SmsMessage[] msgs = new SmsMessage[pduCount];

		for (int i = 0; i < pduCount; i++)

		{

			pdus[i] = pduObjs[i];

			msgs[i] = SmsMessage.createFromPdu(pdus[i]);

		}

		return msgs;

	}

}