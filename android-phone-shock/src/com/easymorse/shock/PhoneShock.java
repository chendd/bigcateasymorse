package com.easymorse.shock;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Vibrator;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneShock  {

	Context context;
	
	public static final int SHOCK_SECONDS = 1;
	
	public static void onCreate(Context context) {
		Vibrator vibrator = (Vibrator) context
				.getSystemService(Context.VIBRATOR_SERVICE);
		TelephonyManager telephonyManager = (TelephonyManager) context
				.getSystemService(Context.TELEPHONY_SERVICE);
		Log.v("tag", "oncreate shock service>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		new Thread(new ShockThreads(vibrator, telephonyManager)).start();

	}

}

class ShockThreads implements Runnable {
	// 振动器
	Vibrator mVibrator;
	// 电话服务
	TelephonyManager telManager;

	public ShockThreads(Vibrator mVibrator, TelephonyManager telManager) {
		this.mVibrator = mVibrator;
		this.telManager = telManager;
	}

	@Override
	public void run() {
		// 获取当前话机状态
		int callState = telManager.getCallState();
		// 记录拨号开始时间
		long threadStart = System.currentTimeMillis();
		Process process;
		InputStream inputstream;
		BufferedReader bufferedreader;
		try {
			process = Runtime.getRuntime().exec("logcat -v time -b radio");
			inputstream = process.getInputStream();
			InputStreamReader inputstreamreader = new InputStreamReader(
					inputstream);
			bufferedreader = new BufferedReader(inputstreamreader);
			String str = "";
			long dialingStart = 0;
			boolean enableVibrator = false;
			boolean isAlert = false;
			while ((str = bufferedreader.readLine()) != null) {

				// 如果话机状态从摘机变为空闲,销毁线程
				 if (telManager.getCallState() ==
				 TelephonyManager.CALL_STATE_IDLE) {
				 break;
				 }
				// 线程运行5分钟自动销毁
				if (System.currentTimeMillis() - threadStart > 300000) {
					break;
				}
				// 记录GSM状态DIALING
				if (str.contains("GET_CURRENT_CALLS")
						&& str.contains("DIALING")) {
					// 当DIALING开始并且已经经过ALERTING或者首次DIALING
					if (!isAlert || dialingStart == 0) {
						// 记录DIALING状态产生时间
						dialingStart = System.currentTimeMillis();
						isAlert = false;
					}
					continue;
				}
				// ALERTING  //&& str.contains("ALERTING")
				if (str.contains("GET_CURRENT_CALLS")
						 && !enableVibrator) {

					long temp = System.currentTimeMillis() - dialingStart;
					isAlert = true;
					// 这个是关键,当第一次DIALING状态的时间,与当前的ALERTING间隔时间在1.5秒以上并且在20秒以内的话
					// 那么认为下次的ACTIVE状态为通话接通.
					if (temp > 1500 && temp < 20000) {
						enableVibrator = true;
						Log.i("TestService", "间隔时间....." + temp + "....."
								+ Thread.currentThread().getName());
					}
					continue;
				}
				 Log.i("TestService",
				 ">>>>>>>>>>>>>>>>>>>>>>>>>>>>"+str+">>>>>>>>>"+enableVibrator);
//				 Log.i("TestService",
//				 ">>>>>>>>>>...................str.contains('GET_CURRENT_CALLS')"+str.contains("GET_CURRENT_CALLS")+">>>>>>>>>"+str.contains("ACTIVE"));
				if (str.contains("GET_CURRENT_CALLS") && str.contains("ACTIVE")
						&& enableVibrator) {
					mVibrator.vibrate(1000 * PhoneShock.SHOCK_SECONDS);
					enableVibrator = false;
					 break;
					//threadStart = System.currentTimeMillis();
				}
			}

		} catch (Exception e) {

		}
	}
}
