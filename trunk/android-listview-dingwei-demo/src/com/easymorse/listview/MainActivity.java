package com.easymorse.listview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener,
		OnGestureListener {

	ListView listView;

	HashMap<String, Integer> alphaIndexer;

	private String[] sections = new String[0];

	ImageView imageView;

	GestureDetector mygesture;
	
	MyAdapter myAdapter;

	TextView overlay;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		
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
		
		listView = (ListView) findViewById(R.id.mylistview);
		myAdapter = new MyAdapter(this,
				android.R.layout.simple_expandable_list_item_1, getData());
		listView.setAdapter(myAdapter);

		// listView.setSelection(15);

		

		imageView = (ImageView) findViewById(R.id.fliperImage);

		// 构建手势探测器
		mygesture = new GestureDetector(this);
		// mygesture.setIsLongpressEnabled(true);

		// 设置Touch监听
		imageView.setOnTouchListener(this);
		// 允许长按
		imageView.setLongClickable(true);
		
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

		data.add("@section" + (i++));
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

}

class MyAdapter extends ArrayAdapter<String> implements SectionIndexer {
	private Context mContext;
	private LayoutInflater mInflater;
	private HashMap<String, Integer> alphaIndexer;
	private String[] sections = new String[0];

	private List<String> objects;

	public MyAdapter(Context context, int textViewResourceId,
			List<String> objects) {
		super(context, textViewResourceId, objects);
		mContext = context;
		mInflater = LayoutInflater.from(mContext);
		initSections(objects);
		this.objects = objects;
	}

	@Override
	public String getItem(int position) {

		return objects.get(position);
	}

	@Override
	public int getPositionForSection(int section) {

		Log.v("tag", ">>>>>>>>>>>>>" + sections.length + ">>>" + sections[0]
				+ ">>>>>>>section" + section);
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

	@Override
	public boolean areAllItemsEnabled() {
		return false; // 不是所有项都可选
	}

	@Override
	public boolean isEnabled(int position) {
		return !getItem(position).startsWith("@section"); // 如果名字以@section开头，则该项不可选
	}
}