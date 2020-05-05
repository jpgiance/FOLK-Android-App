package com.jorgegiance.folk.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.jorgegiance.folk.models.News;

public class ItemNewsViewModel extends AndroidViewModel {

    private MutableLiveData<News> newsSelected;

    public ItemNewsViewModel( @NonNull Application application ) {
        super(application);

        newsSelected = new MutableLiveData<>();
    }
}
