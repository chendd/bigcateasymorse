package com.mylist;

import java.util.ArrayList;
import java.util.Arrays;




import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends ListActivity {
    /** Called when the activity is first created. */
	private static String[] items = { "浙江", "江苏", "广东", "上海", "北京", "新疆" };
	private MyAdapter adapter = null;
	private ArrayList<String> array = new ArrayList<String>(
			Arrays.asList(items));

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.main);

		adapter = new MyAdapter();
		setListAdapter(adapter);
		ListViewInterceptor tlv = (ListViewInterceptor) getListView();

		tlv.setDropListener(onDrop);
		
		tlv.getAdapter();
	}
	private ListViewInterceptor.DropListener onDrop = new ListViewInterceptor.DropListener() {
		@Override
		public void drop(int from, int to) {
			String item = adapter.getItem(from);

			adapter.remove(item);
			adapter.insert(item, to);

		}
	};
	class MyAdapter extends ArrayAdapter<String> {
		
		MyAdapter() {
			super(MainActivity.this, R.layout.mylistview, array);
		}
		public ArrayList<String> getList() {
			return array;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			if (row == null) {
				LayoutInflater inflater = getLayoutInflater();
				row = inflater.inflate(R.layout.mylistview, parent, false);
			}
			TextView label = (TextView) row.findViewById(R.id.label);
			label.setText(array.get(position));
			return (row);
		}
	}
}