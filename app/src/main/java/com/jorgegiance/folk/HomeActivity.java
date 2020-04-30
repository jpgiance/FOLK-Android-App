package com.jorgegiance.folk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.jorgegiance.folk.adapters.HomeAdapter;
import com.jorgegiance.folk.ui.PeopleActivity;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    // UI components
    AppBarLayout appBarLayout;
    MaterialToolbar appBar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    ImageView userButton, homeButton, peopleButton, collapseingImg;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        appBarLayout = findViewById(R.id.appBarLayout);
        appBar = findViewById(R.id.toolbar);
        userButton = findViewById(R.id.icon_user);
        homeButton = findViewById(R.id.icon_home);
        peopleButton = findViewById(R.id.icon_peopleGroup);
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
        collapseingImg = findViewById(R.id.head_image);

        appBar.setVisibility(View.GONE);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {

            @Override
            public void onOffsetChanged( AppBarLayout appBarLayout, int verticalOffset ) {

                if ( Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()-appBar.getHeight()){

                    appBar.setVisibility(View.VISIBLE);
                }else{

                    appBar.setVisibility(View.GONE);
                };


            }
        });



        setIconColor();

        RecyclerView recycler = findViewById(R.id.feed_recycler);
        HomeAdapter adapter = new HomeAdapter(this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);

        setListeners();

    }


    private void setIconColor() {

        homeButton.setColorFilter(getResources().getColor(R.color.colorAccent));
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
        Intent homeIntent = new Intent(this, PeopleActivity.class);
        startActivity(homeIntent);
    }

    private void transitionToUserScreen() {
    }
}
