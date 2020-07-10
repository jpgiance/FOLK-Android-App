package com.jorgegiance.folks.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.work.Constraints;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.adapters.HomeAdapter;
import com.jorgegiance.folks.models.firebaseModels.Item;
import com.jorgegiance.folks.models.firebaseModels.News;
import com.jorgegiance.folks.models.firebaseModels.Page;
import com.jorgegiance.folks.util.Constants;
import com.jorgegiance.folks.util.NotificationWorker;
import com.jorgegiance.folks.viewmodels.HomeActivityViewModel;
import com.jorgegiance.folks.viewmodels.ItemNewsViewModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, HomeAdapter.OnClickHandler {

    public static final int RC_SIGN_IN = 1;
    private static final String TAG = "TAG";
    private boolean isLoading = false;

    // UI components
    private ProgressBar mProgressBar;
    private ImageView topButton;
    private CoordinatorLayout coordinatorLayout;
    private TextView userButton, homeButton, peopleButton;

    private HomeAdapter adapter;
    private RecyclerView recycler;


    private ItemNewsViewModel mItemNewsViewModel;
    private HomeActivityViewModel mHomeActivityViewModel;

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        mHomeActivityViewModel = new ViewModelProvider(this).get(HomeActivityViewModel.class);


        mFirebaseAuth = FirebaseAuth.getInstance();

        userButton = findViewById(R.id.icon_user);
        homeButton = findViewById(R.id.icon_home);
        peopleButton = findViewById(R.id.icon_peopleGroup);
        mProgressBar = findViewById(R.id.home_progressBar);
        //topButton = findViewById(R.id.icon_top_arrow);
        coordinatorLayout = findViewById(R.id.home_coordinator_layout);





        setIconColor();

        recycler = findViewById(R.id.feed_recycler);
        adapter = new HomeAdapter(this, this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);

        setListeners();




    }

    private void initRecurrentNotification() {

//
//        WorkManager mWorkManager = WorkManager.getInstance();
        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .build();
//
//        PeriodicWorkRequest notificationRequest =
//                new PeriodicWorkRequest.Builder(NotificationWorker.class, 15, TimeUnit.MINUTES)
//                        .setConstraints(constraints)
//                        .build();
//
//
//
//        mWorkManager.enqueueUniquePeriodicWork(Constants.NEW_STORIES_NOTIFICATION_WORK_ID
//                , ExistingPeriodicWorkPolicy.KEEP
//                , notificationRequest);
//




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



     //   WorkManager.getInstance().enqueue(notificationRequest2);
        WorkManager.getInstance().enqueueUniqueWork(Constants.NEW_STORIES_NOTIFICATION_WORK_ID
                , ExistingWorkPolicy.KEEP
                , notificationRequest);
    }

    private void observeLastPage() {
        mItemNewsViewModel = new ViewModelProvider(this).get(ItemNewsViewModel.class);
        Log.d(TAG, "observeLastPage: check");
        mHomeActivityViewModel.setCurrentPage(Constants.INITIAL_CURRENT_PAGE);
        mItemNewsViewModel.getLastPage().observe(this, new Observer<Long>() {
            @Override
            public void onChanged( Long lastPage ) {
                Log.d(TAG, "onChanged: check");
                if (lastPage != null){
                    if (mHomeActivityViewModel.getCurrentPage().getValue() == Constants.INITIAL_CURRENT_PAGE){
                        mHomeActivityViewModel.setCurrentPage(lastPage);
                        loadPage(lastPage);
                    }else{
                        // Show notification "New stories"
                        Log.d(TAG, "onChanged: ERRRRRRRRRORRRRRRR");
                        showSnackbarNewStories(lastPage);
                    }

                }
            }
        });
    }

    private void showSnackbarNewStories( final Long lastPage ) {
        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, getString(R.string.snackbar_title), Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(R.string.snackbar_action), new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mHomeActivityViewModel.setCurrentPage(lastPage);
                        loadPage(lastPage);
                    }
                });

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) snackbar.getView().getLayoutParams();
        layoutParams.setAnchorId(R.id.home_bottom_navigation);//Id for your bottomNavBar or TabLayout
        layoutParams.anchorGravity = Gravity.TOP;
        layoutParams.gravity = Gravity.TOP;
        snackbar.getView().setLayoutParams(layoutParams);

        snackbar.show();
    }

    private void loadPage( final long pageNumber ) {
        mProgressBar.setVisibility(View.VISIBLE);

        mItemNewsViewModel.getPage(pageNumber).observe(this, new Observer<Page>() {
            @Override
            public void onChanged( Page page ) {
                Log.d(TAG, "onChanged: check");
                if (page != null){
                    if (mHomeActivityViewModel.getCurrentPage().getValue() == pageNumber){
                        adapter.setHomeItemsList((ArrayList<Item>) page.getItems());
                    }else {
                        adapter.addToHomeItemList((ArrayList<Item>) page.getItems());
                        mHomeActivityViewModel.setCurrentPage(pageNumber);
                    }

                    mProgressBar.setVisibility(View.GONE);
                    isLoading = false;
                }
            }
        });
    }

    private void setIconColor() {

        homeButton.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        for (Drawable drawable : homeButton.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(this, R.color.colorAccent), PorterDuff.Mode.SRC_IN));
            }
        }
    }

    private void setListeners() {

        userButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
        peopleButton.setOnClickListener(this);
       // topButton.setOnClickListener(this);

        adapter.addOnBottomReachedListener(new HomeAdapter.OnBottomReachedListener() {
            @Override
            public void onBottomReached( int position ) {

               if ( mHomeActivityViewModel.getCurrentPage() != null) {
                   if (mHomeActivityViewModel.getCurrentPage().getValue() > 0) {
                       loadPage(mHomeActivityViewModel.getCurrentPage().getValue() - 1);
                   }
               }
            }
        });

        recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged( @NonNull RecyclerView recyclerView, int newState ) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled( @NonNull RecyclerView recyclerView, int dx, int dy ) {
                super.onScrolled(recyclerView, dx, dy);

                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                if (!isLoading) {
                    if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() == adapter.getItemCount() - 1) {
                        //bottom of list!
                        loadMore();
                        isLoading = true;
                    }
                }
            }

            private void loadMore() {
                if ( mHomeActivityViewModel.getCurrentPage() != null) {
                    if (mHomeActivityViewModel.getCurrentPage().getValue() > 0) {
                        loadPage(mHomeActivityViewModel.getCurrentPage().getValue() - 1);
                    }
                }
            }
        });

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged( @NonNull FirebaseAuth firebaseAuth ) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null){
                    // user is signed in
                    Log.d(TAG, "onAuthStateChanged: signed in");
                    onSignedInInitialize(user.getDisplayName());
                }else{
                    // user is signed out
                    Log.d(TAG, "onAuthStateChanged: signed out");
                    onSignedOutCleanup();
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setIsSmartLockEnabled(false)
                                    .setAvailableProviders(Arrays.asList(
                                            new AuthUI.IdpConfig.GoogleBuilder().build(),
                                            new AuthUI.IdpConfig.EmailBuilder().build(),
                                            new AuthUI.IdpConfig.AnonymousBuilder().build()))
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };



    }

    private void onSignedOutCleanup() {
        Log.d(TAG, "onSignedOutCleanup: check");
        WorkManager.getInstance().cancelAllWork();
    }

    private void onSignedInInitialize( String displayName ) {
        Log.d(TAG, "onSignedInInitialize: check");
        mProgressBar.setVisibility(View.VISIBLE);
        observeLastPage();
        initRecurrentNotification();
        Log.d(TAG, "onSignedInInitialize: check after");

    }

    @Override
    public void onClick( View v ) {
        switch (v.getId()){
            case R.id.icon_user:
                transitionToUserScreen();
                break;
            case R.id.icon_home:
                transitionToHomeScreen();
                break;
            case R.id.icon_peopleGroup:
                transitionToPeopleScreen();
                break;
//            case R.id.icon_top_arrow:
//                transitionToTopScreen();
//                break;
        }
    }

    private void transitionToTopScreen() {
        RecyclerView.SmoothScroller smoothScroller = new LinearSmoothScroller(this) {
            @Override protected int getVerticalSnapPreference() {
                return LinearSmoothScroller.SNAP_TO_START;
            }
        };

        smoothScroller.setTargetPosition(0);
        Objects.requireNonNull(recycler.getLayoutManager()).startSmoothScroll(smoothScroller);
    }

    private void transitionToHomeScreen() {
    }

    private void transitionToPeopleScreen() {
        Intent peopleIntent = new Intent(this, PeopleActivity.class);
        startActivity(peopleIntent);
    }

    private void transitionToUserScreen() {
        Intent userIntent = new Intent(this, UserActivity.class);
        startActivity(userIntent);
    }


    @Override
    public void onItemClicked( News news ) {
        Intent detailIntent = new Intent(this, DetailHomeActivity.class);
        detailIntent.putExtra(getResources().getString(R.string.NEWS_KEY), news);
        startActivity(detailIntent);
    }


    @Override
    protected void onPause() {
        super.onPause();
        if (mAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
        }

        Log.d(TAG, "onPause: Check");

    }

    @Override
    protected void onResume() {
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
        Log.d(TAG, "onResume: Check");


    }



}
