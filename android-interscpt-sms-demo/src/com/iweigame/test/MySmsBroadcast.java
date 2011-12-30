package com.iweigame.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * 
 * @author dahui <a href="mailto:jiessiedyh@gmail.com">jiessiedyh@gmail.com</a> 
 *
 */
public class MySmsBroadcast extends BroadcastReceiver {
	// 接收短信广播的Action
	public static final String SMS_RECEIVED_ACTION = "android.provider.Telephony.SMS_RECEIVED";

	@Override
	public void onReceive(Context context, Intent intent) {
		// 获取短信内容
		Log.v("tag", "AS35SmsBroadcast reciever sms ");


			if (intent.getAction().equals(SMS_RECEIVED_ACTION)) {

				Bundle bundle = intent.getExtras();
				Object messages[] = (Object[]) bundle.get("pdus");

				SmsMessage smsMessage[] = new SmsMessage[messages.length];
				for (int n = 0; n < messages.length; n++) {
					// 使用pdu格式的短信数据生成短信对象
					smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
					
						// mail sms拦截
						this.abortBroadcast();
						Log.v("tag", "sms content is : " + smsMessage[n].getMessageBody());

					}
					

				}

			}
		


}
