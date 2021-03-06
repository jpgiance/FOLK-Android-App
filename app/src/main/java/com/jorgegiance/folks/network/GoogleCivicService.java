package com.jorgegiance.folks.network;

import com.jorgegiance.folks.BuildConfig;
import com.jorgegiance.folks.models.googlecivicModels.StateCabinet;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface GoogleCivicService {

    @Headers("Accept: application/json")
    @GET("representatives")
    Call<StateCabinet> getStateCabinet(
            @Query("address") String state,
            @Query("includeOffices") boolean offices,
            @Query("levels") String levels,
            @Query("key") String apiKey
    );

    @Headers("Accept: application/json")
    @GET("representatives")
    Call<StateCabinet> getLocalOfficials(
            @Query("address") String address,
            @Query("includeOffices") boolean offices,
            @Query("levels") String locality,
            @Query("levels") String levels,
            @Query("key") String apiKey
    );

    @Headers("Accept: application/json")
    @GET("representatives")
    Call<StateCabinet> getLocalRepresentative(
            @Query("address") String address,
            @Query("includeOffices") boolean offices,
            @Query("roles") String role,
            @Query("key") String apiKey
    );

    @Headers("Accept: application/json")
    @GET("representatives/ocd-division%2Fcountry%3Aus?levels=country&roles=deputyHeadOfGovernment&roles=headOfGovernment&key=" + BuildConfig.GOOGLE_API_KEY)
    Call<StateCabinet> getHeadOfCountry();



}
