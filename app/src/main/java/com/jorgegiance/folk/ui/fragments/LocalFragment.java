package com.jorgegiance.folk.ui.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.jorgegiance.folk.R;
import com.jorgegiance.folk.adapters.OfficialsAdapter;
import com.jorgegiance.folk.models.googlecivicModels.StateCabinet;
import com.jorgegiance.folk.ui.dialogs.StateFilterDialog;
import com.jorgegiance.folk.viewmodels.LocalViewModel;
import com.jorgegiance.folk.viewmodels.PeopleActivityViewModel;

public class LocalFragment extends Fragment implements View.OnClickListener{

    //ui components
    private EditText cityText;
    private TextView stateText;
    private Button searchButton;

    private PeopleActivityViewModel peopleActivityViewModel;
    private LocalViewModel localViewModel;
    private Context ctx;
    private OfficialsAdapter adapterLocal, adapterRepresentative;

    public LocalFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {
        final View rootView = inflater.inflate(R.layout.fragment_local, container, false);

        cityText = rootView.findViewById(R.id.city_edit_text);
        stateText = rootView.findViewById(R.id.state_edit_text);
        searchButton = rootView.findViewById(R.id.button_search);

        setListener();

        RecyclerView recyclerLocal = rootView.findViewById(R.id.person_recycler);
        adapterLocal = new OfficialsAdapter(getContext());
        recyclerLocal.setAdapter(adapterLocal);
        recyclerLocal.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerLocal.setHasFixedSize(true);

        RecyclerView recyclerRepresentative = rootView.findViewById(R.id.representative_recycler);
        adapterRepresentative = new OfficialsAdapter(getContext());
        recyclerRepresentative.setAdapter(adapterRepresentative);
        recyclerRepresentative.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerRepresentative.setHasFixedSize(true);


        return rootView;
    }

    @Override
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated(savedInstanceState);

        peopleActivityViewModel = new ViewModelProvider(getActivity()).get(PeopleActivityViewModel.class);
        localViewModel = new ViewModelProvider(getActivity()).get(LocalViewModel.class);
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
                    if (peopleActivityViewModel.getFilterOwner().equals(getString(R.string.tab_local))){
                        if (peopleActivityViewModel.getFilterState().equals(getString(R.string.filter_all))){
                            stateText.setText("");
                        }else {
                            stateText.setText(peopleActivityViewModel.getFilterState());
                        }

                        peopleActivityViewModel.setStateFilterSelected(false);



                    }



                }

            }
        });


        localViewModel.getLocalOfficials().observe(getViewLifecycleOwner(), new Observer<StateCabinet>() {
            @Override
            public void onChanged( StateCabinet stateCabinet ) {
                if (stateCabinet != null) {

                    adapterLocal.setStateCabinet(stateCabinet);
                }
            }
        });

        localViewModel.getLocalRepresentatives().observe(getViewLifecycleOwner(), new Observer<StateCabinet>() {
            @Override
            public void onChanged( StateCabinet stateCabinet ) {
                if (stateCabinet != null) {

                    adapterRepresentative.setStateCabinet(stateCabinet);
                }
            }
        });
    }



    private void setListener() {
        stateText.setOnClickListener(this);
        searchButton.setOnClickListener(this);
        cityText.setOnClickListener(this);

    }

    @Override
    public void onClick( View v ) {
        switch (v.getId()){
            case R.id.state_edit_text:
                cityText.setCursorVisible(false);
                peopleActivityViewModel.setFilterOwner(getString(R.string.tab_local));
                showFilterDialog();
                break;
            case R.id.button_search:
                cityText.setCursorVisible(false);
                search();
                break;
            case R.id.city_edit_text:
                cityText.setCursorVisible(true);
                break;
        }
    }

    private void search() {

        String address = cityText.getText().toString();
        String state = stateText.getText().toString();

        if (address.equals("") || state.equals("")){
            // show dialog "Enter Address and state"
            new MaterialAlertDialogBuilder(ctx)
                    .setTitle("Missing information")
                    .setMessage("Please type address and select state")
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }else{
            localViewModel.updateLocalOfficials(address+","+state);
            localViewModel.updateLocalRepresentatives(address+","+state);
            initObservers();
        }


    }

    private void showFilterDialog() {
        FragmentManager fm = getActivity().getSupportFragmentManager();
        StateFilterDialog nameDialog = new StateFilterDialog(ctx);
        nameDialog.show(fm, "lolo");//getResources().getString(R.string.dialog_tag));
    }


}
