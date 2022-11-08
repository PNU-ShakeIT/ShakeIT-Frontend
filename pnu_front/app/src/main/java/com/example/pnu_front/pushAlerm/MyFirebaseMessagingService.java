package com.example.pnu_front.pushAlerm;

import android.util.Log;

import com.example.pnu_front.ProcessedBill.ProcessedBillModel;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// MyFirebaseMessagingService.class
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String token){

        Log.d("FCM Log", "Refreshed token: "+token);
        Call<String> result = RetrofitInstance.getApiService().insertToken(token);
        result.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String result = response.body();
                System.out.println(result);
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }

}