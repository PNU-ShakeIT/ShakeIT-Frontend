package com.example.pnu_front.peititon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.pnu_front.R;
import com.example.pnu_front.adapter.expirationadapter;

public class Petition_expiration extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition_expiration);
        RecyclerView expirationpt = findViewById(R.id.expirationpt);
        layoutManager = new LinearLayoutManager(this);
        expirationpt.setLayoutManager(layoutManager);
        String[] testtext = {"테","스","트","씨@발련아"};
        String[] testmember = {"모영민 외 30000명 동의" , "김효준 외 40000명 동의" , "심유성 외 1500명 동의" , "한성익 외 150명 동의"};
        adapter= new expirationadapter(testtext,testmember);
        expirationpt.setAdapter(adapter);

    }
}