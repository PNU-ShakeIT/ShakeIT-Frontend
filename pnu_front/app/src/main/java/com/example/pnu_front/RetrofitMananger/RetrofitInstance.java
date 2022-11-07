package com.example.pnu_front.RetrofitMananger;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Header;


public class RetrofitInstance {

    private static final String BASE_URL = "https://1485-164-125-221-236.jp.ngrok.io";

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

