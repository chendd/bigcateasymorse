package com35.push.test;



import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    	Intent registrationIntent = new Intent();
    	//com35.ippush.client.activity.MessageService
    	registrationIntent.setClassName("com35.ippush.client", "com35.ippush.client.activity.MessageService");
		registrationIntent.putExtra("packagename", PendingIntent.getBroadcast(this, 0, new Intent(), 0)); // boilerplate
		registrationIntent.putExtra("applicationid", "0123456780");
		registrationIntent.putExtra("clientid", "");
		registrationIntent.putExtra("reset", true);
		//client id is b8f15f76edcb47fa99d172cf91e96725

		/**
		 *  测试4种情况，
		 *  1 clientid == null reset=true 第一次注册，如果重复执行，直接search 数据库，返回clientid
		 *  2 clientid == null reset = false 返回错误，如果reset=false，clientid不能为空
		 *  3 clientid ！= null reset = true 修改clientid 
		 *  4 clientid ！= null  reset = false 正常登录
		 *  5 非法操作。随便输入clientid 判断非否符合
		 */

		startService(registrationIntent);
    }
}