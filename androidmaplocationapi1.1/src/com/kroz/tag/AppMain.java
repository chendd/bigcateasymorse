package com.kroz.tag;

import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class AppMain extends TabActivity  {
 TabHost mTabHost;
 FrameLayout mFrameLayout;

 /** Called when the activity is first created.*/
 @Override
 public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    mTabHost = getTabHost();
    TabSpec tabSpec = mTabHost.newTabSpec("tab_test1");
    tabSpec.setIndicator("Map");
    Context ctx = this.getApplicationContext();
    Intent i = new Intent(ctx, MapTabView.class);
    tabSpec.setContent(i);
    mTabHost.addTab(tabSpec);
    mTabHost.addTab(mTabHost.newTabSpec("tab_test2").setIndicator("Details").setContent(R.id.textview2));
    mTabHost.setCurrentTab(1);
 }
}