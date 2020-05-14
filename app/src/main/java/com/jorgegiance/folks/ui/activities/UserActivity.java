package com.jorgegiance.folks.ui.activities;

import android.content.Intent;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.viewpager2.widget.ViewPager2;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayoutMediator;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.adapters.UserPagerAdapter;



public class UserActivity extends AppCompatActivity implements View.OnClickListener{

    // UI components
    AppBarLayout appBarLayout;
    ViewPager2 viewPager;
    TabLayout tabs;
    ImageView userButton, homeButton, peopleButton;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        viewPager = findViewById(R.id.detail_view_pager);
        tabs = findViewById(R.id.tabs);
        userButton = findViewById(R.id.icon_user);
        homeButton = findViewById(R.id.icon_home);
        peopleButton = findViewById(R.id.icon_peopleGroup);


        UserPagerAdapter userPagerAdapter = new UserPagerAdapter(this, this);
        viewPager.setAdapter(userPagerAdapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabs, viewPager, new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab( @NonNull TabLayout.Tab tab, int position ) {
                switch (position){
                    case 0:
                        tab.setText(R.string.tab_profile);
                        tab.setIcon(R.drawable.ic_person_profile);
                        tab.getIcon().setColorFilter(new BlendModeColorFilter(getResources().getColor(R.color.colorAccent), BlendMode.SRC_ATOP));
                        break;
                    case 1:
                        tab.setText(R.string.tab_following);
                        tab.setIcon(R.drawable.ic_star_following);
                    //    tab.getIcon().setColorFilter(new BlendModeColorFilter(getResources().getColor(R.color.colorAccent), BlendMode.SRC_ATOP));
                        break;
                    case 2:
                        tab.setText(R.string.tab_settings);
                        tab.setIcon(R.drawable.ic_settings_user);
                    //    tab.getIcon().setColorFilter(new BlendModeColorFilter(getResources().getColor(R.color.colorAccent), BlendMode.SRC_ATOP));
                        break;
                }
            }
        });
        tabLayoutMediator.attach();

        setIconColor();
        setListeners();
    }


    private void setListeners() {

        userButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
        peopleButton.setOnClickListener(this);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected( TabLayout.Tab tab ) {
                tab.getIcon().setColorFilter(new BlendModeColorFilter(getResources().getColor(R.color.colorAccent), BlendMode.SRC_ATOP));
            }

            @Override
            public void onTabUnselected( TabLayout.Tab tab ) {
                tab.getIcon().setColorFilter(new BlendModeColorFilter(getResources().getColor(R.color.colorWhite), BlendMode.SRC_ATOP));

            }

            @Override
            public void onTabReselected( TabLayout.Tab tab ) {

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
        }
    }

    private void transitionToHomeScreen() {
        Intent homeIntent = new Intent(this, HomeActivity.class);
        startActivity(homeIntent);
    }

    private void transitionToPeopleScreen() {
        Intent peopleIntent = new Intent(this, PeopleActivity.class);
        startActivity(peopleIntent);
    }

    private void transitionToUserScreen() {
    }

    private void setIconColor() {

        userButton.setColorFilter(getResources().getColor(R.color.colorAccent));
    }
}