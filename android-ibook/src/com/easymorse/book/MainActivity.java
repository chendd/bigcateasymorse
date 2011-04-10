package com.easymorse.book;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

import com.easymorse.book.view.BookAdapter;
import com.easymorse.book.view.BookLayout;


public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	 BookLayout bk = new BookLayout(this);
         List<Integer> str = new ArrayList<Integer>();

         str.add(R.drawable.tiankong);
         str.add(R.drawable.qian);
         str.add(R.drawable.haer);
         str.add(R.drawable.gong);
         
         BookAdapter ba = new BookAdapter(this);
         ba.addItem(str);
         bk.setPageAdapter(ba);
         setContentView(bk);
    }
}