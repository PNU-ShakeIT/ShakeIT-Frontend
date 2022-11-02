package com.example.pnu_front;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.pnu_front.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    View drawerView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView calender = findViewById(R.id.calbtn);
        TextView profile = findViewById(R.id.profbtn);
        TextView petition = findViewById(R.id.petitionbtn);
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this ,Calender.class);
                startActivity(i);
            }
        });//calender로 이동
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , Profile.class);
                startActivity(i);
            }
        });//profile로 이동
        petition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , Petition.class);
                startActivity(i);
            }
        });//petition으로 이동


        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);

    }
}