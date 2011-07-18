package com.easymorse.separate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



import net.sourceforge.pinyin4j.PinyinHelper;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.Contacts.Phones;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends Activity implements OnTouchListener,
		OnGestureListener {

	public ListView listView;

//	MyAdapter myAdapter;

	MyAdapters myAdapter;

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

		this.overlay = (TextView) this.getLayoutInflater().inflate(
				R.layout.overlay, null);
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

//		myAdapter = new MyAdapter(this, android.R.layout.simple_list_item_1,
//				getData());

		Cursor c = getContentResolver().query(People.CONTENT_URI, null, null,
				null, null);
		myAdapter = new MyAdapters(this, android.R.layout.simple_list_item_1,
				c,
				// Map the NAME column in the people database to...
				new String[] { People.NAME },
				// The "text1" view defined in the XML template
				new int[] { android.R.id.text1 });

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
				// if (visible) {
				overlay.setText(nameList.get(firstVisibleItem).substring(0, 1));
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
		int j=0;
		switch (i) {
		case 0:
			int pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);
			break;

		case 1:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);
			break;

		case 2:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);
			break;

		case 3:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);
			break;

		case 4:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);
			break;

		case 5:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 6:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 7:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 8:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 9:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 10:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 11:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 12:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 13:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 14:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 15:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 16:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

		case 17:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 18:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 19:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

		case 20:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 21:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 22:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 23:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 24:
			pos = (myAdapter).getPositionForSection(j++);
			listView.setSelectionFromTop(pos, 0);

			break;

		case 25:
			pos = (myAdapter).getPositionForSection(j++);
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


	public HashMap<String, Integer> alphaIndexer;

	public String[] sections = new String[0];


	public String getAllFirstLetter(String str) { 
        String convert = ""; 
        for (int j = 0; j < str.length(); j++) { 
            char word = str.charAt(j); 
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word); 
            if (pinyinArray != null) { 
                convert += pinyinArray[0].charAt(0); 
            }else { 
                convert += word; 
            } 
        } 
        return convert; 
    }
	
	List<String> nameList = new ArrayList<String>();
	class MyAdapters extends SimpleCursorAdapter implements SectionIndexer {

		Context context;

		

		public MyAdapters(Context context, int layout, Cursor c, String[] from,
				int[] to) {

			super(context, layout, c, from, to);
			int i = c.getColumnIndex(Phones.NAME);
			if (c.moveToFirst()) {
				while (c.moveToNext()) {
					String name = c.getString(i);
					
					if(name != null && !name.equals("")){
						if(name.trim()!=null && !name.trim().equals("") && !name.contains("3")){
							nameList.add(name.trim());
						}
						
					}

					
					Log.v("tag", ">>>>>>>>>>>>" + c.getString(i));
				}
			}
			nameList.add("A");

			nameList.add("B");

			nameList.add("C");

			nameList.add("D");

			nameList.add("E");

			nameList.add("F");

			nameList.add("G");

			nameList.add("H");

			nameList.add("I");

			nameList.add("J");

			nameList.add("L");

			nameList.add("M");

			nameList.add("N");

			nameList.add("O");

			nameList.add("P");

			nameList.add("Q");

			nameList.add("R");

			nameList.add("S");

			nameList.add("T");

			nameList.add("U");

			nameList.add("V");

			nameList.add("W");

			nameList.add("X");

			nameList.add("Y");

			nameList.add("Z");
			
			listTag.add("A");

			listTag.add("B");

			listTag.add("C");

			listTag.add("D");

			listTag.add("E");

			listTag.add("F");

			listTag.add("G");

			listTag.add("H");

			listTag.add("I");

			listTag.add("J");

			listTag.add("K");

			listTag.add("L");

			listTag.add("M");

			listTag.add("N");

			listTag.add("O");

			listTag.add("P");

			listTag.add("Q");

			listTag.add("R");

			listTag.add("S");

			listTag.add("T");

			listTag.add("U");

			listTag.add("V");

			listTag.add("W");

			listTag.add("X");

			listTag.add("Y");

			listTag.add("Z");
			Collections.sort(nameList, new Comparator() {

				public int compare(Object _o1, Object _o2) {

					return (getAllFirstLetter(((String) _o1).toLowerCase()
							).compareTo(getAllFirstLetter(((String) _o2).toLowerCase())));
				}
			});
			initSections(nameList);
			this.context = context;

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
				view = LayoutInflater.from(context).inflate(
						R.layout.group_list_item_tag, null);
			} else {
				// 否则就是数据项了
				view = LayoutInflater.from(context).inflate(
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

		@Override
		public String getItem(int position) {
			if(position<nameList.size()){
				return nameList.get(position);
			}
			else{
				return null;
			}
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
