package com.example.pnu_front.notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pnu_front.Chatbot;
import com.example.pnu_front.MainActivity;
import com.example.pnu_front.ProgressDialog;
import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.adapter.NotificationAdapter;
import com.example.pnu_front.adapter.profileadapter;
import com.example.pnu_front.notification.NotificationModel;
import com.example.pnu_front.profile.Profile;
import com.example.pnu_front.profile.ProfileModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Notification extends AppCompatActivity {
    NotificationAdapter myadapter;
    RecyclerView.LayoutManager layoutManager;
    Call<List<NotificationModel>> call;
    List<NotificationModel> result = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        RecyclerView recyclerView = findViewById(R.id.recycler_notification);
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        progressDialog.setCancelable(false);
        progressDialog.show();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, 1300); //딜레이 타임 조절

        View backbtn = findViewById(R.id.notification_backbtn);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notification.this , MainActivity.class);
                startActivity(i);
            }
        });
        ImageView chatbot = findViewById(R.id.notification_Chatbotbtn);
        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Notification.this , Chatbot.class);
                startActivity(i);
            }
        });

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        call = RetrofitInstance.getApiService().getNotification();
        call.enqueue(new Callback<List<NotificationModel>>() {
            @Override
            public void onResponse(Call<List<NotificationModel>> call, Response<List<NotificationModel>> response) {
                result = response.body();
                myadapter = new NotificationAdapter(getApplicationContext(),result);
                recyclerView.setAdapter(myadapter);
            }

            @Override
            public void onFailure(Call<List<NotificationModel>> call, Throwable t) {

            }
        });

    }
}