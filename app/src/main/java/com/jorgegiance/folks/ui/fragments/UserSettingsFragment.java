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
import com.jorgegiance.folks.adapters.SettingsAdapter;

public class UserSettingsFragment extends Fragment {

    private Context ctx;

    public UserSettingsFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState ) {

        final View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        RecyclerView recycler = rootView.findViewById(R.id.settings_recycler);
        SettingsAdapter adapter = new SettingsAdapter(ctx);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(ctx, LinearLayoutManager.VERTICAL, false));
        recycler.setHasFixedSize(true);


        return rootView;
    }

    @Override
    public void onAttach( @NonNull Context context ) {
        super.onAttach(context);
        ctx = context;
    }
}
