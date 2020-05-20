package com.jorgegiance.folks.ui.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.AppWidgetTarget;
import com.bumptech.glide.request.transition.Transition;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.models.firebaseModels.Page;
import com.jorgegiance.folks.ui.activities.HomeActivity;
import com.jorgegiance.folks.util.Constants;
import com.jorgegiance.folks.util.WidgetUpdateWorker;

/**
 * Implementation of App Widget functionality.
 */
public class TopStoriesWidget extends AppWidgetProvider  {

    private static int articleIndex = 1;
    private static Page mPage;


    public static void updateAppWidget( Context context, AppWidgetManager appWidgetManager,
                                        int appWidgetId, Page page ) {


        mPage = page;
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.top_stories_widget);

        // Create an Intent to launch the HomeActivity when clicked
        Intent intent = new Intent(context, HomeActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        views.setOnClickPendingIntent(R.id.article_container, pendingIntent);

        views.setOnClickPendingIntent(R.id.next_article_button,
                getPendingSelfIntent(context, Constants.NEXT_ARTICLE_ACTION_ID));

        views.setOnClickPendingIntent(R.id.previous_article_button,
                getPendingSelfIntent(context, Constants.PREVIOUS_ARTICLE_ACTION_ID));



        //views.setTextViewText(R.id.article_body, page.getItems().get(articleIndex).getNews().get(0).getTitle());
        views.setTextViewText(R.id.article_body, String.valueOf(articleIndex));

        AppWidgetTarget appWidgetTarget = new AppWidgetTarget(context, R.id.article_poster, views, appWidgetId){

            @Override
            public void onResourceReady( @NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition ) {
                super.onResourceReady(resource, transition);
            }
        };

        Glide
                .with(context.getApplicationContext())
                .asBitmap()
                .load(page.getItems().get(articleIndex).getNews().get(0).getPhotoUrl())
                .into(appWidgetTarget);




        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }



    @Override
    public void onUpdate( Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds ) {


        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();

        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(WidgetUpdateWorker.class)
                .setConstraints(constraints)
                .build();

        WorkManager.getInstance().enqueueUniqueWork(Constants.TOP_STORIES_WIDGET_WORK_ID
                , ExistingWorkPolicy.REPLACE
                , request);
    }

    @Override
    public void onEnabled( Context context ) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled( Context context ) {
        // Enter relevant functionality for when the last widget is disabled
    }

    protected static PendingIntent getPendingSelfIntent( Context context, String action ) {
        Intent intent = new Intent(context, TopStoriesWidget.class);
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    @Override
    public void onReceive( Context context, Intent intent ) {
        super.onReceive(context, intent);

        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
        int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(context, TopStoriesWidget.class));

        if (Constants.NEXT_ARTICLE_ACTION_ID.equals(intent.getAction())){

            if (mPage != null ){
                int index = articleIndex + 1;
                if (mPage.getItems().size() > index){
                    if (mPage.getItems().get(index).getNews() != null){
                        articleIndex = index;

                        for (int appWidgetId : appWidgetIds) {
                            TopStoriesWidget.updateAppWidget(context, appWidgetManager, appWidgetId, mPage);
                        }
                    }
                }


            }
        }else if (Constants.PREVIOUS_ARTICLE_ACTION_ID.equals(intent.getAction())){
            if (mPage != null && articleIndex > 0){
                int index = articleIndex - 1;
                if (mPage.getItems().get(index).getNews() != null){
                    articleIndex = index;

                    for (int appWidgetId : appWidgetIds) {
                        TopStoriesWidget.updateAppWidget(context, appWidgetManager, appWidgetId, mPage);
                    }
                }

            }
        }
    }


}

