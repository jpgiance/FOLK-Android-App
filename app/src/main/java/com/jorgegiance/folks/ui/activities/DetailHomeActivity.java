package com.jorgegiance.folks.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.models.firebaseModels.News;
import com.jorgegiance.folks.viewmodels.DetailActivityViewModel;
import com.jorgegiance.folks.viewmodels.ItemNewsViewModel;

public class DetailHomeActivity extends AppCompatActivity implements View.OnClickListener{


    // UI components
    private AppBarLayout appBarLayout;
    private MaterialToolbar appBar;
    private ImageView userButton, homeButton, peopleButton, backButton, shareButton;


    // ViewModels
    private ItemNewsViewModel mItemNewsViewModel;
    private DetailActivityViewModel mDetailActivityViewModel;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_home);

        mItemNewsViewModel = new ViewModelProvider(this).get(ItemNewsViewModel.class);
        mDetailActivityViewModel = new ViewModelProvider(this).get(DetailActivityViewModel.class);

        Intent intent = getIntent();
        if (intent.hasExtra(getString(R.string.NEWS_KEY))){
            mDetailActivityViewModel.setSelectedNews((News) intent.getParcelableExtra(getString(R.string.NEWS_KEY)));
        }

        appBarLayout = findViewById(R.id.appBarLayout);
        appBar = findViewById(R.id.toolbar);
        userButton = findViewById(R.id.icon_user);
        homeButton = findViewById(R.id.icon_home);
        peopleButton = findViewById(R.id.icon_peopleGroup);
        backButton = findViewById(R.id.icon_back);
        shareButton = findViewById(R.id.icon_share);


       

        setIconColor();
        setListeners();

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
            case R.id.icon_back:
                this.onBackPressed();
                break;
            case R.id.icon_share:
                share();
        }
    }

    private void share() {
    }

    private void setListeners() {

        userButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
        peopleButton.setOnClickListener(this);
        backButton.setOnClickListener(this);
        shareButton.setOnClickListener(this);


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

    private void setIconColor() {

        homeButton.setColorFilter(getResources().getColor(R.color.colorAccent));
    }
}
