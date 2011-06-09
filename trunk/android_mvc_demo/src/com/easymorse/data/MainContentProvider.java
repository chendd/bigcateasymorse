package com.easymorse.data;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

public class MainContentProvider extends ContentProvider {

	public static final String PROVIDERNAME = "com.easymores.maincontentprovider";

	public static final Uri CONTENT_URI = Uri
			.parse("content://" + PROVIDERNAME);

	/**
	 * product table
	 */
	public static final String TABLE_NAME = "product_table";

	public static final String _ID = "id";

	public static int _ID_INDEX = 0;

	public static final String PRODUCT_NAME = "product_name";

	public static int PRODUCT_NAME_INDEX = 1;

	public static final String PRODUCT_PRICE = "product_price";

	public static int PRODUCT_PRICE_INDEX = 2;

	public static final int PRODUCT_ADD = 1;

	public static final int PRODUCT_QUERY = 2;

	public static final Uri CONTENT_PRODUCT_ADD = Uri.parse(CONTENT_URI
			+ "/add_product");

	public static final Uri CONTENT_PRODUCT_QUERY = Uri.parse(CONTENT_URI
			+ "/query_product");

	// 声明databae，供crud各个方式使用
	private SQLiteDatabase sqLiteDatabase;

	// 声明db版本，可以通过修改db版本，更新db中的内容
	private static int DATABASE_VERSION = 2;

	private static UriMatcher uriMatcher;

	static {
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		uriMatcher.addURI(PROVIDERNAME, "add_product", PRODUCT_ADD);
		uriMatcher.addURI(PROVIDERNAME, "query_product", PRODUCT_QUERY);
	}

	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {

		switch (uriMatcher.match(uri)) {

		case PRODUCT_ADD:
			Log.v("demo", "insert message to product table");
			sqLiteDatabase.insert(TABLE_NAME, _ID, values);
			return uri;

		default:
			throw new IllegalArgumentException("insert data >>unknown uri: "
					+ uri);
		}

	}

	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub

		sqLiteDatabase = new MainSqliteDB(this.getContext(), PROVIDERNAME,
				null, DATABASE_VERSION).getWritableDatabase();

		return sqLiteDatabase != null;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		switch (uriMatcher.match(CONTENT_PRODUCT_QUERY)) {
		case PRODUCT_QUERY:

			return sqLiteDatabase.query(TABLE_NAME, projection, selection,
					selectionArgs, null, null, sortOrder);
		default:
			throw new IllegalArgumentException("query data >>unknown uri: "
					+ uri);

		}
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		return 0;
	}

}
