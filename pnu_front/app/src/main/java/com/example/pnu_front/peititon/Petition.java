package com.example.pnu_front.peititon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pnu_front.adapter.expirationadapter;
import com.example.pnu_front.peititon.*;
import com.example.pnu_front.R;
//import com.example.pnu_front.RetrofitManager.ApiClient;
//import com.example.pnu_front.RetrofitManager.ApiInterface;
//import com.example.pnu_front.RetrofitManager.PetitionModel;
//import com.example.pnu_front.ViewManager.PetitionAdapter;

import java.util.ArrayList;
import java.util.List;

import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.profile.ProfileModel;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Petition extends AppCompatActivity {

    Call<List<ProcessedPetitionModer>> callprocessed;
    List<ProcessedPetitionModer> processedresult = new ArrayList<>();

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
        callprocessed.enqueue(new Callback<List<ProcessedPetitionModer>>() {
            @Override
            public void onResponse(Call<List<ProcessedPetitionModer>> call, Response<List<ProcessedPetitionModer>> response) {
                processedresult = response.body();
                Log.d("testetstetstsetst",""+processedresult);
                pending1.setText(processedresult.get(0).getName());
                pending2.setText(processedresult.get(1).getName());
                pending3.setText(processedresult.get(2).getName());
                pending4.setText(processedresult.get(3).getName());

            }

            @Override
            public void onFailure(Call<List<ProcessedPetitionModer>> call, Throwable t) {

            }
        });

}
}