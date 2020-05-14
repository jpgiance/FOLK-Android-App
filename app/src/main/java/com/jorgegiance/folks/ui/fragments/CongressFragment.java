package com.jorgegiance.folks.ui.fragments;

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

import com.jorgegiance.folks.R;
import com.jorgegiance.folks.adapters.MembersAdapter;
import com.jorgegiance.folks.models.propublicaModels.Member;
import com.jorgegiance.folks.ui.dialogs.StateFilterDialog;
import com.jorgegiance.folks.util.Utilities;
import com.jorgegiance.folks.viewmodels.CongressViewModel;
import com.jorgegiance.folks.viewmodels.PeopleActivityViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CongressFragment extends Fragment implements View.OnClickListener{

    //ui components
    private TextView filterSenate, filterCongress;

    private PeopleActivityViewModel peopleActivityViewModel;
    private CongressViewModel congressViewModel;
    private Context ctx;
    private MembersAdapter adapterSenate, adapterCongress;



    public CongressFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {

        final View rootView = inflater.inflate(R.layout.fragment_congress, container, false);


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





        return rootView;
    }

    @Override
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated(savedInstanceState);

        peopleActivityViewModel = new ViewModelProvider(getActivity()).get(PeopleActivityViewModel.class);
        congressViewModel = new ViewModelProvider(getActivity()).get(CongressViewModel.class);

        initObservers();

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
                                            + getString(R.string.filter_text_end)
                            );
                        }

                        updateCongressMembers(peopleActivityViewModel.getFilterState());
                        peopleActivityViewModel.setStateFilterSelected(false);

                    }
                    if (peopleActivityViewModel.getFilterOwner().equals(getString(R.string.senate))){
                        if (peopleActivityViewModel.getFilterState().equals(getString(R.string.filter_all))){
                            filterSenate.setText(getString(R.string.state_filter));
                        }else {
                            filterSenate.setText(
                                    getString(R.string.filter_text_start)
                                            + peopleActivityViewModel.getFilterState()
                                            + getString(R.string.filter_text_end)
                            );
                        }

                        updateSenateMembers(peopleActivityViewModel.getFilterState());
                        peopleActivityViewModel.setStateFilterSelected(false);

                    }


                }

            }
        });


        congressViewModel.getSenateMembers().observe(getViewLifecycleOwner(), new Observer<List<Member>>() {
            @Override
            public void onChanged( List<Member> members ) {
                adapterSenate.setMembersList(members);
            }
        });

        congressViewModel.getCongressMembers().observe(getViewLifecycleOwner(), new Observer<List<Member>>() {
            @Override
            public void onChanged( List<Member> members ) {
                adapterCongress.setMembersList(members);
            }
        });
    }

    private void updateCongressMembers(String state) {

        if (state.equals(getString(R.string.filter_all))){
            adapterCongress.setMembersList(congressViewModel.getCongressMembers().getValue());
        }else {
            ArrayList<Member> members = new ArrayList<>();
            String stateCode = Utilities.stateCode(state);

            for (Member member: Objects.requireNonNull(congressViewModel.getCongressMembers().getValue())) {
                if (member.getState().equals(stateCode)){
                    members.add(member);
                }
            }

            adapterCongress.setMembersList(members);
        }


    }

    private void updateSenateMembers(String state) {

        if (state.equals(getString(R.string.filter_all))){
            adapterSenate.setMembersList(congressViewModel.getSenateMembers().getValue());
        }else {
            ArrayList<Member> members = new ArrayList<>();
            String stateCode = Utilities.stateCode(state);

            for (Member member: Objects.requireNonNull(congressViewModel.getSenateMembers().getValue())) {
                if (member.getState().equals(stateCode)){
                    members.add(member);
                }
            }

            adapterSenate.setMembersList(members);
        }


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
