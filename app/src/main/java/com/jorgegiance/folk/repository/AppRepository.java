package com.jorgegiance.folk.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jorgegiance.folk.models.ProPublicaApiResult;
import com.jorgegiance.folk.models.Member;
import com.jorgegiance.folk.network.ProPublicaService;
import com.jorgegiance.folk.network.ProPublicaCongressApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {


    private ProPublicaService proPublicaService;

    public AppRepository( Application application ) {


        proPublicaService = ProPublicaCongressApiClient.getApiClient().create(ProPublicaService.class);

    }




    public LiveData<List<Member>> getSenatorsList() {

        final MutableLiveData<List<Member>> senatorsList = new MutableLiveData<>();
        proPublicaService.getAllSenate().enqueue(new Callback<ProPublicaApiResult>() {


            @Override
            public void onResponse( Call<ProPublicaApiResult> call, Response<ProPublicaApiResult> response ) {

                if (response.isSuccessful()){
                    senatorsList.setValue(response.body().getResults().get(0).getMembers());
                }else {
                    Log.d("Unsuccess Debug message", response.toString());
                }
            }

            @Override
            public void onFailure( Call<ProPublicaApiResult> call, Throwable t ) {
                senatorsList.setValue(null);
                Log.d("failure Debug message", t.getMessage());
            }
        });
        return senatorsList;
    }


    public LiveData<List<Member>> getRepresentativesList() {

        final MutableLiveData<List<Member>> representativesList = new MutableLiveData<>();
        proPublicaService.getAllCongress().enqueue(new Callback<ProPublicaApiResult>() {

            @Override
            public void onResponse( Call<ProPublicaApiResult> call, Response<ProPublicaApiResult> response ) {

                if (response.isSuccessful()){
                    representativesList.setValue(response.body().getResults().get(0).getMembers());
                }else {
                    Log.d("Unsuccess Debug message", response.toString());
                }
            }

            @Override
            public void onFailure( Call<ProPublicaApiResult> call, Throwable t ) {
                representativesList.setValue(null);
                Log.d("failure Debug message", t.getMessage());
            }
        });
        return representativesList;
    }




}
