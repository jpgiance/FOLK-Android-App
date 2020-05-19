package com.jorgegiance.folks.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.jorgegiance.folks.R;
import com.jorgegiance.folks.adapters.DetailPagerAdapter;
import com.jorgegiance.folks.util.NotificationUtil;
import com.jorgegiance.folks.util.Utilities;
import com.jorgegiance.folks.viewmodels.DetailActivityViewModel;


public class DetailFragment extends Fragment implements View.OnClickListener{

    // UI components
    private ViewPager2 viewPager;
    private TabLayout tabs;
    private TextView newsTitle, newsAuthor, newsTime;
    private ImageView newsPoster;
    private Button voteButton;

    private Context ctx;
    private DetailActivityViewModel mDetailActivityViewModel;




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

        mDetailActivityViewModel = new ViewModelProvider(getActivity()).get(DetailActivityViewModel.class);

        viewPager = rootView.findViewById(R.id.detail_view_pager);
        tabs = rootView.findViewById(R.id.tabs);
        newsTitle = rootView.findViewById(R.id.news_title);
        newsAuthor = rootView.findViewById(R.id.news_author);
        newsTime = rootView.findViewById(R.id.news_time);
        newsPoster = rootView.findViewById(R.id.news_poster);
        voteButton = rootView.findViewById(R.id.vote_button);

        voteButton.setOnClickListener(this);

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

        populateUi();

        return rootView;
    }

    @Override
    public void onAttach( @NonNull Context context ) {
        super.onAttach(context);
        this.ctx = context;
    }

    private void populateUi() {
        if (mDetailActivityViewModel.getSelectedNews() != null){
            newsTitle.setText(mDetailActivityViewModel.getSelectedNews().getTitle());
            newsAuthor.setText(mDetailActivityViewModel.getSelectedNews().getAuthor());
            newsTime.setText(Utilities.time2Date(mDetailActivityViewModel.getSelectedNews().getTime()));

            Glide.with(ctx)
                    .load(mDetailActivityViewModel.getSelectedNews().getPhotoUrl())
                    .centerCrop()
                    .into(newsPoster);
        }
    }

    @Override
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated(savedInstanceState);




    }

    @Override
    public void onClick( View v ) {

        switch (v.getId()){
            case R.id.vote_button:
                NotificationUtil.setNewStoriesNotification(ctx);
                break;

        }

    }
}
