package com.jorgegiance.folks.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;


public class NotificationWorker extends Worker {

    private Context ctx;


    public NotificationWorker( @NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        ctx = context;
    }
    @NonNull
    @Override
    public Result doWork() {
        NotificationUtil.setNewStoriesNotification(ctx);
        initRecurrentNotification();

        return Result.success();
    }

    private void initRecurrentNotification() {

        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();

        Calendar currentDate = Calendar.getInstance();
        Calendar dueDate = Calendar.getInstance();
        // Set Execution around 07:00:00 PM
        dueDate.set(Calendar.HOUR_OF_DAY, 19);
        dueDate.set(Calendar.MINUTE, 0);
        dueDate.set(Calendar.SECOND, 0);
        if (dueDate.before(currentDate)) {
            dueDate.add(Calendar.HOUR_OF_DAY, 24);
        }
        long timeDiff = dueDate.getTimeInMillis() - currentDate.getTimeInMillis();
        OneTimeWorkRequest notificationRequest = new OneTimeWorkRequest.Builder(NotificationWorker.class)
                .setConstraints(constraints)
                .setInitialDelay(timeDiff, TimeUnit.MILLISECONDS)
                .build();

        WorkManager.getInstance().enqueueUniqueWork(Constants.NEW_STORIES_NOTIFICATION_WORK_ID
                , ExistingWorkPolicy.KEEP
                , notificationRequest);
    }

}
