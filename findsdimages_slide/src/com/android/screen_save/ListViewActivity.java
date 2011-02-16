package com.android.screen_save;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity { 
    private ListView listView; 
    /** Called when the activity is first created. */ 
    public static List<String> imageS = new ArrayList<String>();
    @Override 
    public void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.listviews); 
        listView = (ListView)findViewById(R.id.listview1); 
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,getData()));
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int index,
					long arg3) {
				
				Log.v(">>>>>", v.getId()+"....."+index+">>>"+  arg0.getItemAtPosition(index));
				imageS=getImagePath( arg0.getItemAtPosition(index).toString());
				Intent intent = new Intent();
				intent.setClass(ListViewActivity.this, ScreenSave.class);
				startActivity(intent);
						
				
				
			}
		});
    } 
    private List<String> getData(){ 
        List<String> data = new ArrayList<String>(); 
//        data.add("测试数据1"); 
//        data.add("测试数据2"); 
//        data.add("测试数据3"); 
//        data.add("测试数据4"); 
        for(String s:getAllImageDir()){
        	data.add(s);
        }
        return  data; 
    } 
    
    
	public   Set<String>  getAllImageDir(){
		 Set<String> imageDirdata = new HashSet<String>(); 
	    Uri images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

	    // Make the query.\
	    
	    Cursor cur = managedQuery(images,
	            null, // Which columns to return
	            "",         // Which rows to return (all rows)
	            null,       // Selection arguments (none)
	            ""          // Ordering
	            );
	    if (cur.moveToFirst()) {
	        String bucket;
	        String date;
	        int bucketColumn = cur.getColumnIndex(
	            MediaStore.Images.Media.BUCKET_DISPLAY_NAME);

	        int imagePath = cur.getColumnIndex(MediaStore.Images.Media.DATA);

	        do {
	            // Get the field values
	            bucket = cur.getString(bucketColumn);
	            date = cur.getString(imagePath);
	            imageDirdata.add(bucket); 
	            // Do something with the values.
//	            Log.i("ListingImages", " bucket=" + bucket
//	                   + "  date_taken=" + date+">>>>"+cur.getString(0)+"----"+cur.getString(1)+" "+cur.getString(2));
	        } while (cur.moveToNext());

	    }
	    return imageDirdata;
	}
	
	public    List<String>  getImagePath(String fileDir){
		 List<String> data = new ArrayList<String>(); 
	    Uri images = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

	    // Make the query.\
	    
	    Cursor cur = managedQuery(images,
	            null, // Which columns to return
	            MediaStore.Images.Media.BUCKET_DISPLAY_NAME+"=?",         // Which rows to return (all rows)
	            new String[]{fileDir},       // Selection arguments (none)
	            null          // Ordering
	            );
	    if (cur.moveToFirst()) {

	        int imagePath = cur.getColumnIndex(MediaStore.Images.Media.DATA);

	        do {
	            
	         
	            data.add(cur.getString(imagePath)); 
	            // Do something with the values.
	            Log.i("ListingImages", "----"+cur.getString(imagePath));
	        } while (cur.moveToNext());

	    }
	    return data;
	}
	
}