package com.jorgegiance.folks.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jorgegiance.folks.R;
import com.jorgegiance.folks.adapters.ProfileAdapter;


public class ProfileFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    private boolean fieldsState = false;
    Context ctx;


    public static ProfileFragment newInstance( int index ) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate( Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState ) {

        final View rootView = inflater.inflate(R.layout.fragment_profile, container, false);



        setListeners();


        RecyclerView recycler = rootView.findViewById(R.id.profile_recycle);
        ProfileAdapter adapter = new ProfileAdapter(ctx);
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


    private void setListeners() {

    }
}