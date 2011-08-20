package com.iweigame;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

	int count = 0;

	ProgressDialog myDialog;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button button = (Button) findViewById(R.id.mybutton);

		button.setOnClickListener(new Button.OnClickListener() {
			@Override
			public void onClick(View v) {
				count = 0;
				showmyDialog();

				new Thread() {
					public void run() {
						try {
							while (count <= 145) {
								// 由线程来控制进度。
								myDialog.setProgress(count++);
								Thread.sleep(100);
							}
							myDialog.cancel();
						} catch (InterruptedException e) {
							myDialog.cancel();
						}
					}
				}.start();

			}
		});

	}

	public void showmyDialog() {

		myDialog = new ProgressDialog(MainActivity.this);
		// 设置进度条风格，风格为长形
		myDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		// 设置ProgressDialog 标题
		myDialog.setTitle("提示");
		// 设置ProgressDialog 提示信息
		myDialog.setMessage("长形对话框进度条");
		// 设置ProgressDialog 标题图标
		myDialog.setIcon(R.drawable.icon);
		// 设置ProgressDialog 的进度条是否不明确
		myDialog.setIndeterminate(true);

		myDialog.setMax(145);
		// 设置ProgressDialog 是否可以按退回按键取消
		myDialog.setCancelable(true);

		// 让ProgressDialog显示
		myDialog.show();
	}
}