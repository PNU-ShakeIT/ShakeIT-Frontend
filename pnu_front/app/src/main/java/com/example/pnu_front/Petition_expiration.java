package com.example.pnu_front;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;

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
        String[] testtext = {"테","스","트"};
//        adapter= new expirationadapter(testtext);
//        expirationpt.setAdapter(adapter);

    }
}