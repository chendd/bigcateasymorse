package com.easymorse.separate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener,
OnGestureListener  {

	public ListView listView;

	MyAdapter myAdapter;

	public List<String> listTag = new ArrayList<String>();

	ImageView imageView;

	GestureDetector mygesture;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		listView = (ListView) findViewById(R.id.mylistview);
		myAdapter = new MyAdapter(this,
				android.R.layout.simple_expandable_list_item_1, getData());
		listView.setAdapter(myAdapter);
		
		imageView = (ImageView) findViewById(R.id.fliperImage);

		// 构建手势探测器
		mygesture = new GestureDetector(this);
		// mygesture.setIsLongpressEnabled(true);

		// 设置Touch监听
		imageView.setOnTouchListener(this);
		// 允许长按
		imageView.setLongClickable(true);
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return mygesture.onTouchEvent(event);
	}

	@Override
	public boolean onDown(MotionEvent e) {
		Log.v("tag", ">>>>>>>>onDown>>");
		util(e);
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		Log.v("tag", ">>>>>>>>onFling>>");
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {

		Log.v("tag", ">>>>>>>>onLongPress>>");
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		Log.v("tag",
				">>>>>>>>onScroll>>     x=" + distanceX + ">>>>>>>y="
						+ distanceY + ">>>>>>e2 x>" + e2.getRawX() + "e2 y>>"
						+ e2.getRawY());
		Log.v("tag", ">>>>>>>>>>>>" + imageView.getTop() + ">>>>>>>>"
				+ (float) imageView.getHeight() / 4f);
		
		util(e2);
		
		return false;
	}
	public void util(MotionEvent e2){
		int i = (int) ((e2.getRawY() - imageView.getTop()) / ((float) imageView
				.getHeight() / 4f));
		switch (i) {
		case 1:
			int pos = (myAdapter).getPositionForSection(1);
			listView.setSelectionFromTop(pos, 0);
			break;

		case 2:
			pos = (myAdapter).getPositionForSection(2);
			listView.setSelectionFromTop(pos, 0);
			break;

		case 3:
			pos = (myAdapter).getPositionForSection(3);
			listView.setSelectionFromTop(pos, 0);
			break;
			
		case 4:
			pos = (myAdapter).getPositionForSection(4);
			listView.setSelectionFromTop(pos, 0);
			break;

		case 5:
			pos = (myAdapter).getPositionForSection(5);
			listView.setSelectionFromTop(pos, 0);
			break;

			
		case 6:
			pos = (myAdapter).getPositionForSection(6);
			listView.setSelectionFromTop(pos, 0);
			break;

		default:
			break;
		}
	}
	
	@Override
	public void onShowPress(MotionEvent e) {

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {

		return false;
	}

	private List<String> getData() {
		List<String> data = new ArrayList<String>();
		int i = 0;

		data.add("A");
		listTag.add("A");
		data.add("aa试数据" + (i++));
		data.add("a试数据" + (i++));
		data.add("aa试数据" + (i++));
		listTag.add("B");
		data.add("B");
		data.add("bb试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		listTag.add("C");
		data.add("C");
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		listTag.add("D");
		data.add("D");
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		listTag.add("E");
		data.add("E");
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		listTag.add("F");
		data.add("F");
		data.add("f测试数据" + (i++));
		return data;
	}
	public HashMap<String, Integer> alphaIndexer;
	
	public String[] sections = new String[0];
	class MyAdapter extends ArrayAdapter<String> implements SectionIndexer {

	
		
		public MyAdapter(Context context, int textViewResourceId,
				List<String> objects) {
			super(context, textViewResourceId, objects);
			initSections(objects);
		}

		@Override
		public boolean areAllItemsEnabled() {
			return false;
			// 不是所有项都可选
		}

		@Override
		public boolean isEnabled(int position) {
			return !listTag.contains(getItem(position));
			// 如果-开头，则该项不可选
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = convertView;
			// 根据标签类型加载不通的布局模板
			if (listTag.contains(getItem(position))) {
				// 如果是标签项
				view = LayoutInflater.from(getContext()).inflate(
						R.layout.group_list_item_tag, null);
			} else {
				// 否则就是数据项了
				view = LayoutInflater.from(getContext()).inflate(
						R.layout.group_list_item, null);
			}
			// 显示名称
			TextView textView = (TextView) view
					.findViewById(R.id.group_list_item_text);
			textView.setText(getItem(position));
			// 返回重写的view
			return view;
		}

		@Override
		public int getPositionForSection(int section) {
			Log.v("tag", ">>>>>>>>>>>>>" + sections.length + ">>>"
					+ sections[0] + ">>>>>>>section" + section);
			for (String s : sections) {
				Log.v("tag", ">>>>>>>>s=>>>>>" + s);
			}
			String letter = sections[section];
			return alphaIndexer.get(letter);
		}

		@Override
		public int getSectionForPosition(int position) {
			Log.v("tag", ">>>>>>>>>>>>>" + sections.length + ">>>" + sections[0]);

			int prevIndex = 0;
			for (int i = 0; i < sections.length; i++) {
				if (getPositionForSection(i) > position && prevIndex <= position) {
					prevIndex = i;
					break;
				}
				prevIndex = i;
			}
			return prevIndex;
		}

		@Override
		public Object[] getSections() {
			Log.v("tag", ">>>>>>>>>>>>>" + sections.length + ">>>" + sections[0]);
			return sections;
		}

	}

	private void initSections(List<String> items) {
		alphaIndexer = new HashMap<String, Integer>();
		for (int i = items.size() - 1; i >= 0; i--) {
			String element = items.get(i);
			String firstChar = element.substring(0, 1).toUpperCase();// .substring(0,
																		// 1);
			if (firstChar.charAt(0) > 'Z' || firstChar.charAt(0) < 'A')
				firstChar = "#";
			alphaIndexer.put(firstChar, i);

		}
		Set<String> keys = alphaIndexer.keySet();
		Iterator<String> it = keys.iterator();
		ArrayList<String> keyList = new ArrayList<String>();
		while (it.hasNext())
			keyList.add(it.next());
		Collections.sort(keyList);
		sections = new String[keyList.size()];
		keyList.toArray(sections);
	}

}
