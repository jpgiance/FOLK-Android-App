package com.jorgegiance.folk.network;

import com.jorgegiance.folk.BuildConfig;
import com.jorgegiance.folk.models.ProPublicaApiResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ProPublicaService {

    @Headers(BuildConfig.PROPUBLICA_API_KEY)
    @GET("116/senate/members.json")
    Call<ProPublicaApiResult> getAllSenate();


    @Headers(BuildConfig.PROPUBLICA_API_KEY)
    @GET("116/house/members.json")
    Call<ProPublicaApiResult> getAllCongress();



}

