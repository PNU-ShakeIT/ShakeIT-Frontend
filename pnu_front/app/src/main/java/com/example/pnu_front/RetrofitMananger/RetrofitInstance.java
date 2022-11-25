package com.example.pnu_front.RetrofitMananger;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitInstance {

    private static final String BASE_URL = "http://52.79.155.82:8080/";

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

