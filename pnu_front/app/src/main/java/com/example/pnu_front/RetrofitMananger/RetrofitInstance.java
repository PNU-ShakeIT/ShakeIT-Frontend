package com.example.pnu_front.RetrofitMananger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;



public class RetrofitInstance {

    private static final String BASE_URL = "https://f502-113-131-34-157.jp.ngrok.io";

    public static RetrofitService getApiService(){


        return getInstance().create(RetrofitService.class);}


    private static Retrofit getInstance(){
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
 }

