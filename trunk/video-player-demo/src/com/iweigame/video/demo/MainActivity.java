/*
 * Copyright (C) 2011 VOV IO (http://vov.io/)
 */

package com.iweigame.video.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;

public class MainActivity extends Activity {

	String cachePath;

	VideoView videoView;
	private Button ok;
	private EditText urlEidt;
	

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.activity_main);
		ok = (Button) this.findViewById(R.id.ok);
		urlEidt = (EditText) this.findViewById(R.id.url);

		ok.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String url = urlEidt.getText().toString();
				Intent intent = new Intent();
				intent.setClass(MainActivity.this, VideoViewDemo.class);
				intent.putExtra("url", url);
				startActivityForResult(intent, 0);
				//MainActivity.this.finish();
			}

		});
		if(!isApkExist()){
			
			
			//先安装apk
			// 获取系统缓冲绝对路径 获取/data/data//cache目录
			File cacheDir = this.getCacheDir();
			cachePath = cacheDir.getAbsolutePath() + "/temp.apk";
			//
			// 捆绑安装
			retrieveApkFromAssets(this, "io.vov.vitamio-1.apk", cachePath);

			showInstallConfirmDialog(this, cachePath);
		}
		
		

	}

	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		Log.v("tag", ">>>>>>>>>>>>>>>>.result.........");
		super.onActivityResult(requestCode, resultCode, data);
	}

	/**
	 * 遍历程序列表，判断是否安装安全支付服务
	 * 
	 * @return
	 */
	public boolean isApkExist() {
		PackageManager manager = this.getPackageManager();
		List<PackageInfo> pkgList = manager.getInstalledPackages(0);
		for (int i = 0; i < pkgList.size(); i++) {
			PackageInfo pI = pkgList.get(i);

			if (pI.packageName.equalsIgnoreCase("io.vov.vitamio"))
				return true;
		}

		return false;
	}

	/**
	 * 安装安全支付服务，安装assets文件夹下的apk
	 * 
	 * @param context
	 * 上下文环境
	 * @param fileName
	 * apk名称
	 * @param path
	 * 安装路径
	 * @return
	 */
	public boolean retrieveApkFromAssets(Context context, String fileName, String path) {
		boolean bRet = false;

		try {
			InputStream is = context.getAssets().open(fileName);

			File file = new File(path);
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);

			byte[] temp = new byte[1024];
			int i = 0;
			while ((i = is.read(temp)) > 0) {
				fos.write(temp, 0, i);
			}

			fos.close();
			is.close();

			bRet = true;

		} catch (IOException e) {
			e.printStackTrace();
		}

		return bRet;
	}

	/**
	 * 显示确认安装的提示
	 * 
	 * @param context
	 * 上下文环境
	 * @param cachePath
	 * 安装文件路径
	 */
	public void showInstallConfirmDialog(final Context context, final String cachePath) {
		AlertDialog.Builder tDialog = new AlertDialog.Builder(context);
		tDialog.setIcon(R.drawable.info);
		tDialog.setTitle(context.getResources().getString(R.string.confirm_install_hint));
		tDialog.setMessage(context.getResources().getString(R.string.confirm_install));

		tDialog.setPositiveButton(R.string.Ensure, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				//
				// 修改apk权限
				BaseHelper.chmod("777", cachePath);

				//
				// install the apk.
				// 安装安全支付服务APK
				Intent intent = new Intent(Intent.ACTION_VIEW);
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				intent.setDataAndType(Uri.parse("file://" + cachePath), "application/vnd.android.package-archive");
				MainActivity.this.startActivityForResult(intent, 200);
				}
		});

//		tDialog.setNegativeButton(
//				context.getResources().getString(R.string.Cancel),
//				new DialogInterface.OnClickListener() {
//					public void onClick(DialogInterface dialog, int which) {
//					}
//				});

		tDialog.show();
	}

}
