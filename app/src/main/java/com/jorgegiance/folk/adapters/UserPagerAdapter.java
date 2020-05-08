package com.jorgegiance.folk.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jorgegiance.folk.ui.fragments.FollowingFragment;
import com.jorgegiance.folk.ui.fragments.ProfileFragment;
import com.jorgegiance.folk.ui.fragments.SettingsFragment;

import java.util.Objects;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class UserPagerAdapter extends FragmentStateAdapter {


    private final Context mContext;

    public UserPagerAdapter( Context context, @NonNull FragmentActivity fragmentActivity ) {
        super(Objects.requireNonNull(fragmentActivity));
        this.mContext = context;
    }



    @NonNull
    @Override
    public Fragment createFragment( int position ) {

        switch (position){
            case 0:
                return new ProfileFragment();
            case 1:
                return new FollowingFragment();
            case 2:
                return new SettingsFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        // Show 2 total pages.
        return 3;
    }
}