package com.example.pnu_front;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.pnu_front.Calender.Calender;
import com.example.pnu_front.peititon.Petition;

import com.example.pnu_front.profile.Profile;

import kotlin.collections.SlidingWindowKt;

public class MainActivity extends AppCompatActivity {
    boolean isPageOpen = false;
    Animation translateLeftAnim;
    Animation translateRightAnim;
    LinearLayout slidingPage01;
    View view1;
    RecyclerView recyclerView;
    MainAdapter adapter;

    //github push and pull

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View  calender = findViewById(R.id.calbtn);
        View profile = findViewById(R.id.profbtn);
        View petition = findViewById(R.id.petitionbtn);
        View lawmaking = findViewById(R.id.lawmakingbtn);
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Calender.class);
                startActivity(i);
            }
        });//calender로 이동
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Profile.class);
                startActivity(i);
            }
        });//profile로 이동
        petition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Petition.class);
                startActivity(i);
            }
        });//petition으로 이동
        lawmaking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, LawMakingActivity.class);
                startActivity(i);
            }
        });

        slidingPage01 = (LinearLayout) findViewById(R.id.sliding_page);
        view1 = (View) findViewById(R.id.menu_bar);

        translateLeftAnim = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(this, R.anim.treanslate_right);


        SlidingPageAnimationListener animationListener = new SlidingPageAnimationListener();
        translateLeftAnim.setAnimationListener(animationListener);
        translateRightAnim.setAnimationListener(animationListener);

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPageOpen) {
                    //애니메이션 시작
                    slidingPage01.startAnimation(translateLeftAnim);
                }
                //열기
                else {
                    slidingPage01.setVisibility(View.VISIBLE);
                    slidingPage01.startAnimation(translateRightAnim);
                }
            }
        });
        recyclerView = (RecyclerView)findViewById(R.id.news_notion);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL,false));
        adapter = new MainAdapter();

        for(int i = 0; i < 100; i++){
            adapter.setItem("김세훈 sexmachine 김세훈 sexmachine 김세훈 sexmachine 김세훈 sexmachine");
        }

        recyclerView.setAdapter(adapter);
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationEnd(Animation animation) {
            //슬라이드 열기->닫기
            if(isPageOpen){
                slidingPage01.setVisibility(View.INVISIBLE);
                isPageOpen = false;
            }
            //슬라이드 닫기->열기
            else{
                isPageOpen = true;
            }
        }
        @Override
        public void onAnimationRepeat(Animation animation) {

        }
        @Override
        public void onAnimationStart(Animation animation) {

        }
    }

}