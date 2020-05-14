package com.jorgegiance.folks.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.jorgegiance.folks.models.propublicaModels.Member;
import com.jorgegiance.folks.repository.AppRepository;

import java.util.List;

public class CongressViewModel extends AndroidViewModel {

    private AppRepository repository;
    private LiveData<List<Member>> senateMembers;
    private LiveData<List<Member>> congressMembers;

    public CongressViewModel( @NonNull Application application ) {
        super(application);

        repository = new AppRepository(application);
        senateMembers = repository.getSenatorsList();
        congressMembers = repository.getRepresentativesList();
    }


    public LiveData<List<Member>> getSenateMembers() {
        return senateMembers;
    }

    public LiveData<List<Member>> getCongressMembers() {
        return congressMembers;
    }

}
