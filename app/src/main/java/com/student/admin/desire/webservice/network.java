package com.student.admin.desire.webservice;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class  network {



    private static Retrofit retrofit;

    public   network(){

    }

    public static Retrofit getRetrofit(){

        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Url.BASE_URL_NEW)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit;
    }
}

