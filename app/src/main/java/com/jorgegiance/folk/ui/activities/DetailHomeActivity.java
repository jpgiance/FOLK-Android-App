package com.jorgegiance.folk.ui.activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.os.Build;
import android.os.Bundle;
import android.transition.Visibility;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jorgegiance.folk.R;
import com.jorgegiance.folk.adapters.DetailPagerAdapter;
import com.jorgegiance.folk.viewmodels.ItemNewsViewModel;

public class DetailHomeActivity extends AppCompatActivity implements View.OnClickListener{


    // UI components
    AppBarLayout appBarLayout;
    MaterialToolbar appBar;
    ImageView userButton, homeButton, peopleButton, backButton, shareButton;


    // ViewModels
    ItemNewsViewModel itemNewsViewModel;


    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_home);

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
