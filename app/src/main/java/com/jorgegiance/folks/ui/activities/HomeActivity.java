package com.jorgegiance.folks.ui.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.adapters.HomeAdapter;
import com.jorgegiance.folks.models.firebaseModels.Item;
import com.jorgegiance.folks.models.firebaseModels.News;
import com.jorgegiance.folks.models.firebaseModels.Page;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, HomeAdapter.HomeAdapterOnClickHandler {

    // UI components
    private AppBarLayout appBarLayout;
    private MaterialToolbar appBar;
    private ContentLoadingProgressBar mProgressBar;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView userButton, homeButton, peopleButton;

    private HomeAdapter adapter;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mLatestPageReference;
    private ChildEventListener mChildEventListener;
    private ValueEventListener lastValueListener;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize Firebase components
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();


        mLatestPageReference = mFirebaseDatabase.getReference().child("pages").child("last");

        appBarLayout = findViewById(R.id.appBarLayout);
        appBar = findViewById(R.id.toolbar);
        userButton = findViewById(R.id.icon_user);
        homeButton = findViewById(R.id.icon_home);
        peopleButton = findViewById(R.id.icon_peopleGroup);
        collapsingToolbarLayout = findViewById(R.id.collapsingToolbarLayout);
        mProgressBar = findViewById(R.id.home_progressBar);

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
        adapter = new HomeAdapter(this, this);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setHasFixedSize(true);

        setListeners();

        lastValueListener = new ValueEventListener() {
            @Override
            public void onDataChange( @NonNull DataSnapshot dataSnapshot ) {
                Long lastPage = (Long) dataSnapshot.getValue();
                loadPage(lastPage);
            }

            @Override
            public void onCancelled( @NonNull DatabaseError databaseError ) {

            }
        };
        mLatestPageReference.addValueEventListener(lastValueListener);

    }

    private void loadPage( long lastPage ) {
        DatabaseReference mPageDatabaseReference = mFirebaseDatabase.getReference().child("pages").child(String.valueOf(lastPage));

        mPageDatabaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( @NonNull DataSnapshot dataSnapshot ) {
                Page homePage = dataSnapshot.getValue(Page.class);

                adapter.setHomeItemsList((ArrayList<Item>) homePage.getItems());
            }

            @Override
            public void onCancelled( @NonNull DatabaseError databaseError ) {

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
