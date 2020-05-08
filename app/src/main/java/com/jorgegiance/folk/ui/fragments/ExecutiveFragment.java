package com.jorgegiance.folk.ui.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.jorgegiance.folk.R;
import com.jorgegiance.folk.models.Person;
import com.jorgegiance.folk.ui.dialogs.StateFilterDialog;
import com.jorgegiance.folk.viewmodels.PeopleActivityViewModel;

import java.util.ArrayList;

public class ExecutiveFragment extends Fragment implements View.OnClickListener{

    //ui components
    private Button button;

    private Context ctx;
    private PeopleActivityViewModel peopleActivityViewModel;

    public ExecutiveFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {

        final View rootView = inflater.inflate(R.layout.fragment_executive, container, false);

        peopleActivityViewModel = new ViewModelProvider(getActivity()).get(PeopleActivityViewModel.class);

        button = rootView.findViewById(R.id.button);
        RecyclerView recycler = rootView.findViewById(R.id.person_recycler);
        
        setListener();
        
//        PeopleAdapter adapter = new PeopleAdapter(getContext());
//        recycler.setAdapter(adapter);
//        recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
//        recycler.setHasFixedSize(true);

       // adapter.setMembersList(createPeopleList());



        initObservers();
        return rootView;
    }

    private void initObservers() {

        peopleActivityViewModel.setStateFilterSelected(false);

        peopleActivityViewModel.getStateFilterSelected().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onChanged( Boolean aBoolean ) {
                if (aBoolean){
                    if (peopleActivityViewModel.getFilterOwner().equals(getString(R.string.cabinet))){
                        if (peopleActivityViewModel.getFilterState().equals(getString(R.string.filter_all))){
                            button.setText(getString(R.string.button_Federal));
                        }else {
                            button.setText(
                                    getString(R.string.filter_text_start)
                                            + peopleActivityViewModel.getFilterState()
                                            + getString(R.string.filter_text_end));
                        }

                        peopleActivityViewModel.setStateFilterSelected(false);
                    }



                }

            }
        });
    }

    @Override
    public void onAttach( @NonNull Context context ) {
        ctx = context;
        super.onAttach(context);

    }

    private void setListener() {

        button.setOnClickListener(this);
    }



    @Override
    public void onClick( View v ) {
        switch (v.getId()){
            case R.id.button:
                peopleActivityViewModel.setFilterOwner(getString(R.string.cabinet));
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
