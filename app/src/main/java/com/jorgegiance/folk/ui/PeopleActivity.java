package com.jorgegiance.folk.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jorgegiance.folk.HomeActivity;
import com.jorgegiance.folk.R;
import com.jorgegiance.folk.adapters.PageAdapter;

public class PeopleActivity extends AppCompatActivity implements View.OnClickListener{

    // UI components
    TabLayout tabLayout;
    ViewPager2 viewPager;
    ImageView userButton, homeButton, peopleButton;

    FragmentManager manager = getSupportFragmentManager();




    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);



        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.people_viewPager);
        userButton = findViewById(R.id.icon_user);
        homeButton = findViewById(R.id.icon_home);
        peopleButton = findViewById(R.id.icon_peopleGroup);


        setIconColor();


        PageAdapter pagerAdapter = new PageAdapter(this);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setUserInputEnabled(false);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab( @NonNull TabLayout.Tab tab, int position ) {
                 switch (position){
                     case 0:
                         tab.setText(R.string.tab_executive);
                         break;
                     case 1:
                         tab.setText(R.string.tab_legislative);
                         break;
                     case 2:
                         tab.setText(R.string.tab_judicial);
                         break;
                 }
            }
        });
        tabLayoutMediator.attach();

        setListeners();

    }

    private void setIconColor() {

        peopleButton.setColorFilter(getResources().getColor(R.color.colorAccent));
    }

    private void setListeners() {

        userButton.setOnClickListener(this);
        homeButton.setOnClickListener(this);
        peopleButton.setOnClickListener(this);


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
    }

    private void transitionToUserScreen() {
    }
}
