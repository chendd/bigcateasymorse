package com.easymorse.book.view;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;


public class BookAdapter implements IAdapter{
	private List<Integer> strList = new ArrayList<Integer>();
	
	private Context mContext;
	public BookAdapter(Context context) {
		super();
		this.mContext = context;
	}
	public void addItem(List<Integer> list){
		strList.addAll(list);
	}
	public int getCount() {
		return strList.size();
	}

	public int getItem(int position) {
		return (int)strList.get(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position) {
		
		ImageView imageView = new ImageView(mContext);
		imageView.setLayoutParams(new FrameLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT));
		imageView.setImageResource(strList.get(position));
		return imageView;
	}

}
