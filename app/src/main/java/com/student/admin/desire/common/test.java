package com.student.admin.desire.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.student.admin.desire.datagetter.listofnews;
import com.student.admin.desire.datagetter.loginresponse;
import com.student.admin.desire.login;
import com.student.admin.desire.noticeboard;
import com.student.admin.desire.webservice.api;
import com.student.admin.desire.webservice.network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class test {


    public test( ) {

      }

    public  void  Login(final String s, String s1, final Context applicationContext) {




    }

    public  void   register(String s, String s1) {
        String  sg= s;

    }


    public   String   Register(String s, String s1) {


        return  s;

    }


    public void noticeboard(final RecyclerView recyclerView, final Context context) {

        final api  mApiService =  network.getRetrofit().create(api.class) ;
        Call<listofnews> call = mApiService.noticeboard();
        call.enqueue(new Callback<listofnews>() {
            @Override
            public void onResponse(Call<listofnews> call, Response<listofnews> response) {
//                String sg  =response.body().getResponse().getResponse_message();

                System.out.println( call.request().url());
                noticeboard login=new noticeboard();
                login.noticedata(response.body(),context,recyclerView);
            }


            @Override
            public void onFailure(Call<listofnews> call, Throwable t) {

                System.out.println( call.request().url());
                Log.d("Error", t.getMessage());

            }
        });


    }









}
