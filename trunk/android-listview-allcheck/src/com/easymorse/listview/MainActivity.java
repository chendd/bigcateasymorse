package com.easymorse.listview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ListView listView;

	HashMap<String, Integer> alphaIndexer;

	private String[] sections = new String[0];

	ImageView imageView;

	GestureDetector mygesture;

	MyAdapter myAdapter;

	TextView overlay;

	boolean sign;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		listView = (ListView) findViewById(R.id.mylistview);
		myAdapter = new MyAdapter(this);
		listView.setAdapter(myAdapter);

	}

	public void checkBoxMethod(View view){
		if(sign){
			sign = false;
			
		}else{
			sign = true;
		}
		myAdapter.notifyDataSetChanged();
	}
	
	public List<String> getData() {
		List<String> data = new ArrayList<String>();
		int i = 0;

		
		data.add("aa试数据" + (i++));
		data.add("aaa试数据" + (i++));
		data.add("aa试数据" + (i++));
		data.add("aa试数据" + (i++));
		data.add("a试数据" + (i++));
		data.add("a试数据" + (i++));
		data.add("aa试数据" + (i++));
		data.add("@section" + (i++));
		data.add("bb试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("bb试数据" + (i++));
		data.add("bb试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("@section" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("@section" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("@section" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("@section" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		return data;
	}

	class MyAdapter extends BaseAdapter {
		private Activity mContext;
		private LayoutInflater mInflater;
		private HashMap<String, Integer> alphaIndexer;
		private String[] sections = new String[0];

		private List<String> objects;

		public MyAdapter(Activity mContext) {
			super();
			this.mContext = mContext;
		}

		@Override
		public int getCount() {

			return getData().size();
		}

		@Override
		public Object getItem(int arg0) {
			
			return getData().get(arg0);
		}

		@Override
		public long getItemId(int arg0) {
			
			return 0;
		}

		@Override
		public View getView(int position, View view, ViewGroup arg2) {
			
			if(view == null){
				view = mContext.getLayoutInflater().inflate(R.layout.overlay, null);
			}
			TextView textView = (TextView)view.findViewById(R.id.textName);
			textView.setText(getData().get(position));
			CheckBox checkBox = (CheckBox)view.findViewById(R.id.linkmain_item_checkbox);
			if(sign){
			checkBox.setChecked(true);
			System.out.println(">>>>>>>>>>>.checkBox.setChecked(true);");
			}else{
				checkBox.setChecked(false);
				System.out.println(">>>>>>>>>>>.checkBox.setChecked(false);");
			}
	
			return view;
		}

	}
}
