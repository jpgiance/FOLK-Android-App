package com.jorgegiance.folks.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jorgegiance.folks.ui.fragments.StatesFragment;
import com.jorgegiance.folks.ui.fragments.LocalFragment;
import com.jorgegiance.folks.ui.fragments.CongressFragment;


public class PeoplePagerAdapter extends FragmentStateAdapter {


    public PeoplePagerAdapter( @NonNull FragmentActivity fragmentActivity ) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment( int position ) {
        switch (position){
            case 0:
                return new StatesFragment();
            case 1:
                return new CongressFragment();
            case 2:
                return new LocalFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
