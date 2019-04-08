package com.student.admin.desire.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetroClient {


    private static final String ROOT_URL = "http://www.dneers.com/academyapp/";


    public RetroClient() {


    }

    private static Retrofit getRetroClient() {

        return new Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }

        public static api getApiService() {
        return getRetroClient().create(api.class);
         }

}
