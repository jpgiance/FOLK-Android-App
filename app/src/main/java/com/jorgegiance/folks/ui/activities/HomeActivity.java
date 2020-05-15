package com.jorgegiance.folks.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.adapters.HomeAdapter;
import com.jorgegiance.folks.models.firebaseModels.Item;
import com.jorgegiance.folks.models.firebaseModels.News;
import com.jorgegiance.folks.models.firebaseModels.Page;
import com.jorgegiance.folks.util.Constants;
import com.jorgegiance.folks.viewmodels.HomeActivityViewModel;
import com.jorgegiance.folks.viewmodels.ItemNewsViewModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, HomeAdapter.HomeAdapterOnClickHandler {

    // UI components
    private ProgressBar mProgressBar;
    private ImageView userButton, homeButton, peopleButton, topButton;

    private HomeAdapter adapter;
    private RecyclerView recycler;


    private ItemNewsViewModel mItemNewsViewModel;
    private HomeActivityViewModel mHomeActivityViewModel;

//    private FirebaseAuth mFirebaseAuth;
//    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mItemNewsViewModel = new ViewModelProvider(this).get(ItemNewsViewModel.class);
        mHomeActivityViewModel = new ViewModelProvider(this).get(HomeActivityViewModel.class);


//        mFirebaseAuth = FirebaseAuth.getInstance();

        userButton = findViewById(R.id.icon_user);
        homeButton = findViewById(R.id.icon_home);
        peopleButton = findViewById(R.id.icon_peopleGroup);
        mProgressBar = findViewById(R.id.home_progressBar);
        topButton = findViewById(R.id.icon_top_arrow);





        setIconColor();

        recycler = findViewById(R.id.feed_recycler);
        adapter = new HomeAdapter(this, this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);

        setListeners();

        mProgressBar.setVisibility(View.VISIBLE);
        observeLastPage();

    }



    private void observeLastPage() {
        mHomeActivityViewModel.setCurrentPage(Constants.initialCurrentPage);
        mItemNewsViewModel.getLastPage().observe(this, new Observer<Long>() {
            @Override
            public void onChanged( Long lastPage ) {

                if (lastPage != null){
                    if (mHomeActivityViewModel.getCurrentPage().getValue() == Constants.initialCurrentPage){
                        mHomeActivityViewModel.setCurrentPage(lastPage);
                        loadPage(lastPage);
                    }else{
                        // Show notification "New stories"
                    }

                }
            }
        });
    }

    private void loadPage( final long pageNumber ) {
        mProgressBar.setVisibility(View.VISIBLE);

        mItemNewsViewModel.getPage(pageNumber).observe(this, new Observer<Page>() {
            @Override
            public void onChanged( Page page ) {
                if (page != null){
                    if (mHomeActivityViewModel.getCurrentPage().getValue() == pageNumber){
                        adapter.setHomeItemsList((ArrayList<Item>) page.getItems());
                    }else {
                        adapter.addToHomeItemList((ArrayList<Item>) page.getItems());
                        mHomeActivityViewModel.setCurrentPage(pageNumber);
                    }

                    mProgressBar.setVisibility(View.GONE);
                }
            }
        });
    }


    private void setIconColor() {

        homeButton.setColorFilter(getResources().getColor(R.color.colorAccent));
    }

    private void setListeners() {

        userButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
        peopleButton.setOnClickListener(this);
        topButton.setOnClickListener(this);

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
            case R.id.icon_top_arrow:
                transitionToTopScreen();
                break;
        }
    }

    private void transitionToTopScreen() {
        recycler.getLayoutManager().scrollToPosition(0);
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
}
