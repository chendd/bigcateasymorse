package com.iweigame.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * 
* @ClassName: LockWidgetProvider
* @Description: 描述 
* @author:jiessiedyh@gmail.com

*
 */

public class LockWidgetProvider extends AppWidgetProvider {
	private static final String CLICK_NAME_ACTION = "com.terry.action.widget.click";

	private static RemoteViews rv;

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		final int N = appWidgetIds.length;
		for (int i = 0; i < N; i++) {
			int appWidgetId = appWidgetIds[i];
			updateAppWidget(context, appWidgetManager, appWidgetId);
		}
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);

		if (rv == null) {
			rv = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
		}
		if (intent.getAction().equals(CLICK_NAME_ACTION)) {

			new LockUtil().lock(context);

			Util.isChange = !Util.isChange;

		}
		AppWidgetManager appWidgetManger = AppWidgetManager
				.getInstance(context);
		int[] appIds = appWidgetManger.getAppWidgetIds(new ComponentName(
				context, LockWidgetProvider.class));
		appWidgetManger.updateAppWidget(appIds, rv);
	}

	public static void updateAppWidget(Context context,
			AppWidgetManager appWidgeManger, int appWidgetId) {
		rv = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
		Intent intentClick = new Intent(CLICK_NAME_ACTION);
		PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0,
				intentClick, 0);
		rv.setOnClickPendingIntent(R.id.TextView01, pendingIntent);
		appWidgeManger.updateAppWidget(appWidgetId, rv);
	}
}