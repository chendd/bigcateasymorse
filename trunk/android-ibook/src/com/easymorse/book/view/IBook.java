package com.easymorse.book.view;

import android.view.View;

public interface IBook {
	public View getView(int position);

	public int getCount();
}
