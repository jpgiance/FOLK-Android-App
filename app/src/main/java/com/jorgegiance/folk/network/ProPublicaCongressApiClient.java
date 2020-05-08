package com.jorgegiance.folk.network;

import com.jorgegiance.folk.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProPublicaCongressApiClient {

    private static final String BASE_URL = "https://api.propublica.org/congress/v1/";

    private static Retrofit retrofit;

    public static Retrofit getApiClient(){

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}
