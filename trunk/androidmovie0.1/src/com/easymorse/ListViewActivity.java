package com.easymorse;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity {

		private ListView listView;
		//private List<String> data = new ArrayList<String>();
		@Override
		public void onCreate(Bundle savedInstanceState){
			super.onCreate(savedInstanceState);
			setContentView(R.layout.listview);
			listView = (ListView)findViewById(R.id.listview1);
			listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));
			
		}
		
		
		
		private List<String> getData(){
			
			List<String> data = new ArrayList<String>();
			data.add("测试数据1");
			data.add("测试数据2");
			data.add("测试数据3");
			data.add("测试数据4");
			data.add("测试数据5");
			data.add("测试数据6");
			data.add("测试数据7");
			data.add("测试数据8");
			return data;
		}
	
}
