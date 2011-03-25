package com.easymorse;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class MainActivity extends Activity {
    
	
	private PopupWindow popupWindow;
	private ViewGroup myView;
	/** Called when the activity is first created. */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //加载布局文件
        myView= (ViewGroup)getLayoutInflater().inflate(R.layout.popview, null);
        //后两个参数表示popupWindow的宽，高
        popupWindow = new PopupWindow(myView,200,200);
        
    }
	public void toSecond(View view){
		popupWindow.showAsDropDown(myView,50,200);
	}
}