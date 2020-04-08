package com.hands_on_android.lab4.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {
    private static ApiService SERVICE;

    private static void initialize() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        SERVICE = retrofit.create(ApiService.class);
    }

    public static ApiService getService() {
        if (SERVICE == null) {
            initialize();
        }
        return SERVICE;
    }
}
