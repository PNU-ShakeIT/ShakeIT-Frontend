package com.example.pnu_front.pushAlerm;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;

// MyFirebaseMessagingService.class
public class MyFirebaseMessagingService extends FirebaseMessagingService {
    @Override
    public void onNewToken(String token){
        Log.d("FCM Log", "Refreshed token: "+token);
    }
}