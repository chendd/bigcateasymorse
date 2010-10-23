package simple.demo;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MySearchActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button button = (Button) findViewById(R.id.mybutton);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				onSearchRequested();
				Intent intent = getIntent();				
				if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
					String query = intent.getStringExtra(SearchManager.QUERY);
					//得到输入要搜索的内容，然后进行分析展示
					Log.v("name>>>", "-----" + query);
				}

			}
		});
	}
}