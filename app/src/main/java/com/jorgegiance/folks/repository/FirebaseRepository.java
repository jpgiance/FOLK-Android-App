package com.jorgegiance.folks.repository;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.jorgegiance.folks.models.firebaseModels.Page;

public class FirebaseRepository {


    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mLastPageReference;
    private DatabaseReference mPageReference;
    private ChildEventListener mChildEventListener;
    private ValueEventListener mLastPageListener;


    public FirebaseRepository( Application application ) {

        // Initialize Firebase components
        mFirebaseDatabase = FirebaseDatabase.getInstance();


    }




    public MutableLiveData<Long> updateLastPage(){
        final MutableLiveData<Long> data = new MutableLiveData<>();

        mLastPageReference = mFirebaseDatabase.getReference().child("pages").child("last");
        mLastPageListener = new ValueEventListener() {

            @Override
            public void onDataChange( @NonNull DataSnapshot dataSnapshot ) {
                data.setValue((Long) dataSnapshot.getValue());

            }

            @Override
            public void onCancelled( @NonNull DatabaseError databaseError ) {

            }


        };
        mLastPageReference.addValueEventListener(mLastPageListener);

        return data;
    }

    public LiveData<Page> updatePage(long pageNumber){

        final MutableLiveData<Page> data = new MutableLiveData<>();
        mPageReference = mFirebaseDatabase.getReference().child("pages").child(String.valueOf(pageNumber));

        mPageReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange( @NonNull DataSnapshot dataSnapshot ) {
                data.setValue( dataSnapshot.getValue(Page.class));
            }

            @Override
            public void onCancelled( @NonNull DatabaseError databaseError ) {

            }
        });

        return data;
    }

    public void detachLastPageListener(){
        if (mLastPageListener != null){
            mLastPageReference.removeEventListener(mLastPageListener);
            mLastPageListener = null;
        }
    }

}
