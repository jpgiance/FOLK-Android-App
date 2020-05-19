package com.jorgegiance.folks.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jorgegiance.folks.models.firebaseModels.News;
import com.jorgegiance.folks.models.firebaseModels.Page;
import com.jorgegiance.folks.repository.FirebaseRepository;

public class ItemNewsViewModel extends AndroidViewModel {

    private FirebaseRepository mFirebaseRepository;

    private MutableLiveData<Long> lastPage;
    private MutableLiveData<News> newsSelected;

    public ItemNewsViewModel( @NonNull Application application ) {
        super(application);

        mFirebaseRepository = new FirebaseRepository(application);

        lastPage = mFirebaseRepository.updateLastPage();
    }

    public MutableLiveData<Long> getLastPage() {
        return lastPage;
    }

    public LiveData<Page> getPage(long pageNumber ) {
        return mFirebaseRepository.updatePage(pageNumber);
    }

    public void detachLastPageListener(){
        mFirebaseRepository.detachLastPageListener();
    }
}
