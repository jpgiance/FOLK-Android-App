package com.jorgegiance.folk.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jorgegiance.folk.R;
import com.jorgegiance.folk.adapters.PageAdapter;

public class PeopleActivity extends AppCompatActivity {

    // UI components
    TabLayout tabLayout;
    ViewPager2 viewPager;




    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_people);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.people_viewPager);



        PageAdapter pagerAdapter = new PageAdapter(this);
        viewPager.setAdapter(pagerAdapter);

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

    private void setListeners() {




    }
}
