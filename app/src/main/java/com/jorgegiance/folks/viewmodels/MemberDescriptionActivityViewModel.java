package com.jorgegiance.folks.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.jorgegiance.folks.models.Person;

public class MemberDescriptionActivityViewModel extends AndroidViewModel {

    private Person person;

    public MemberDescriptionActivityViewModel( @NonNull Application application ) {
        super(application);
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson( Person person ) {
        this.person = person;
    }
}
