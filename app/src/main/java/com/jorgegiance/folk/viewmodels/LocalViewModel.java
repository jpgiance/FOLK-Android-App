package com.jorgegiance.folk.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jorgegiance.folk.models.googlecivicModels.StateCabinet;
import com.jorgegiance.folk.repository.AppRepository;

public class LocalViewModel extends AndroidViewModel {

    private AppRepository repository;
    private LiveData<StateCabinet> localOfficials;
    private LiveData<StateCabinet> localRepresentatives;
    private Application application;


    public LocalViewModel( @NonNull Application application ) {
        super(application);

        this.application = application;

        repository = new AppRepository(application);
        localOfficials = repository.getLocalOfficials("us");
        localRepresentatives = repository.getLocalRepresentative("us");
    }


    public LiveData<StateCabinet> getLocalOfficials(){
        return localOfficials;
    }

    public void updateLocalOfficials(String address){
        localOfficials = repository.getLocalOfficials(address);
    }

    public LiveData<StateCabinet> getLocalRepresentatives(){
        return localRepresentatives;
    }

    public void updateLocalRepresentatives(String address){
        localRepresentatives = repository.getLocalRepresentative(address);
    }
}
