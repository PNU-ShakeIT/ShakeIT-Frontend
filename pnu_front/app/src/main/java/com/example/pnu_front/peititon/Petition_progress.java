package com.example.pnu_front;

<<<<<<<<< Temporary merge branch 1
=========
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

>>>>>>>>> Temporary merge branch 2
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Petition_progress extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<<<< Temporary merge branch 1
        setContentView(R.layout.activity_petition);
=========
        setContentView(R.layout.activity_petition_progress);
        RecyclerView progress = findViewById(R.id.progresspt);
        layoutManager = new LinearLayoutManager(this);
        progress.setLayoutManager(layoutManager);
        String[] testtext = {"테","스","트","씨@발련아","발련아","T발련아","q발련아","rtr발련아"};
        String[] testmember = {"모영민 외 30000명 동의" , "김효준 외 40000명 동의" , "심유성 외 1500명 동의" , "한성익 외 150명 동의","김효준 외 40000명 동의" , "심유성 외 1500명 동의","모영민 외 30000명 동의" , "김효준 외 40000명 동의"};
        adapter= new expirationadapter(testtext,testmember);
        progress.setAdapter(adapter);
>>>>>>>>> Temporary merge branch 2
    }
}
