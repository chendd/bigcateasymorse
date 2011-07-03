package com.easymorse.mygallery;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.widget.Gallery;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.SpinnerAdapter;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Gallery myGallery = (Gallery) findViewById(R.id.mygallery);
        
        SpinnerAdapter spinnerAdapter = new SimpleAdapter(this,getData(),
        		R.layout.myfont_layout,
        		new String[] {"mydata"},new int[] { android.R.id.text1 });                
        myGallery.setAdapter(spinnerAdapter);
        
        
        Gallery myGallery1 = (Gallery) findViewById(R.id.mygallery1);
        
           
                
        myGallery1.setAdapter(spinnerAdapter);
    }
    public List<Map<String,String>> getData(){
    	List<Map<String,String>> myList = new ArrayList<Map<String,String>>();
    	Map myMap = new HashMap<String,String>();
    	myMap.put("mydata","aaa");
    	myList.add(myMap);
    	
    	myMap = new HashMap<String,String>();
    	myMap.put("mydata","bbb");
    	myList.add(myMap);
    	
    	myMap = new HashMap<String,String>();
    	myMap.put("mydata","ccc");
    	myList.add(myMap);
    	
    	myMap = new HashMap<String,String>();
    	myMap.put("mydata","ddd");
    	myList.add(myMap);
    	
    	myMap = new HashMap<String,String>();
    	myMap.put("mydata","eee");
    	myList.add(myMap);
    	
    	myList.add(myMap);
    	return myList;
    }
}