package com.jorgegiance.folks.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.jorgegiance.folks.models.firebaseModels.News;

public class DetailActivityViewModel extends AndroidViewModel {

    private News selectedNews;

    public DetailActivityViewModel( @NonNull Application application ) {
        super(application);
    }

    public News getSelectedNews() {
        return selectedNews;
    }

    public void setSelectedNews( News selectedNews ) {
        this.selectedNews = selectedNews;
    }
}
