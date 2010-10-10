package com.easymorse;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;




public class Activity1 extends Activity {
	
	private static final int MENU1 = 1;
	private static final int MENU2 = 2;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mymain);       
    }
    /* Creates the menu items */
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU1, 1, "设置1");
        menu.add(0, MENU2, 2, "设置2").setIcon(R.drawable.icon);
        menu.add(0, MENU1, 3, "设置3");
        menu.add(0, MENU2, 4, "设置4").setIcon(R.drawable.icon);
        menu.add(0, MENU1, 5, "设置5");
        menu.add(0, MENU2, 6, "设置6").setIcon(R.drawable.icon);
        menu.add(0, MENU1, 7, "设置7");
        menu.add(0, MENU2, 8, "设置8").setIcon(R.drawable.icon);
        menu.add(0, MENU1, 9, "设置9");
        menu.add(0, MENU2, 10, "设置10").setIcon(R.drawable.icon);
        return true;
    }

    /* Handles item selections */
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case MENU1:
            return true;
        case MENU2:
            return true;
        }
        return false;
    }
}