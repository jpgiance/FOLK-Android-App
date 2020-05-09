package com.jorgegiance.folk.ui.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jorgegiance.folk.R;
import com.jorgegiance.folk.adapters.OfficialsAdapter;
import com.jorgegiance.folk.models.googlecivicModels.StateCabinet;
import com.jorgegiance.folk.ui.dialogs.StateFilterDialog;
import com.jorgegiance.folk.viewmodels.StatesViewModel;
import com.jorgegiance.folk.viewmodels.PeopleActivityViewModel;

public class StatesFragment extends Fragment implements View.OnClickListener{

    //ui components
    private Button button;
    private ImageView presidentImage, vicePresidentImage;
    private TextView presidentName, vicePresidentName, presidentTitle, vicePresidentTitle;

    OfficialsAdapter adapter;

    private Context ctx;
    private PeopleActivityViewModel peopleActivityViewModel;
    private StatesViewModel statesViewModel;

    public StatesFragment() {
    }

    @Nullable
    @Override
    public View onCreateView( @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState ) {

        final View rootView = inflater.inflate(R.layout.fragment_executive, container, false);

        presidentImage = rootView.findViewById(R.id.image_president);
        vicePresidentImage = rootView.findViewById(R.id.image_vice_president);
        vicePresidentTitle = rootView.findViewById(R.id.vice_president_title);
        presidentTitle = rootView.findViewById(R.id.president_title);
        presidentName = rootView.findViewById(R.id.president_name);
        vicePresidentName = rootView.findViewById(R.id.vice_president_name);
        button = rootView.findViewById(R.id.button);
        RecyclerView recycler = rootView.findViewById(R.id.person_recycler);
        
        setListener();
        
        adapter = new OfficialsAdapter(getContext());
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        recycler.setHasFixedSize(true);





        return rootView;
    }

    @Override
    public void onActivityCreated( @Nullable Bundle savedInstanceState ) {
        super.onActivityCreated(savedInstanceState);

        peopleActivityViewModel = new ViewModelProvider(getActivity()).get(PeopleActivityViewModel.class);
        statesViewModel = new ViewModelProvider(getActivity()).get(StatesViewModel.class);

        peopleActivityViewModel.setStateFilterSelected(false);
        peopleActivityViewModel.setFilterState(getResources().getStringArray(R.array.states_list)[0]);
        initObservers();
    }

    private void initObservers() {



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

                        statesViewModel.updateStateCabinet(peopleActivityViewModel.getFilterState());
                        initObservers();
                    }



                }

            }
        });


        statesViewModel.getStateCabinet().observe(getViewLifecycleOwner(), new Observer<StateCabinet>() {
            @Override
            public void onChanged( StateCabinet stateCabinet ) {
                populateFragmentUi(stateCabinet);
            }
        });
    }

    private void populateFragmentUi(StateCabinet stateCabinet) {
        if (stateCabinet != null) {

            if (stateCabinet.getOffices() != null){

                if (stateCabinet.getOffices().size() > 0){

                    presidentName.setText(stateCabinet.getOfficials().get(0).getName());
                    presidentTitle.setText(stateCabinet.getOffices().get(0).getName());
                    Glide.with(ctx)
                            .load(stateCabinet.getOfficials().get(0).getPhotoUrl())
                            .centerCrop()
                            .placeholder(R.drawable.ic_person)
                            .into(presidentImage
                    );

                    presidentTitle.setVisibility(View.VISIBLE);
                    presidentName.setVisibility(View.VISIBLE);
                    presidentImage.setVisibility(View.VISIBLE);

                    stateCabinet.removeOffice(0);
                    stateCabinet.removeOfficial(0);

                }else {
                    presidentTitle.setVisibility(View.INVISIBLE);
                    presidentName.setVisibility(View.INVISIBLE);
                    presidentImage.setVisibility(View.INVISIBLE);
                }
                if (stateCabinet.getOffices().size() > 0){

                    vicePresidentName.setText(stateCabinet.getOfficials().get(0).getName());
                    vicePresidentTitle.setText(stateCabinet.getOffices().get(0).getName());
                    Glide.with(ctx)
                            .load(stateCabinet.getOfficials().get(0).getPhotoUrl())
                            .centerCrop()
                            .placeholder(R.drawable.ic_person)
                            .into(vicePresidentImage
                    );

                    vicePresidentTitle.setVisibility(View.VISIBLE);
                    vicePresidentName.setVisibility(View.VISIBLE);
                    vicePresidentImage.setVisibility(View.VISIBLE);

                    stateCabinet.removeOffice(0);
                    stateCabinet.removeOfficial(0);
                }else {
                    vicePresidentTitle.setVisibility(View.INVISIBLE);
                    vicePresidentName.setVisibility(View.INVISIBLE);
                    vicePresidentImage.setVisibility(View.INVISIBLE);
                }
            }else {

                presidentTitle.setVisibility(View.INVISIBLE);
                presidentName.setVisibility(View.INVISIBLE);
                presidentImage.setVisibility(View.INVISIBLE);

                vicePresidentTitle.setVisibility(View.INVISIBLE);
                vicePresidentName.setVisibility(View.INVISIBLE);
                vicePresidentImage.setVisibility(View.INVISIBLE);
            }


            adapter.setStateCabinet(stateCabinet);

        }else {

            presidentTitle.setVisibility(View.INVISIBLE);
            presidentName.setVisibility(View.INVISIBLE);
            presidentImage.setVisibility(View.INVISIBLE);

            vicePresidentTitle.setVisibility(View.INVISIBLE);
            vicePresidentName.setVisibility(View.INVISIBLE);
            vicePresidentImage.setVisibility(View.INVISIBLE);
        }


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
