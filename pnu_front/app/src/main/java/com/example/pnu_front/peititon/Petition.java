package com.example.pnu_front.peititon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pnu_front.Petition_expiration;
import com.example.pnu_front.Petition_progress;
import com.example.pnu_front.R;

import java.util.List;

import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.profile.ProfileModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Petition extends AppCompatActivity {
    Call<List<ProfileModel>> call;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition);

        call = RetrofitInstance.getApiService().getPosts("황희");
        call.enqueue(new Callback<List<ProfileModel>>() {
            @Override
            public void onResponse(Call<List<ProfileModel>> call, Response<List<ProfileModel>> response) {
                List<ProfileModel> result = response.body();
                String str = result.toString();
                //textView.setText(str);
            }

            @Override
            public void onFailure(Call<List<ProfileModel>> call, Throwable t) {

            }
        });
        TextView progress = findViewById(R.id.progress_btn);
        TextView expiration = findViewById(R.id.expiration_btn);
        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Petition.this , Petition_progress.class);
                startActivity(i);
            }
        });
        expiration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Petition.this , Petition_expiration.class);
                startActivity(i);
            }
        });
    }
}