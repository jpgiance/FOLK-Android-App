package com.jorgegiance.folks.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;

import com.jorgegiance.folks.R;
import com.jorgegiance.folks.ui.activities.HomeActivity;

public class NotificationUtil {



    private static PendingIntent contentIntent( Context context){

        Intent startActivityIntent = new Intent(context, HomeActivity.class);
        return PendingIntent.getActivity(context, Constants.NEW_STORIES_NOTIFICATION_PENDING_INTENT_ID, startActivityIntent, PendingIntent.FLAG_UPDATE_CURRENT);

    }

    public static void setNewStoriesNotification( Context context){

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel mChannel = new NotificationChannel(
                    Constants.NEW_STORIES_NOTIFICATION_CHANNEL_ID,
                    context.getString(R.string.main_notification_channel_name),
                    NotificationManager.IMPORTANCE_HIGH);
            assert notificationManager != null;
            notificationManager.createNotificationChannel(mChannel);
        }

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context,Constants.NEW_STORIES_NOTIFICATION_CHANNEL_ID)
                .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setSmallIcon(R.mipmap.ic_launcher_widget)
                .setLargeIcon(largeIcon(context))
                .setContentTitle(context.getString(R.string.new_stories_notification_title))
                .setContentText(context.getString(R.string.new_stories_notification_body))
                .setStyle(new NotificationCompat.BigTextStyle().bigText(
                        context.getString(R.string.new_stories_notification_body)))
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setContentIntent(contentIntent(context))
                .setAutoCancel(true);


        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            notificationBuilder.setPriority(NotificationCompat.PRIORITY_HIGH);
        }

        notificationManager.notify(Constants.NEW_STORIES_NOTIFICATION_ID, notificationBuilder.build());

    }


    private static Bitmap largeIcon( Context context){

        Resources res = context.getResources();
        Bitmap largeIcon = BitmapFactory.decodeResource(res, R.mipmap.ic_launcher_widget);
        return largeIcon;

    }
}
