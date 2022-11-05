package com.example.pnu_front.peititon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pnu_front.peititon.*;
import com.example.pnu_front.R;
//import com.example.pnu_front.RetrofitManager.ApiClient;
//import com.example.pnu_front.RetrofitManager.ApiInterface;
//import com.example.pnu_front.RetrofitManager.PetitionModel;
//import com.example.pnu_front.ViewManager.PetitionAdapter;

import java.util.List;

import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.profile.ProfileModel;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Petition extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition);

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