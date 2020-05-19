package com.jorgegiance.folks.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jorgegiance.folks.util.Constants;

public class HomeActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Long> currentPage = new MutableLiveData<>();

    public HomeActivityViewModel( @NonNull Application application ) {
        super(application);

        currentPage.setValue((Constants.INITIAL_CURRENT_PAGE));
    }

    public MutableLiveData<Long> getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage( long currentPage ) {
        this.currentPage.setValue(currentPage);
    }
}
