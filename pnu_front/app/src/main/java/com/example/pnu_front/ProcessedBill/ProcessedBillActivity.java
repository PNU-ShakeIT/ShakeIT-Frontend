package com.example.pnu_front.ProcessedBill;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.NoCopySpan;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.LawMaking.LawMakingModel;
import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.adapter.LawmakingAdapter;
import com.example.pnu_front.adapter.ProcessedBillAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProcessedBillActivity extends AppCompatActivity {
    LawmakingAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Call<List<LawMakingModel>> call;
    List<LawMakingModel> result = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processedbill);
        FrameLayout Processed_Bill_list = findViewById(R.id.Processed_Bill_list);
        RecyclerView processedBillpt = findViewById(R.id.processedBillpt);
        layoutManager = new LinearLayoutManager(this);
        processedBillpt.setLayoutManager(layoutManager);

        call = RetrofitInstance.getApiService().getLegislativeStatus();
        call.enqueue(new Callback<List<LawMakingModel>>() {
            @Override
            public void onResponse(Call<List<LawMakingModel>> call, Response<List<LawMakingModel>> response) {
                result = response.body();
                adapter = new LawmakingAdapter(getApplicationContext(), result);
                processedBillpt.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<LawMakingModel>> call, Throwable t) {

            }
        });

    }
}
