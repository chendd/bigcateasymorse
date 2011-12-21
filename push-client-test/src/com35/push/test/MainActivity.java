package com35.push.test;



import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Intent registrationIntent = new Intent();
    	registrationIntent.setClassName("com.c35.ptc.as", "com.c35.ptc.as.activity.RegisterIPPush");
		registrationIntent.putExtra("packagename", PendingIntent.getBroadcast(this, 0, new Intent(), 0)); // boilerplate
		registrationIntent.putExtra("subscriber", "dengyh@35.cn");
		registrationIntent.putExtra("subscriberpass", "password");

		/**
		 *  测试4种情况，
		 *  1 clientid == null reset=true 第一次注册，如果重复执行，直接search 数据库，返回clientid
		 *  2 clientid == null reset = false 返回错误，如果reset=false，clientid不能为空
		 *  3 clientid ！= null reset = true 修改clientid 
		 *  4 clientid ！= null  reset = false 正常登录
		 *  5 非法操作。随便输入clientid 判断非否符合
		 */

		startService(registrationIntent);
//		getLocationInfo(this);
    }
    
    public void unRegister(){
    	Intent unregIntent = new Intent();
    	unregIntent.setClassName("com35.ippush.client", "com35.ippush.intent.UnRegister");
    	unregIntent.putExtra("packagename", PendingIntent.getBroadcast(this, 0, new Intent(), 0));
    	unregIntent.putExtra("applicationid", "0123456780");
    	startService(unregIntent);
    }
    
    public static String[] getLocationInfo(Activity activity) { 
	    LocationManager locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE); 
	    Location location = locationManager 
	            .getLastKnownLocation(LocationManager.NETWORK_PROVIDER); 
	    String[] a = {"",""};
	    
	    if(location != null){
	    	 a[0] = location.getLatitude()+"";
	    	 a[1] = location.getLongitude()+"";
	    	 
	    }
	    Log.v("tag", ">>>>>>>>>>>>>>"+a[0]+">>>>>>>>>>"+a[1]);
	    return a;
	}
   
}