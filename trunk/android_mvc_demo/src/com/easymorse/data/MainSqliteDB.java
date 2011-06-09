package com.easymorse.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MainSqliteDB extends SQLiteOpenHelper {

	public static final String CREATE_PRODUCT_TABLE = "create table if not exists product_table"
			+ "(id integer PRIMARY KEY AUTOINCREMENT ,"
			+ "product_name text,product_price text)";

	public static final String DROP_PRODUCT_TABLE = "drop table if exists product_table";

	private final static String[] CREATE_TABLES = { CREATE_PRODUCT_TABLE };

	private final static String[] DROP_TABLES = { DROP_PRODUCT_TABLE };

	public MainSqliteDB(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		createTable(db);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		dropTable(db);
		createTable(db);
	}
	
	private void createTable(SQLiteDatabase database) {
		for (String sql : CREATE_TABLES) {
			database.execSQL(sql);
		}
	}
	
	private void dropTable(SQLiteDatabase database){
		for (String sql : DROP_TABLES) {
			database.execSQL(sql);
		}
	}
}
