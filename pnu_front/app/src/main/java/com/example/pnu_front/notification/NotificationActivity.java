package com.example.pnu_front.notification;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pnu_front.LawMaking.LawMakingModel;
import com.example.pnu_front.ProcessedBill.ProcessedBillActivity;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.adapter.LawmakingAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationActivity extends AppCompatActivity {
    Call<List<NotificationModel>> call;
    List<NotificationModel> result = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        call = RetrofitInstance.getApiService().getNotification();
        call.enqueue(new Callback<List<NotificationModel>>() {
            @Override
            public void onResponse(Call<List<NotificationModel>> call, Response<List<NotificationModel>> response) {
                result = response.body();
                //adapter = new LawmakingAdapter(getApplicationContext(), result, ProcessedBillActivity.this);
                //processedBillpt.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<NotificationModel>> call, Throwable t) {

            }
        });
    }
}
