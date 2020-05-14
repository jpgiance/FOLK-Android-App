package com.jorgegiance.folks.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jorgegiance.folks.ContentFragment;
import com.jorgegiance.folks.DebateFragment;

public class DetailPagerAdapter extends FragmentStateAdapter {

    private final Context mContext;

    public DetailPagerAdapter( @NonNull FragmentActivity fragmentActivity, Context mContext ) {
        super(fragmentActivity);
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Fragment createFragment( int position ) {
        switch (position){
            case 0:
                return new ContentFragment();
            case 1:
                return new DebateFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
