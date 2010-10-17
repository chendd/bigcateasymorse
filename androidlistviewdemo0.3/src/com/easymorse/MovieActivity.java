package com.easymorse;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ListView;
import android.widget.TabHost;

public class MovieActivity extends TabActivity {
	
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   setContentView(R.layout.main);
        
       // Intent intent = new Intent(this,ListViewActivity.class);
        Intent intent1 = new Intent(this,MyListView.class);
        TabHost tabHost = getTabHost();
        LayoutInflater.from(this).inflate(R.layout.main, tabHost.getTabContentView(), true);
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("首页",getResources().getDrawable(R.drawable.home_b))
                .setContent(intent1));
        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("直播",getResources().getDrawable(R.drawable.channel_b))
                .setContent(intent1));
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("排行",getResources().getDrawable(R.drawable.top100_b))
                .setContent(intent1));
        tabHost.addTab(tabHost.newTabSpec("tab4")
                .setIndicator("搜索",getResources().getDrawable(R.drawable.search_b))
                .setContent(intent1));
        tabHost.addTab(tabHost.newTabSpec("tab5")
                .setIndicator("更多",getResources().getDrawable(R.drawable.album))
                .setContent(intent1));

    }
}