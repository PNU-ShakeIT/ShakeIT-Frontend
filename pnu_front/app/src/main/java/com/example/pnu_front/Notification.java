package com.example.pnu_front;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.adapter.NotificationAdapter;
import com.example.pnu_front.adapter.profileadapter;
import com.example.pnu_front.profile.Profile;
import com.example.pnu_front.profile.ProfileModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Notification extends AppCompatActivity {
    RecyclerView.Adapter adapter;
    NotificationAdapter myadapter;
    RecyclerView.LayoutManager layoutManager;
    Call<List<ProfileModel>> call;
    List<ProfileModel> result = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        RecyclerView recyclerView = findViewById(R.id.recycler_notification);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        call = RetrofitInstance.getApiService().getCongressMember();
        call.enqueue(new Callback<List<ProfileModel>>() {
            @Override
            public void onResponse(Call<List<ProfileModel>> call, Response<List<ProfileModel>> response) {
                result = response.body();
                myadapter = new NotificationAdapter(result);
                recyclerView.setAdapter(myadapter);
            }

            @Override
            public void onFailure(Call<List<ProfileModel>> call, Throwable t) {

            }
        });

    }
}