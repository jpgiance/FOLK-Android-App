package com.jorgegiance.folks.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.adapters.DetailPagerAdapter;


public class DetailFragment extends Fragment {

    // UI components
    ViewPager2 viewPager;
    TabLayout tabs;


    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_detail, container, false);


        viewPager = rootView.findViewById(R.id.detail_view_pager);
        tabs = rootView.findViewById(R.id.tabs);

        DetailPagerAdapter detailPagerAdapter = new DetailPagerAdapter(getActivity(), getContext());
        viewPager.setAdapter(detailPagerAdapter);

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(
                tabs, viewPager, new TabLayoutMediator.TabConfigurationStrategy(){

            @Override
            public void onConfigureTab( @NonNull TabLayout.Tab tab, int position ) {
                switch (position){
                    case 0:
                        tab.setText(R.string.tab_content);
                        break;
                    case 1:
                        tab.setText(R.string.tab_debate);
                        break;
                }
            }
        });
        tabLayoutMediator.attach();

        return rootView;
    }
}
