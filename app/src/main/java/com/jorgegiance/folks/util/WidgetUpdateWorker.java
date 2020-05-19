package com.jorgegiance.folks.util;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jorgegiance.folks.models.firebaseModels.Page;
import com.jorgegiance.folks.ui.widget.TopStoriesWidget;

public class WidgetUpdateWorker extends Worker {

    private Context ctx;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mLastPageReference;
    private DatabaseReference mPageReference;

    public WidgetUpdateWorker( @NonNull Context context, @NonNull WorkerParameters workerParams ) {
        super(context, workerParams);
        ctx = context;
        mFirebaseDatabase = FirebaseDatabase.getInstance();
    }

    @NonNull
    @Override
    public Result doWork() {

        final long[] lastPageNumber = new long[1];
        mLastPageReference = mFirebaseDatabase.getReference().child("pages").child("last");
        mLastPageReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( @NonNull DataSnapshot dataSnapshot ) {
                lastPageNumber[0] = (long) dataSnapshot.getValue();
                fetchLastPage(lastPageNumber[0]);
            }

            @Override
            public void onCancelled( @NonNull DatabaseError databaseError ) {

            }
        });



        return Result.success();
    }

    private void fetchLastPage( long l ) {

        final Page[] page = {new Page()};
        mPageReference = mFirebaseDatabase.getReference().child("pages").child(String.valueOf(l));
        mPageReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( @NonNull DataSnapshot dataSnapshot ) {
                page[0] = dataSnapshot.getValue(Page.class);

                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(ctx);
                int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(ctx, TopStoriesWidget.class));

                for (int appWidgetId : appWidgetIds) {
                    TopStoriesWidget.updateAppWidget(ctx, appWidgetManager, appWidgetId, page[0]);
                }

            }

            @Override
            public void onCancelled( @NonNull DatabaseError databaseError ) {

            }
        });
    }
}
