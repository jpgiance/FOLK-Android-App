package com.jorgegiance.folk.ui.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jorgegiance.folk.R;
import com.jorgegiance.folk.adapters.MembersAdapter;
import com.jorgegiance.folk.models.Member;
import com.jorgegiance.folk.models.Person;
import com.jorgegiance.folk.ui.dialogs.StateFilterDialog;
import com.jorgegiance.folk.viewmodels.MembersViewModel;
import com.jorgegiance.folk.viewmodels.PeopleActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class LegislativeFragment extends Fragment implements View.OnClickListener{

    //ui components
    private TextView filterSenate, filterCongress;

    private PeopleActivityViewModel peopleActivityViewModel;
    private MembersViewModel membersViewModel;
    private Context ctx;
    private MembersAdapter adapterSenate, adapterCongress;



    public LegislativeFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {

        final View rootView = inflater.inflate(R.layout.fragment_legislative, container, false);

        peopleActivityViewModel = new ViewModelProvider(getActivity()).get(PeopleActivityViewModel.class);
        membersViewModel = new ViewModelProvider(getActivity()).get(MembersViewModel.class);

        filterCongress = rootView.findViewById(R.id.filter_congress);
        filterSenate = rootView.findViewById(R.id.filter_senate);

        setListener();

        RecyclerView recyclerSenate = rootView.findViewById(R.id.person_recycler_0);
        adapterSenate = new MembersAdapter(getContext());
        recyclerSenate.setAdapter(adapterSenate);
        recyclerSenate.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerSenate.setHasFixedSize(true);

        RecyclerView recyclerCongress = rootView.findViewById(R.id.person_recycler_1);
        adapterCongress = new MembersAdapter(getContext());
        recyclerCongress.setAdapter(adapterCongress);
        recyclerCongress.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerCongress.setHasFixedSize(true);




        initObservers();
        return rootView;
    }

    @Override
    public void onAttach( @NonNull Context context ) {
        ctx = context;
        super.onAttach(context);

    }

    private void initObservers() {

        peopleActivityViewModel.setStateFilterSelected(false);

        peopleActivityViewModel.getStateFilterSelected().observe(getViewLifecycleOwner(), new Observer<Boolean>() {

            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged( Boolean aBoolean ) {
                if (aBoolean){
                    if (peopleActivityViewModel.getFilterOwner().equals(getString(R.string.congress))){
                        if (peopleActivityViewModel.getFilterState().equals(getString(R.string.filter_all))){
                            filterCongress.setText(getString(R.string.state_filter));
                        }else {
                            filterCongress.setText(
                                    getString(R.string.filter_text_start)
                                            + peopleActivityViewModel.getFilterState()
                                            + getString(R.string.filter_text_end));
                        }

                        peopleActivityViewModel.setStateFilterSelected(false);

                    }
                    if (peopleActivityViewModel.getFilterOwner().equals(getString(R.string.senate))){
                        if (peopleActivityViewModel.getFilterState().equals(getString(R.string.filter_all))){
                            filterSenate.setText(getString(R.string.state_filter));
                        }else {
                            filterSenate.setText(
                                    getString(R.string.filter_text_start)
                                            + peopleActivityViewModel.getFilterState()
                                            + getString(R.string.filter_text_end));
                        }

                        peopleActivityViewModel.setStateFilterSelected(false);

                    }


                }

            }
        });


        membersViewModel.getSenateMembers().observe(getViewLifecycleOwner(), new Observer<List<Member>>() {
            @Override
            public void onChanged( List<Member> members ) {
                adapterSenate.setMembersList(members);
            }
        });

        membersViewModel.getCongressMembers().observe(getViewLifecycleOwner(), new Observer<List<Member>>() {
            @Override
            public void onChanged( List<Member> members ) {
                adapterCongress.setMembersList(members);
            }
        });
    }

    private void setListener() {
        filterSenate.setOnClickListener(this);
        filterCongress.setOnClickListener(this);
    }



    @Override
    public void onClick( View v ) {
        switch (v.getId()){
            case R.id.filter_senate:
                peopleActivityViewModel.setFilterOwner(getString(R.string.senate));
                showFilterDialog();
                break;
            case R.id.filter_congress:
                peopleActivityViewModel.setFilterOwner(getString(R.string.congress));
                showFilterDialog();
                break;
            default:
                break;
        }
    }

    private void showFilterDialog() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        StateFilterDialog nameDialog = new StateFilterDialog(ctx);
        nameDialog.show(fm, "lolo");//getResources().getString(R.string.dialog_tag));
    }
}
