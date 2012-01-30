package com.iweigame.widget;

import java.lang.reflect.Method;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.app.admin.IDevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
/**
 * 
* @ClassName: LockWidgetProvider
* @Description: 描述 
* @author:jiessiedyh@gmail.com

*
 */
public class MainActivity extends Activity {  
    IDevicePolicyManager mService;  
    @Override  
    public void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.main);  
    }  
    //锁屏   
    public void lock(View view){  
        try {  
            //通过反射获取到sdk隐藏的服务   
            Method method = Class.forName("android.os.ServiceManager")  
                    .getMethod("getService", String.class);  
            IBinder binder = (IBinder) method.invoke(null,//激活服务  
                    new Object[] { Context.DEVICE_POLICY_SERVICE });  
             mService = IDevicePolicyManager.Stub.asInterface(binder);  
               
             //定义组件的名字   
             ComponentName mAdminName = new ComponentName(this, MyAdmin.class);  
              
             //注册权限  
             if (mService != null) {  
                    //判断自定义的广播接受者 是不是被注册成 deviceadmin的权限   
                    if (!mService.isAdminActive(mAdminName)) {  
                                Intent intent = new Intent(  
                                DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);  
                                intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,  
                                        mAdminName);
                                intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
                                "此权限用来实现设备的软件锁屏！！");
                                startActivity(intent);  
                            }  
                    //调用服务实现锁屏   
                    mService.lockNow();  
                    //设置解锁密码  
                   // mService.resetPassword("123", 0);  
             }  
        } catch (Exception e) {  
            e.printStackTrace();  
        }   
        finish();
    }  
}  