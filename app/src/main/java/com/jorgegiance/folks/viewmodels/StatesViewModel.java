package com.jorgegiance.folks.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jorgegiance.folks.R;
import com.jorgegiance.folks.models.googlecivicModels.StateCabinet;
import com.jorgegiance.folks.repository.AppRepository;

public class StatesViewModel extends AndroidViewModel {

    private AppRepository repository;
    private LiveData<StateCabinet> stateCabinet;
    private LiveData<StateCabinet> localOfficials;
    private Application application;

    public StatesViewModel( @NonNull Application application ) {
        super(application);

        this.application = application;

        repository = new AppRepository(application);
        stateCabinet = repository.getHeadOfCountry();

    }


    public void updateStateCabinet( String state){
        if (state.equals(application.getResources().getStringArray(R.array.states_list)[0]) ){
            stateCabinet = repository.getHeadOfCountry();

        }else{

            stateCabinet = repository.getStateCabinet(state);

        }


    }

    public LiveData<StateCabinet> getStateCabinet() {
        return stateCabinet;
    }






}
