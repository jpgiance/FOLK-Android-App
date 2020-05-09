package com.jorgegiance.folk.repository;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jorgegiance.folk.BuildConfig;
import com.jorgegiance.folk.models.googlecivicModels.StateCabinet;
import com.jorgegiance.folk.models.propublicaModels.ProPublicaApiResult;
import com.jorgegiance.folk.models.propublicaModels.Member;
import com.jorgegiance.folk.network.GoogleCivicInformationApiClient;
import com.jorgegiance.folk.network.GoogleCivicService;
import com.jorgegiance.folk.network.ProPublicaService;
import com.jorgegiance.folk.network.ProPublicaCongressApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {


    private ProPublicaService proPublicaService;
    private GoogleCivicService googleCivicService;

    public AppRepository( Application application ) {


        proPublicaService = ProPublicaCongressApiClient.getApiClient().create(ProPublicaService.class);
        googleCivicService = GoogleCivicInformationApiClient.getApiClient().create(GoogleCivicService.class);

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
        proPublicaService.getAllRepresentatives().enqueue(new Callback<ProPublicaApiResult>() {

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


    public LiveData<List<Member>> getSenatorByState(String state){

        final MutableLiveData<List<Member>> senatorsList = new MutableLiveData<>();
        proPublicaService.getSenateByState(state).enqueue(new Callback<ProPublicaApiResult>() {
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


    public LiveData<List<Member>> getRepresentativeByState(String state){

        final MutableLiveData<List<Member>> representativesList = new MutableLiveData<>();
        proPublicaService.getRepresentativeByState(state).enqueue(new Callback<ProPublicaApiResult>() {

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


    public LiveData<StateCabinet> getStateCabinet( String state){

        final MutableLiveData<StateCabinet> result = new MutableLiveData<>();

        googleCivicService.getStateCabinet(state, true, "administrativeArea1", BuildConfig.GOOGLE_API_KEY).enqueue(new Callback<StateCabinet>() {
            @Override
            public void onResponse( Call<StateCabinet> call, Response<StateCabinet> response ) {
                if (response.isSuccessful()){
                    result.setValue(response.body());
                }else {
                    Log.d("Unsuccess Debug message", response.toString());
                }
            }

            @Override
            public void onFailure( Call<StateCabinet> call, Throwable t ) {
                result.setValue(null);
                Log.d("failure Debug message", t.getMessage());
            }
        });

        return result;
    }


    public LiveData<StateCabinet> getHeadOfCountry(){

        final MutableLiveData<StateCabinet> result = new MutableLiveData<>();

        googleCivicService.getHeadOfCountry().enqueue(new Callback<StateCabinet>() {
            @Override
            public void onResponse( Call<StateCabinet> call, Response<StateCabinet> response ) {
                if (response.isSuccessful()){
                    result.setValue(response.body());
                }else {
                    Log.d("Unsuccess Debug message", response.toString());
                }
            }

            @Override
            public void onFailure( Call<StateCabinet> call, Throwable t ) {
                result.setValue(null);
                Log.d("failure Debug message", t.getMessage());
            }
        });

        return result;

    }




}
