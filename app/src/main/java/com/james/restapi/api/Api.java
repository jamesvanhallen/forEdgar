package com.james.restapi.api;

import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {

    private static Api api;

    private Api(){

    }

    public static Api getInstance(){

        if(api!=null) return api;
        api= new Api();

        return api;
    }

    public OkHttpClient getOkHttpClient(){
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(loggingInterceptor);
        return client.build();
    }

    public ApiInterface getApiInterface(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://basis.myseldon.com/ru/")
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(ApiInterface.class);
    }

}
