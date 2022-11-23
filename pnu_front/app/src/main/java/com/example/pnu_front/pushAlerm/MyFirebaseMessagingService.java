package com.example.pnu_front.pushAlerm;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.example.pnu_front.MainActivity;
import com.example.pnu_front.ProcessedBill.ProcessedBillModel;
import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

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
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage){
        System.out.println("111111111");
        if(remoteMessage.getData().size() > 0){
            System.out.println("22222222");
            Log.d("FCM Log","message: "+remoteMessage.getData());
            String messageBody = remoteMessage.getData().get("content");
            String messageTitle = remoteMessage.getData().get("title");
            System.out.println(messageBody + messageTitle);
//            //푸시알림 링크 설정
            Intent intent = new Intent(this, MainActivity.class);


            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(this,0, intent , PendingIntent.FLAG_ONE_SHOT);
            String channelId = "Channel ID";
//
            NotificationCompat.Builder notificationBuilder =
                    new NotificationCompat.Builder(this, channelId)
                            .setSmallIcon(R.mipmap.ic_launcher)
                            .setContentTitle(messageTitle)
                            .setContentText(messageBody)
                            .setAutoCancel(true)
                            .setVibrate(new long[]{1000, 1000})
                            .setLights(Color.BLUE,500,2000)
                            .setContentIntent(pendingIntent)
                    ;

            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                String channelName = "Channel Name";
                NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
                notificationManager.createNotificationChannel(channel);
            }
            notificationManager.notify(0, notificationBuilder.build());
        }
    }

}