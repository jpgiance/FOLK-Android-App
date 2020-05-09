package com.jorgegiance.folk.network;

import com.jorgegiance.folk.BuildConfig;
import com.jorgegiance.folk.models.propublicaModels.ProPublicaApiResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ProPublicaService {

    @Headers(BuildConfig.PROPUBLICA_API_KEY)
    @GET("116/senate/members.json")
    Call<ProPublicaApiResult> getAllSenate();

    @Headers(BuildConfig.PROPUBLICA_API_KEY)
    @GET("116/house/members.json")
    Call<ProPublicaApiResult> getAllRepresentatives();

    @Headers(BuildConfig.PROPUBLICA_API_KEY)
    @GET("members/senate/{state}/current.json")
    Call<ProPublicaApiResult> getSenateByState(@Path ("state") String state);

    @Headers(BuildConfig.PROPUBLICA_API_KEY)
    @GET("members/house/{state}/current.json")
    Call<ProPublicaApiResult> getRepresentativeByState( @Path ("state") String state);



}
