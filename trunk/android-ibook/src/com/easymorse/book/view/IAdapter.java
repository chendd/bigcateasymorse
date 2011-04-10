package com.easymorse.book.view;

import android.view.View;

public interface IAdapter {
	public int getCount();
	public int getItem(int position);
	public long getItemId(int position);
	public View getView(int position);
}
