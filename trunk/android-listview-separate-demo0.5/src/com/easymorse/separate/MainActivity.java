package com.easymorse.separate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;
import android.widget.AbsListView.OnScrollListener;

public class MainActivity extends Activity implements OnTouchListener,
		OnGestureListener {

	public ListView listView;

	MyAdapter myAdapter;

	public List<String> listTag = new ArrayList<String>();

	// ImageView imageView;

	GestureDetector mygesture;

	View view;

	TextView overlay;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		listView = (ListView) findViewById(R.id.mylistview);
		
		
		this.overlay = (TextView) this.getLayoutInflater().inflate(R.layout.overlay, null); 
		getWindowManager() 
		        .addView( 
		                overlay, 
		                new WindowManager.LayoutParams( 
		                        LayoutParams.WRAP_CONTENT, 
		                        LayoutParams.WRAP_CONTENT, 
		                        WindowManager.LayoutParams.TYPE_APPLICATION, 
		                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE 
		                                | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, 
		                        PixelFormat.TRANSLUCENT));
		
		
		myAdapter = new MyAdapter(this, android.R.layout.simple_list_item_1,
				getData());
		listView.setAdapter(myAdapter);

		view = (View) findViewById(R.id.zimulist);

		// 构建手势探测器
		mygesture = new GestureDetector(this);
		// mygesture.setIsLongpressEnabled(true);

		// 设置Touch监听
		view.setOnTouchListener(this);
		// 允许长按
		view.setLongClickable(true);
		
		
		listView.setOnScrollListener(new OnScrollListener() {

		    boolean visible;

		    @Override 
		    public void onScrollStateChanged(AbsListView view, int scrollState) { 
		    	Log.v("tag", ">>>>>>>>onScrollStateChanged>>");
		        visible = true; 
		        if (scrollState == ListView.OnScrollListener.SCROLL_STATE_IDLE) { 
		            overlay.setVisibility(View.INVISIBLE); 
		        } 
		    }

		    @Override 
		    public void onScroll(AbsListView view, int firstVisibleItem, 
		            int visibleItemCount, int totalItemCount) { 
		    	Log.v("tag", ">>>>>>>>onScroll>>");
		        //if (visible) { 
		            overlay.setText(getData().get(firstVisibleItem).substring(0, 1)); 
		            overlay.setVisibility(View.VISIBLE); 
		       // } 
		    } 
		});
		
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

		util(e2);

		return false;
	}

	public void util(MotionEvent e2) {
		int i = (int) ((e2.getRawY() - view.getTop()) / ((float) view
				.getHeight() / 26f));
		switch (i) {
		case 0:
			int pos = (myAdapter).getPositionForSection(1);
			listView.setSelectionFromTop(pos, 0);
			break;

		case 1:
			pos = (myAdapter).getPositionForSection(2);
			listView.setSelectionFromTop(pos, 0);
			break;

		case 2:
			pos = (myAdapter).getPositionForSection(3);
			listView.setSelectionFromTop(pos, 0);
			break;

		case 3:
			pos = (myAdapter).getPositionForSection(4);
			listView.setSelectionFromTop(pos, 0);
			break;

		case 4:
			pos = (myAdapter).getPositionForSection(5);
			listView.setSelectionFromTop(pos, 0);
			break;

		case 5:
			pos = (myAdapter).getPositionForSection(6);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 6:
			pos = (myAdapter).getPositionForSection(7);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 7:
			pos = (myAdapter).getPositionForSection(8);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 8:
			pos = (myAdapter).getPositionForSection(9);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 9:
			pos = (myAdapter).getPositionForSection(10);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 10:
			pos = (myAdapter).getPositionForSection(11);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 11:
			pos = (myAdapter).getPositionForSection(12);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 12:
			pos = (myAdapter).getPositionForSection(13);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 13:
			pos = (myAdapter).getPositionForSection(14);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 14:
			pos = (myAdapter).getPositionForSection(15);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 15:
			pos = (myAdapter).getPositionForSection(16);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 16:
			pos = (myAdapter).getPositionForSection(17);
			listView.setSelectionFromTop(pos, 0);

		case 17:
			pos = (myAdapter).getPositionForSection(18);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 18:
			pos = (myAdapter).getPositionForSection(19);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 19:
			pos = (myAdapter).getPositionForSection(20);
			listView.setSelectionFromTop(pos, 0);

		case 20:
			pos = (myAdapter).getPositionForSection(21);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 21:
			pos = (myAdapter).getPositionForSection(22);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 22:
			pos = (myAdapter).getPositionForSection(23);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 23:
			pos = (myAdapter).getPositionForSection(24);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 24:
			pos = (myAdapter).getPositionForSection(25);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 25:
			pos = (myAdapter).getPositionForSection(26);
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
		data.add("aa试数据" + (i++));
		data.add("a试数据" + (i++));
		data.add("aa试数据" + (i++));
		data.add("aa试数据" + (i++));
		data.add("a试数据" + (i++));
		data.add("aa试数据" + (i++));
		data.add("aa试数据" + (i++));
		data.add("a试数据" + (i++));
		data.add("aa试数据" + (i++));
		listTag.add("B");
		data.add("B");
		data.add("bb试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("bb试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("bb试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("bb试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));
		listTag.add("C");
		data.add("C");
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		listTag.add("D");
		data.add("D");
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		listTag.add("E");
		data.add("E");
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		listTag.add("F");
		data.add("F");
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));
		data.add("f测试数据" + (i++));

		listTag.add("G");
		data.add("G");
		data.add("G测试数据" + (i++));
		data.add("G测试数据" + (i++));
		data.add("G测试数据" + (i++));
		data.add("G测试数据" + (i++));

		listTag.add("H");
		data.add("H");
		data.add("H测试数据" + (i++));

		listTag.add("I");
		data.add("I");
		data.add("I测试数据" + (i++));

		listTag.add("J");
		data.add("J");
		data.add("J测试数据" + (i++));
		data.add("J测试数据" + (i++));
		data.add("J测试数据" + (i++));
		data.add("J测试数据" + (i++));

		listTag.add("K");
		data.add("K");
		data.add("K测试数据" + (i++));
		data.add("K测试数据" + (i++));
		data.add("K测试数据" + (i++));
		data.add("K测试数据" + (i++));
		data.add("K测试数据" + (i++));
		data.add("K测试数据" + (i++));
		data.add("K测试数据" + (i++));
		data.add("K测试数据" + (i++));
		data.add("K测试数据" + (i++));
		data.add("K测试数据" + (i++));
		data.add("K测试数据" + (i++));
		data.add("K测试数据" + (i++));

		listTag.add("L");
		data.add("L");
		data.add("L测试数据" + (i++));
		data.add("L测试数据" + (i++));
		data.add("L测试数据" + (i++));
		data.add("L测试数据" + (i++));
		data.add("L测试数据" + (i++));
		data.add("L测试数据" + (i++));
		data.add("L测试数据" + (i++));

		data.add("L测试数据" + (i++));

		listTag.add("M");
		data.add("M");
		data.add("M测试数据" + (i++));
		data.add("M测试数据" + (i++));
		data.add("M测试数据" + (i++));
		data.add("M测试数据" + (i++));

		listTag.add("N");
		data.add("N");
		data.add("N测试数据" + (i++));
		data.add("N测试数据" + (i++));
		data.add("N测试数据" + (i++));
		data.add("N测试数据" + (i++));
		data.add("N测试数据" + (i++));

		listTag.add("O");
		data.add("O");
		data.add("O试数据" + (i++));
		data.add("O试数据" + (i++));
		data.add("O试数据" + (i++));
		data.add("O试数据" + (i++));

		listTag.add("P");
		data.add("P");
		data.add("P测试数据" + (i++));

		listTag.add("Q");
		data.add("Q");
		data.add("Q测试数据" + (i++));
		listTag.add("R");
		data.add("R");
		data.add("R测试数据" + (i++));

		listTag.add("S");
		data.add("S");
		data.add("S测试数据" + (i++));

		listTag.add("T");
		data.add("T");
		data.add("T测试数据" + (i++));

		listTag.add("U");
		data.add("U");
		data.add("U测试数据" + (i++));

		listTag.add("V");
		data.add("V");
		data.add("V测试数据" + (i++));
		data.add("V测试数据" + (i++));
		data.add("V测试数据" + (i++));
		data.add("V测试数据" + (i++));
		data.add("V测试数据" + (i++));
		data.add("V测试数据" + (i++));
		data.add("V测试数据" + (i++));

		listTag.add("W");
		data.add("W");
		data.add("W测试数据" + (i++));
		data.add("W测试数据" + (i++));
		data.add("W测试数据" + (i++));
		data.add("W测试数据" + (i++));
		data.add("W测试数据" + (i++));
		data.add("W测试数据" + (i++));

		listTag.add("X");
		data.add("X");
		data.add("X测试数据" + (i++));
		data.add("X测试数据" + (i++));
		data.add("X测试数据" + (i++));
		data.add("X测试数据" + (i++));
		data.add("X测试数据" + (i++));

		listTag.add("Y");
		data.add("Y");
		data.add("Y测试数据" + (i++));
		data.add("Y测试数据" + (i++));
		data.add("Y测试数据" + (i++));
		data.add("Y测试数据" + (i++));
		data.add("Y测试数据" + (i++));
		data.add("Y测试数据" + (i++));
		data.add("Y测试数据" + (i++));
		data.add("Y测试数据" + (i++));
		data.add("Y测试数据" + (i++));
		data.add("Y测试数据" + (i++));
		data.add("Y测试数据" + (i++));

		listTag.add("Z");
		data.add("Z");
		data.add("Z测试数据" + (i++));
		data.add("Z测试数据" + (i++));
		data.add("Z测试数据" + (i++));
		data.add("Z测试数据" + (i++));
		data.add("Z测试数据" + (i++));
		data.add("Z测试数据" + (i++));
		data.add("Z测试数据" + (i++));

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
			String letter = sections[section - 1];
			return alphaIndexer.get(letter);
		}

		@Override
		public int getSectionForPosition(int position) {
			Log.v("tag", ">>>>>>>>>>>>>" + sections.length + ">>>"
					+ sections[0]);

			int prevIndex = 0;
			for (int i = 0; i < sections.length; i++) {
				if (getPositionForSection(i) > position
						&& prevIndex <= position) {
					prevIndex = i;
					break;
				}
				prevIndex = i;
			}
			return prevIndex;
		}

		@Override
		public Object[] getSections() {
			Log.v("tag", ">>>>>>>>>>>>>" + sections.length + ">>>"
					+ sections[0]);
			return sections;
		}

	}

	private void initSections(List<String> items) {
		alphaIndexer = new HashMap<String, Integer>();
		for (int i = items.size() - 1; i >= 0; i--) {
			String element = items.get(i);
			String firstChar = element.substring(0, 1).toUpperCase();
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
