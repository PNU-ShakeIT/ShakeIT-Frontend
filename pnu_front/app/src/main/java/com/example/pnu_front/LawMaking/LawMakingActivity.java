package com.example.pnu_front.LawMaking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.ProcessedBill.ProcessedBillModel;
import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.adapter.LawmakingAdapter;
import com.example.pnu_front.adapter.ProcessedBillAdapter;
import com.example.pnu_front.adapter.processedadapter;
import com.example.pnu_front.peititon.Petition;
import com.example.pnu_front.peititon.Petition_expiration;
import com.example.pnu_front.peititon.Petition_progress;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LawMakingActivity extends AppCompatActivity {
    ProcessedBillAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Call<List<ProcessedBillModel>> call;
    List<ProcessedBillModel> result = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawmaking);

        TextView progress = findViewById(R.id.progress_btn);
        TextView expiration = findViewById(R.id.expiration_btn);
        FrameLayout bill_list = findViewById(R.id.bill_list);
        RecyclerView processedBillpt = findViewById(R.id.processedBillpt);
        layoutManager = new LinearLayoutManager(this);
        processedBillpt.setLayoutManager(layoutManager);

        call = RetrofitInstance.getApiService().getBill();
        call.enqueue(new Callback<List<ProcessedBillModel>>() {
            @Override
            public void onResponse(Call<List<ProcessedBillModel>> call, Response<List<ProcessedBillModel>> response) {
                result = response.body();
                adapter = new ProcessedBillAdapter(getApplicationContext(), result);
                processedBillpt.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ProcessedBillModel>> call, Throwable t) {

            }
        });

        expiration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LawMakingActivity.this, Fragment1.class)
            }
        });
        public void onClick(View v) {
            Intent i = new Intent(Petition.this , Petition_progress.class);
            startActivity(i);
        }

    }
}