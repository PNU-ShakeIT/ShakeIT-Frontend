package com.example.pnu_front;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class    Petition_progress extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition_progress);
        RecyclerView progress = findViewById(R.id.progresspt);
        layoutManager = new LinearLayoutManager(this);
        progress.setLayoutManager(layoutManager);
        String[] testtext = {"테","스","트","씨@발련아","발련아","T발련아","q발련아","rtr발련아"};
        String[] testmember = {"모영민 외 30000명 동의" , "김효준 외 40000명 동의" , "심유성 외 1500명 동의" , "한성익 외 150명 동의","김효준 외 40000명 동의" , "심유성 외 1500명 동의","모영민 외 30000명 동의" , "김효준 외 40000명 동의"};
        adapter= new expirationadapter(testtext,testmember);
        progress.setAdapter(adapter);
    }
}