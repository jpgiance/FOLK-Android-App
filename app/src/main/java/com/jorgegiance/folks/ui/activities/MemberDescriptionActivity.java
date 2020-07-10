package com.jorgegiance.folks.ui.activities;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.adapters.PagerAdapter;
import com.jorgegiance.folks.models.Person;
import com.jorgegiance.folks.util.Utilities;
import com.jorgegiance.folks.viewmodels.MemberDescriptionActivityViewModel;


public class MemberDescriptionActivity extends AppCompatActivity implements View.OnClickListener{

    // UI components
    private Toolbar appBarLayout;
    private ViewPager2 viewPager;
    private TabLayout tabs;
    private ImageView backButton, memberPhoto;
    private TextView userButton, homeButton, peopleButton;
    private ActionMenuItemView followingButton;


    // ViewModels
    private MemberDescriptionActivityViewModel mMemberViewModel;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_description);

        mMemberViewModel = new ViewModelProvider(this).get(MemberDescriptionActivityViewModel.class);

        Intent intent = getIntent();
        if (intent.hasExtra("member")){
            mMemberViewModel.setPerson((Person) intent.getParcelableExtra("member"));
        }

        viewPager = findViewById(R.id.members_view_pager);
        tabs = findViewById(R.id.members_tabs);
        userButton = findViewById(R.id.icon_user);
        homeButton = findViewById(R.id.icon_home);
        peopleButton = findViewById(R.id.icon_peopleGroup);
        backButton = findViewById(R.id.icon_back_member_description);
        memberPhoto = findViewById(R.id.member_photo);
        followingButton = findViewById(R.id.icon_following);
        appBarLayout = findViewById(R.id.member_description_app_bar);

        setSupportActionBar(appBarLayout);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

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

        Glide.with(this)
                .load(mMemberViewModel.getPerson().getPhotoUrl())
                .centerCrop()
                .placeholder(R.drawable.ic_person)
                .into(memberPhoto);

    }

    @Override
    public boolean onCreateOptionsMenu( Menu menu ) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_members_description, menu);

        return true;
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

    @Override
    public boolean onOptionsItemSelected( @NonNull MenuItem item ) {
        switch (item.getItemId()) {
            case R.id.official_website: {
                String url = "https://abraham.house.gov";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                if (true && i.resolveActivity(this.getPackageManager()) != null) {
                    this.startActivity(i);
                } else {

                    Toast.makeText(this,
                            "no URL found",
                            Toast.LENGTH_LONG)
                            .show();

                }
                return true;
            }
            case R.id.contact_form: {
                String url = "";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                if (true && i.resolveActivity(this.getPackageManager()) != null) {
                    this.startActivity(i);
                } else {

                    Toast.makeText(this,
                            "no URL found",
                            Toast.LENGTH_LONG)
                            .show();

                }
                return true;
            }
            case R.id.govtrack_link: {
                String url = "https://www.govtrack.us/congress/members/ralph_abraham/412630";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                if (true && i.resolveActivity(this.getPackageManager()) != null) {
                    this.startActivity(i);
                } else {

                    Toast.makeText(this,
                            "no URL found",
                            Toast.LENGTH_LONG)
                            .show();

                }
                return true;
            }
            case R.id.wiki_link: {
                String url = "https://en.wikipedia.org/wiki/Ralph_Abraham_(politician)";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                if (true && i.resolveActivity(this.getPackageManager()) != null) {
                    this.startActivity(i);
                } else {

                    Toast.makeText(this,
                            "no URL found",
                            Toast.LENGTH_LONG)
                            .show();

                }
                return true;
            }

            default:
                return super.onOptionsItemSelected(item);
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

        peopleButton.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        for (Drawable drawable : peopleButton.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(this, R.color.colorAccent), PorterDuff.Mode.SRC_IN));
            }
        }
    }
}
