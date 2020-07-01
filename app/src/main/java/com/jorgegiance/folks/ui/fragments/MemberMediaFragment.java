package com.jorgegiance.folks.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.jorgegiance.folks.R;

public class MemberMediaFragment extends Fragment {

    Context ctx;

    //ui components
    private Spinner mediaSpinner;

    public MemberMediaFragment() {
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
         final View rootView = inflater.inflate(R.layout.fragment_member_media, container, false);

         mediaSpinner = rootView.findViewById(R.id.media_spinner);
        ArrayAdapter<CharSequence> timerAdapter = ArrayAdapter.createFromResource(ctx,
                R.array.timer_spinner_array, R.layout.spinner_item);
        timerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mediaSpinner.setAdapter(timerAdapter);


        return rootView;
    }

    @Override
    public void onAttach( @NonNull Context context ) {
        super.onAttach(context);
        this.ctx = context;
    }
}
