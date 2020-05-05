package com.jorgegiance.folk.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.jorgegiance.folk.ui.fragments.ExecutiveFragment;
import com.jorgegiance.folk.ui.fragments.JudicialFragment;
import com.jorgegiance.folk.ui.fragments.LegislativeFragment;


public class PeoplePagerAdapter extends FragmentStateAdapter {


    public PeoplePagerAdapter( @NonNull FragmentActivity fragmentActivity ) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment( int position ) {
        switch (position){
            case 0:
                return new ExecutiveFragment();
            case 1:
                return new LegislativeFragment();
            case 2:
                return new JudicialFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
