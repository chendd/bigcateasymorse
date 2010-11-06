package com.mybm;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Browser;
import android.provider.Browser.BookmarkColumns;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView listView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		insertBookMark();
		deleteBookMark();
		listView = (ListView) findViewById(R.id.bookmarklist);
		listView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, getData()));

	}

	private List<String> getData() {

		List<String> data = new ArrayList<String>();
		ContentResolver contentResolver = getContentResolver();
		Cursor cursor = contentResolver.query(Browser.BOOKMARKS_URI, null,
				null, null, null);

		while (cursor.moveToNext()) {
			if (cursor.getString(
					cursor.getColumnIndex(Browser.BookmarkColumns.BOOKMARK))
					.equals("1")) {
				data.add(cursor.getString(cursor
						.getColumnIndex(BookmarkColumns.TITLE)));
			}
		}

		return data;
	}

	private void insertBookMark() {
		ContentValues inputValue = new ContentValues();
		// Bookmark值为1
		inputValue.put(Browser.BookmarkColumns.BOOKMARK, 1);
		// 添加书签Title
		inputValue.put(Browser.BookmarkColumns.TITLE, "witmob");
		// 添加书签URL
		inputValue.put(Browser.BookmarkColumns.URL,
				"http://bigcat.easymorse.com/");

		ContentResolver contentResolver = getContentResolver();

		// 向浏览器添加该书签

		contentResolver.insert(Browser.BOOKMARKS_URI, inputValue);

	}

	private void deleteBookMark() {

		ContentResolver contentResolver = getContentResolver();

		// 删除书签

		int number = contentResolver.delete(Browser.BOOKMARKS_URI,
				Browser.BookmarkColumns.TITLE + "=? and "
						+ Browser.BookmarkColumns.URL + "=?", new String[] {
						"witmob", "http://bigcat.easymorse.com/" });

	}
}