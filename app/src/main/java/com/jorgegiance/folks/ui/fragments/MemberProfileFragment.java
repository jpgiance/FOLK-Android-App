package com.jorgegiance.folks.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.jorgegiance.folks.R;


public class MemberProfileFragment extends Fragment implements View.OnClickListener{

    private TextView viewMap, moreAboutOffice;

    private Context ctx;

    public MemberProfileFragment() {
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
        final View rootView = inflater.inflate(R.layout.fragment_member_profile, container, false);

        viewMap = rootView.findViewById(R.id.icon_view_map);
        moreAboutOffice = rootView.findViewById(R.id.icon_more_about_office);

        viewMap.setOnClickListener(this);
        moreAboutOffice.setOnClickListener(this);



        return rootView;
    }

    @Override
    public void onAttach( @NonNull Context context ) {
        super.onAttach(context);

        this.ctx = context;
    }

    @Override
    public void onClick( View v ) {
        switch (v.getId()){
            case R.id.icon_view_map:
                final View view = getLayoutInflater().inflate(R.layout.item_map, null);
                new MaterialAlertDialogBuilder(ctx)
                        .setTitle("District map")
                        .setView(view)
                        .setNegativeButton(android.R.string.no, null)
                        .show();
                break;
            case R.id.icon_more_about_office:
                new MaterialAlertDialogBuilder(ctx)
                        .setTitle("About this office")
                        .setMessage("   The United States House of Representatives is the lower house of the United States Congress; the Senate is the upper house. \n\n" +
                                "   As per the Constitution, the U.S. House of Representatives makes and passes federal laws. \n\n" +
                                "   Also referred to as a congressman or congresswoman, each representative is elected to a two-year term serving the people of a " +
                                "specific congressional district. \n\n" +
                                "   Among other duties, representatives introduce bills and resolutions, offer amendments and serve" +
                                " on committees. The number of representatives with full voting rights is 435, a number set by Public Law 62-5 on August 8, 1911," +
                                " and in effect since 1913. The number of representatives per state is proportionate to population.")
                        .setNegativeButton(android.R.string.no, null)
                        .show();
                break;
            default:
                break;
        }
    }
}
