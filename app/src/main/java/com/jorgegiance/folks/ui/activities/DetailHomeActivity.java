package com.jorgegiance.folks.ui.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.models.firebaseModels.News;
import com.jorgegiance.folks.viewmodels.DetailActivityViewModel;
import com.jorgegiance.folks.viewmodels.ItemNewsViewModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

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

        // Get access to bitmap image from view
        ImageView image = (ImageView) findViewById(R.id.news_poster);
        // Get access to the URI for the bitmap
        Uri bmpUri = getLocalBitmapUri(image);
        if (bmpUri != null) {
            // Construct a ShareIntent with link to image
            Intent shareIntent = new Intent();
            shareIntent.setAction(Intent.ACTION_SEND);
            shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
            shareIntent.setType("image/*");
            // Launch sharing dialog for image
            startActivity(Intent.createChooser(shareIntent, "Share Image"));
        } else {
            // ...sharing failed, handle error
        }

        String text = mDetailActivityViewModel.getSelectedNews().getTitle();
        Uri imageUri = Uri.parse(mDetailActivityViewModel.getSelectedNews().getPhotoUrl());
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, text);
        shareIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
        shareIntent.setType("image/*");
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(shareIntent, "Share images..."));
    }

    // Returns the URI path to the Bitmap displayed in specified ImageView
    public Uri getLocalBitmapUri(ImageView imageView) {
        // Extract Bitmap from ImageView drawable
        Drawable drawable = imageView.getDrawable();
        Bitmap bmp = null;
        if (drawable instanceof BitmapDrawable){
            bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        } else {
            return null;
        }
        // Store image to default external storage directory
        Uri bmpUri = null;
        try {
            // Use methods on Context to access package-specific directories on external storage.
            // This way, you don't need to request external read/write permission.
            // See https://youtu.be/5xVh-7ywKpE?t=25m25s
            File file =  new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "share_image_" + System.currentTimeMillis() + ".png");
            FileOutputStream out = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.close();
            // **Warning:** This will fail for API >= 24, use a FileProvider as shown below instead.
            bmpUri = Uri.fromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bmpUri;
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
