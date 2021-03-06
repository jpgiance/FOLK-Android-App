package com.jorgegiance.folks.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.jorgegiance.folks.BuildConfig;
import com.jorgegiance.folks.models.googlecivicModels.StateCabinet;
import com.jorgegiance.folks.models.propublicaModels.ProPublicaApiResult;
import com.jorgegiance.folks.models.propublicaModels.Member;
import com.jorgegiance.folks.network.GoogleCivicInformationApiClient;
import com.jorgegiance.folks.network.GoogleCivicService;
import com.jorgegiance.folks.network.ProPublicaService;
import com.jorgegiance.folks.network.ProPublicaCongressApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {


    private ProPublicaService proPublicaService;
    private GoogleCivicService googleCivicService;
    private Application application;

    public AppRepository( Application application ) {

        this.application = application;
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
                }
            }

            @Override
            public void onFailure( Call<ProPublicaApiResult> call, Throwable t ) {
                senatorsList.setValue(null);
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
                }
            }

            @Override
            public void onFailure( Call<ProPublicaApiResult> call, Throwable t ) {
                representativesList.setValue(null);
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
                }
            }

            @Override
            public void onFailure( Call<StateCabinet> call, Throwable t ) {
                result.setValue(null);
            }
        });

        return result;
    }


    public LiveData<StateCabinet> getLocalOfficials( String address){

        final MutableLiveData<StateCabinet> result = new MutableLiveData<>();

        googleCivicService.getLocalOfficials(address, true, "locality","administrativeArea2", BuildConfig.GOOGLE_API_KEY).enqueue(new Callback<StateCabinet>() {
            @Override
            public void onResponse( Call<StateCabinet> call, Response<StateCabinet> response ) {
                if (response.isSuccessful()){
                    result.setValue(response.body());
                }else {
                }
            }

            @Override
            public void onFailure( Call<StateCabinet> call, Throwable t ) {
                result.setValue(null);
            }
        });

        return result;
    }


    public LiveData<StateCabinet> getLocalRepresentative( String address){

        final MutableLiveData<StateCabinet> result = new MutableLiveData<>();

        googleCivicService.getLocalRepresentative(address, true, "legislatorLowerBody", BuildConfig.GOOGLE_API_KEY).enqueue(new Callback<StateCabinet>() {
            @Override
            public void onResponse( Call<StateCabinet> call, Response<StateCabinet> response ) {
                if (response.isSuccessful()){
                    result.setValue(response.body());
                }else {
                }
            }

            @Override
            public void onFailure( Call<StateCabinet> call, Throwable t ) {
                result.setValue(null);
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
                }
            }

            @Override
            public void onFailure( Call<StateCabinet> call, Throwable t ) {
                result.setValue(null);
            }
        });

        return result;

    }




}
