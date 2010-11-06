package com.mybm;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.Browser;
import android.provider.Browser.BookmarkColumns;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
	private ListView listView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
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

}