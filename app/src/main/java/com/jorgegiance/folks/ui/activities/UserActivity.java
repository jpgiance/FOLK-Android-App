package com.jorgegiance.folks.ui.activities;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import com.firebase.ui.auth.AuthUI;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayoutMediator;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.adapters.PagerAdapter;


public class UserActivity extends AppCompatActivity implements View.OnClickListener{

    // UI components
    AppBarLayout appBarLayout;
    ViewPager2 viewPager;
    TabLayout tabs;
    TextView logOut;
    private TextView userButton, homeButton, peopleButton;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        viewPager = findViewById(R.id.detail_view_pager);
        tabs = findViewById(R.id.tabs);
        userButton = findViewById(R.id.icon_user);
        homeButton = findViewById(R.id.icon_home);
        peopleButton = findViewById(R.id.icon_peopleGroup);
        logOut = findViewById(R.id.log_out);


        PagerAdapter userPagerAdapter = new PagerAdapter(this, this, true, false, false, false);
        viewPager.setAdapter(userPagerAdapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabs, viewPager, new TabLayoutMediator.TabConfigurationStrategy(){


            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onConfigureTab( @NonNull TabLayout.Tab tab, int position ) {
                switch (position){
                    case 0:
                        tab.setText(R.string.tab_profile);
                        tab.setIcon(R.drawable.ic_person_profile);
                        tab.getIcon().setTint(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
                        break;
                    case 1:
                        tab.setText(R.string.tab_following);
                        tab.setIcon(R.drawable.ic_star_following);
                        break;
                    case 2:
                        tab.setText(R.string.tab_settings);
                        tab.setIcon(R.drawable.ic_settings_user);
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
        logOut.setOnClickListener(this);

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTabSelected( TabLayout.Tab tab ) {
                tab.getIcon().setTint(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTabUnselected( TabLayout.Tab tab ) {
                tab.getIcon().setTint(ContextCompat.getColor(getApplicationContext(), R.color.colorWhite));

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
            case R.id.log_out:
                AuthUI.getInstance().signOut(this);
                finish();
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

        userButton.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        for (Drawable drawable : userButton.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(this, R.color.colorAccent), PorterDuff.Mode.SRC_IN));
            }
        }

    }
}