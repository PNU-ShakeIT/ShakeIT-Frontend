package com.example.pnu_front.peititon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pnu_front.MainActivity;
import com.example.pnu_front.ProgressDialog;
import com.example.pnu_front.R;
//import com.example.pnu_front.RetrofitManager.ApiClient;
//import com.example.pnu_front.RetrofitManager.ApiInterface;
//import com.example.pnu_front.RetrofitManager.PetitionModel;
//import com.example.pnu_front.ViewManager.PetitionAdapter;

import java.util.ArrayList;
import java.util.List;

import com.example.pnu_front.RetrofitMananger.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Petition extends AppCompatActivity {

    Call<List<ProcessedPetitionModel>> callprocessed;
    List<ProcessedPetitionModel> ps_result = new ArrayList<>();

    Call<List<PendingPetitionModel>> call;
    List<PendingPetitionModel> result = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition);
        TextView progress = findViewById(R.id.progress_btn);
        TextView expiration = findViewById(R.id.expiration_btn);
        TextView proceed1 = findViewById(R.id.proceed_realtime_1);
        TextView proceed2 = findViewById(R.id.proceed_realtime_2);
        TextView proceed3 = findViewById(R.id.proceed_realtime_3);
        TextView proceed4 = findViewById(R.id.proceed_realtime_4);
        TextView pending1 = findViewById(R.id.pending_realtime_1);
        TextView pending2 = findViewById(R.id.pending_realtime_2);
        TextView pending3 = findViewById(R.id.pending_realtime_3);
        TextView pending4 = findViewById(R.id.pending_realtime_4);
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
        }, 3000); //딜레이 타임 조절


        ImageView titleImg = findViewById(R.id.imageView);

        View back = findViewById(R.id.pettion_back);

        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Petition.this , Petition_progress.class);
                startActivity(i);
            }
        });//진행중인 청원으로
        expiration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Petition.this , Petition_expiration.class);
                startActivity(i);
            }
        });//만료된 청원으로
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Petition.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        titleImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Petition.this , MainActivity.class);
                startActivity(i);
            }
        });
        call = RetrofitInstance.getApiService().getPendingPetition();
        call.enqueue(new Callback<List<PendingPetitionModel>>() {
            @Override
            public void onResponse(Call<List<PendingPetitionModel>> call, Response<List<PendingPetitionModel>> response) {
                result = response.body();
                proceed1.setText(result.get(0).getName());
                proceed2.setText(result.get(1).getName());
                proceed3.setText(result.get(2).getName());
                proceed4.setText(result.get(3).getName());
            }
            @Override
            public void onFailure(Call<List<PendingPetitionModel>> call, Throwable t) {
            }
        });

        callprocessed = RetrofitInstance.getApiService().getProcessedPetition();
        callprocessed.enqueue(new Callback<List<ProcessedPetitionModel>>() {
            @Override
            public void onResponse(Call<List<ProcessedPetitionModel>> call, Response<List<ProcessedPetitionModel>> response) {
                ps_result = response.body();
                pending1.setText(ps_result.get(0).getName());
                pending2.setText(ps_result.get(1).getName());
                pending3.setText(ps_result.get(2).getName());
                pending4.setText(ps_result.get(3).getName());
            }
            @Override
            public void onFailure(Call<List<ProcessedPetitionModel>> call, Throwable t) {

            }
        });

}
}