package com.easymorse.listview;

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
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SectionIndexer;

public class MainActivity extends Activity  {

	ListView listView;

	HashMap<String, Integer> alphaIndexer;
	
	private String[] sections = new String[0]; 
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		listView = (ListView) findViewById(R.id.mylistview);
		MyAdapter myAdapter = new MyAdapter(this,android.R.layout.simple_expandable_list_item_1,getData());
		listView.setAdapter(myAdapter);
		
		//listView.setSelection(15);
		
		int pos=(myAdapter).getPositionForSection(3);
		listView.setSelectionFromTop(pos, 0);
	}

	private List<String> getData() {
		List<String> data = new ArrayList<String>();
		int i=0;
		
	
		data.add("@section"+(i++));
		data.add("aa试数据"+(i++));
		data.add("aaa试数据"+(i++));
		data.add("aa试数据"+(i++));
		data.add("aa试数据"+(i++));
		data.add("a试数据"+(i++));
		data.add("a试数据"+(i++));
		data.add("aa试数据"+(i++));
		data.add("@section"+(i++));
		data.add("bb试数据"+(i++));
		data.add("b试数据"+(i++));
		data.add("b试数据"+(i++));
		data.add("b试数据"+(i++));
		data.add("bb试数据"+(i++));
		data.add("bb试数据"+(i++));
		data.add("b试数据"+(i++));
		data.add("b试数据"+(i++));
		data.add("b试数据"+(i++));
		data.add("b试数据"+(i++));
		data.add("@section"+(i++));
		data.add("c测试数据"+(i++));
		data.add("c测试数据"+(i++));
		data.add("c测试数据"+(i++));
		data.add("c测试数据"+(i++));
		data.add("c测试数据"+(i++));
		data.add("c测试数据"+(i++));
		data.add("c测试数据"+(i++));
		data.add("c测试数据"+(i++));
		data.add("c测试数据"+(i++));
		data.add("@section"+(i++));
		data.add("d测试数据"+(i++));
		data.add("d测试数据"+(i++));
		data.add("d测试数据"+(i++));
		data.add("d测试数据"+(i++));
		data.add("d测试数据"+(i++));
		data.add("d测试数据"+(i++));
		data.add("d测试数据"+(i++));
		data.add("@section"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("e测试数据"+(i++));
		data.add("@section"+(i++));
		data.add("f测试数据"+(i++));
		data.add("f测试数据"+(i++));
		data.add("f测试数据"+(i++));
		data.add("f测试数据"+(i++));
		data.add("f测试数据"+(i++));
		data.add("f测试数据"+(i++));
		return data;
	}

	
	
}
class MyAdapter extends ArrayAdapter<String> implements SectionIndexer{
	private Context mContext;
	private LayoutInflater mInflater;
	private HashMap<String, Integer> alphaIndexer; 
	private String[] sections = new String[0]; 
	
	private List<String> objects;
	
	public MyAdapter(Context context, int textViewResourceId,
	List<String> objects) {
	super(context, textViewResourceId, objects);
	mContext=context;
		mInflater = LayoutInflater.from(mContext);
	initSections(objects);
	this.objects = objects;
	}
	
	
	
	@Override
	public String getItem(int position) {
		
		return objects.get(position);
	}



	@Override
	public int getPositionForSection(int section)   { 
		
		Log.v("tag", ">>>>>>>>>>>>>"+sections.length+">>>"+sections[0]+">>>>>>>section"+section);
		for(String s :sections){
			Log.v("tag", ">>>>>>>>s=>>>>>"+s);
		}
	          String letter = sections[section]; 
	          return alphaIndexer.get(letter); 
	    } 
	 
	@Override
	public int getSectionForPosition(int position)  { 
		
		Log.v("tag", ">>>>>>>>>>>>>"+sections.length+">>>"+sections[0]);
		
	        int prevIndex = 0; 
	        for(int i = 0; i < sections.length; i++)         { 
	            if(getPositionForSection(i) > position && prevIndex <= position) { 
	                prevIndex = i; 
	                break; 
	            } 
	            prevIndex = i; 
	        } 
	        return prevIndex; 
	    } 
	@Override
	public Object[] getSections() {
		Log.v("tag", ">>>>>>>>>>>>>"+sections.length+">>>"+sections[0]);
	return sections; 
	}
	private void initSections(List<String> items){
		alphaIndexer = new HashMap<String, Integer>(); 
		        for(int i = items.size() - 1; i >= 0; i--) { 
		        	String element = items.get(i); 
		            String firstChar = element.substring(0,1).toUpperCase();//.substring(0, 1); 
		            if(firstChar.charAt(0) > 'Z' || firstChar.charAt(0) < 'A') 
		                firstChar = "#"; 
		            alphaIndexer.put(firstChar, i);
		            
		        } 
		        Set<String> keys = alphaIndexer.keySet(); 
		        Iterator<String> it = keys.iterator(); 
		        ArrayList<String> keyList = new ArrayList<String>(); 
		        while(it.hasNext()) 
		            keyList.add(it.next()); 
		        Collections.sort(keyList); 
		        sections = new String[keyList.size()]; 
		        keyList.toArray(sections); 
		}
		
	@Override
	public boolean areAllItemsEnabled() {
	   return false; //不是所有项都可选
	}
	@Override
	public boolean isEnabled(int position) {
	   return !getItem(position).startsWith("@section"); //如果名字以@section开头，则该项不可选
	}
}