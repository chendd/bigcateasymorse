package com.iweigame.google;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class ResultListAdapter extends BaseAdapter {

	private List<MyGoogleBean> myGoogleBeans;
	
	private Context context;
	
	
	
	public ResultListAdapter(List<MyGoogleBean> myGoogleBeans, Context context) {
		super();
		this.myGoogleBeans = myGoogleBeans;
		this.context = context;
	}

	@Override
	public int getCount() {
		
		return myGoogleBeans.size();
	}

	@Override
	public Object getItem(int position) {
		
		return myGoogleBeans.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		if(convertView == null){
			convertView = (View)LayoutInflater.from(context).inflate(R.layout.list_item,null);
		}
		TextView nameTextView = (TextView)convertView.findViewById(R.id.nameString);
		TextView addTextView = (TextView)convertView.findViewById(R.id.addressString);
		
		nameTextView.setText(myGoogleBeans.get(position).getName());
		addTextView.setText(myGoogleBeans.get(position).getAddress());
		
		return convertView;
	}

}
