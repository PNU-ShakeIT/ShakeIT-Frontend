package com.example.pnu_front.peititon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.pnu_front.adapter.expirationadapter;

public class Petition_progress extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Call<List<PendingPetitionModel>> call;
    List<PendingPetitionModel> result = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition_progress);
        RecyclerView progress = findViewById(R.id.progresspt);
        layoutManager = new LinearLayoutManager(this);
        progress.setLayoutManager(layoutManager);

        call = RetrofitInstance.getApiService().getPendingPetition();
        call.enqueue(new Callback<List<PendingPetitionModel>>() {
            @Override
            public void onResponse(Call<List<PendingPetitionModel>> call, Response<List<PendingPetitionModel>> response) {
                result = response.body();
                adapter = new expirationadapter(getApplicationContext(), result);
                progress.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PendingPetitionModel>> call, Throwable t) {
                Log.d("qwer","씨@@@@@@@@@@@@@@@@@@@@@@@발왜안되는데");

            }
        });
    }
}
