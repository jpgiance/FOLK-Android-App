package com.jorgegiance.folks.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class PeopleActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> stateFilterSelected;
    private String filterOwner;
    private String filterState;

    public PeopleActivityViewModel( @NonNull Application application ) {
        super(application);

        stateFilterSelected = new MutableLiveData<>();
    }

    public MutableLiveData<Boolean> getStateFilterSelected() {
        return stateFilterSelected;
    }

    public void setStateFilterSelected( Boolean aBoolean ) {
        this.stateFilterSelected.setValue(aBoolean);
    }

    public String getFilterOwner() {
        return filterOwner;
    }

    public void setFilterOwner( String filterOwner ) {
        this.filterOwner = filterOwner;
    }

    public String getFilterState() {
        return filterState;
    }

    public void setFilterState( String filterState ) {
        this.filterState = filterState;
    }
}
