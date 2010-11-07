package com.mysqlite;

import java.io.File;

import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class DBHelper {
	
	private static final String TAG = "DBDemo_DBHelper";// 调试标签

	private static final String DATABASE_NAME = "dbdemos.db";// 数据库名
	
	SQLiteDatabase sqLiteDatabase;
	
	Context context;//应用环境上下文   Activity 是其子类

	DBHelper(Context _context) {
		context = _context;
		//开启数据库,如果没有，自动创建		 
		sqLiteDatabase = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE,null);
		createTable();
		Log.v(TAG, "db path=" + sqLiteDatabase.getPath());
	}

	/**
	 * 建表
	 * 列名 区分大小写？
	 * 都有什么数据类型？
	 * SQLite 3 
	 * 	TEXT    文本
		NUMERIC 数值
		INTEGER 整型
		REAL    小数
		NONE    无类型
	 * 查询可否发送select ?
	 */
	public void createTable() {
		try {
			sqLiteDatabase.execSQL("CREATE TABLE userinfo (" +
					"_ID INTEGER PRIMARY KEY autoincrement,"
					+ "name" 
					+ ");");
			Log.v(TAG, "Create Table userinfo ok");
		} catch (Exception e) {
			Log.v(TAG, "Create Table t_user err,table exists.");
		}
	}
	/**
	 * 增加数据
	 * @param id
	 * @param uname
	 * @return
	 */
	public boolean save(String uname){
    	String sql="";
    	try{
    		sql="insert into userinfo values(null,'"+uname+"')";
    		sqLiteDatabase.execSQL(sql);	       
	        return true;	        
        }catch(Exception e){
        	return false;
        }
    }

      public void close(){
    	  sqLiteDatabase.close();
	}
      
      public  String   select(String name){
//			SQLiteDatabase database = SQLiteDatabase
//			.openOrCreateDatabase(new File(
//					"data/data/com.mysqlite/databases/dbdemos.db"),
//					null);
			String where = "name = ?";
			String[] inputData = {name};

			Cursor  cursor = sqLiteDatabase.query("userinfo", null, where, inputData,
					null, null, null);

			if (cursor.moveToFirst()) {
				 return cursor.getString(1);
			}else{
				return null;
			}
      }
}
