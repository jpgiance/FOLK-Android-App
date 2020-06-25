package com.jorgegiance.folks.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorgegiance.folks.R;
import com.jorgegiance.folks.adapters.FollowingAdapter;
import com.jorgegiance.folks.models.googlecivicModels.Official;

import java.util.ArrayList;
import java.util.List;


public class FollowingFragment extends Fragment {

    private Context ctx;

    public FollowingFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {

        final View rootView = inflater.inflate(R.layout.fragment_following, container, false);

        RecyclerView recycler = rootView.findViewById(R.id.following_recycler);
        FollowingAdapter adapter = new FollowingAdapter(ctx);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false));
        recycler.setHasFixedSize(true);

        adapter.setMemberArrayList(getDummyList());

        return rootView;
    }

    @Override
    public void onAttach( @NonNull Context context ) {
        super.onAttach(context);
        ctx = context;
    }

    private ArrayList<Official> getDummyList(){

        ArrayList<Official> list = new ArrayList<>();

        ArrayList<String> office = new ArrayList<>();

        office.add("President of the United States");

        Official trump = new Official();
        trump.setName("Donald Trump");
        trump.setParty("Rep");
        trump.setPhotoUrl("https://www.whitehouse.gov/wp-content/uploads/2017/11/President-Trump-Official-Portrait.jpg");
        trump.setUrls(office);

        list.add(trump);

        office = new ArrayList<>();
        office.add("Governor of Texas");
        Official greg = new Official();
        greg.setName("Greg Abbott");
        greg.setParty("Rep");
        greg.setPhotoUrl("https://gov.texas.gov/uploads/images/general/2015-GovernorAbbott-Portrait.jpg");
        greg.setUrls(office);


        list.add(greg);

        office = new ArrayList<>();
        office.add("In development");
        Official election = new Official();
        election.setName("2020 US Senate Elections");
        election.setParty("election");
        election.setPhotoUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/2/2b/Flag_of_the_United_States_Senate.svg/1920px-Flag_of_the_United_States_Senate.svg.png");
        election.setUrls(office);


        list.add(election);


        office = new ArrayList<>();
        office.add("In development");
        Official news = new Official();
        news.setName("Coronavirus Relief Package");
        news.setParty("news");
        news.setPhotoUrl("https://www.gannett-cdn.com/presto/2020/03/19/USAT/ad55c5db-8200-4a39-b278-2033ad15085d-XXX__tax-refund.jpg");
        news.setUrls(office);


        list.add(news);


        return list;
    }
}
