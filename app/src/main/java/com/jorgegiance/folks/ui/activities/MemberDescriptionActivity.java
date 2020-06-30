package com.jorgegiance.folks.ui.activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.adapters.PagerAdapter;

public class MemberDescriptionActivity extends AppCompatActivity implements View.OnClickListener{

    // UI components
    AppBarLayout appBarLayout;
    ViewPager2 viewPager;
    TabLayout tabs;
    ImageView userButton, homeButton, peopleButton, backButton;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_description);

        viewPager = findViewById(R.id.members_view_pager);
        tabs = findViewById(R.id.members_tabs);
        userButton = findViewById(R.id.icon_user);
        homeButton = findViewById(R.id.icon_home);
        peopleButton = findViewById(R.id.icon_peopleGroup);
        backButton = findViewById(R.id.icon_back_member_description);


        PagerAdapter userPagerAdapter = new PagerAdapter(this, this, false, false, true, false);
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
                        tab.setText("Media");
                        tab.setIcon(R.drawable.ic_cloud_black_24dp);
                        break;
                    case 2:
                        tab.setText("Comments");
                        tab.setIcon(R.drawable.ic_comment_black_24dp);
                        break;
                }
            }
        });
        tabLayoutMediator.attach();

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
            case R.id.icon_back_member_description:
                this.onBackPressed();
                break;

        }
    }

    private void setListeners() {

        userButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
        peopleButton.setOnClickListener(this);
        backButton.setOnClickListener(this);

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

    private void transitionToHomeScreen() {
        Intent homeIntent = new Intent(this, HomeActivity.class);
        startActivity(homeIntent);
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

        userButton.setColorFilter(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
    }
}
