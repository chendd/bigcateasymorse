package com.easymorse.separate;



import java.util.ArrayList;
import java.util.List;



import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	
	ListView listView;
	
	MyAdapter myAdapter;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        listView = (ListView) findViewById(R.id.mylistview);
		myAdapter = new MyAdapter(this,
				android.R.layout.simple_expandable_list_item_1, getData());
		listView.setAdapter(myAdapter);
    }
	private List<String> getData() {
		List<String> data = new ArrayList<String>();
		int i = 0;

		data.add("------------" + (i++));
		data.add("aa试数据" + (i++));
		data.add("a试数据" + (i++));
		data.add("aa试数据" + (i++));
		data.add("------------" + (i++));
		data.add("bb试数据" + (i++));
		data.add("b试数据" + (i++));
		data.add("b试数据" + (i++));		
		data.add("b试数据" + (i++));
		data.add("------------" + (i++));
		data.add("c测试数据" + (i++));
		data.add("c测试数据" + (i++));
		data.add("------------" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("d测试数据" + (i++));
		data.add("------------" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("e测试数据" + (i++));
		data.add("--------" + (i++));
		data.add("f测试数据" + (i++));
		return data;
	}
}
class MyAdapter extends ArrayAdapter<String> {

	public MyAdapter(Context context,  int textViewResourceId,
			List<String> objects) {
		super(context,  textViewResourceId, objects);
	
	}

	@Override
	public boolean areAllItemsEnabled() {
		return false; 
		// 不是所有项都可选
	}

	@Override
	public boolean isEnabled(int position) {
		return !getItem(position).startsWith("-"); 
		// 如果-开头，则该项不可选
	}
	
	
}