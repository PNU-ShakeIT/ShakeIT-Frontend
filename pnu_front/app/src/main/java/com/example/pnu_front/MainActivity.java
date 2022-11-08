package com.example.pnu_front;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


import com.example.pnu_front.Calender.Calender;
import com.example.pnu_front.peititon.Petition;

import com.example.pnu_front.profile.Profile;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String article = "";
    String url = "";
    boolean isPageOpen = false;
    Animation translateLeftAnim;
    Animation translateRightAnim;
    LinearLayout slidingPage01;
    View view1;
    RecyclerView recyclerView;
    MainAdapter adapter;
    EditText editText;
    ArrayList<String> article_list = new ArrayList<>();
    ArrayList<String> url_list = new ArrayList<>();
    ArrayList<String> search_list = new ArrayList<>();
    ArrayList<String> original_list = new ArrayList<>();

    //github push and pull

    protected void onCreate(Bundle savedInstanceState) {
        final Bundle bundle = new Bundle();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View calender = findViewById(R.id.calbtn);
        View profile = findViewById(R.id.profbtn);
        View petition = findViewById(R.id.petitionbtn);
        View lawmaking = findViewById(R.id.lawmakingbtn);
        recyclerView = (RecyclerView) findViewById(R.id.news_notion);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));

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

        new Thread(){
            @Override
            public void run() {
                Document doc;
                try {
                    String URL = "http://www.a-news.co.kr/news/articleList.html";
                    doc = Jsoup.connect(URL).get();

                    Elements elem = doc.select("td[class=\" ArtList_Title\"]");
                    // class dv_input인 a 태그 전부 찾음
                    //Element els = doc.select(".dv_input a").get(0); //get(i)를통해 몇번째 요소 가져올수 있음
                    //Elements elem = doc.select("td.pl");

                    for(Element e: elem.select("td")) {
                        System.out.println(e.text());
                        article_list.add(e.text());
                        url_list.add("http://www.a-news.co.kr/news/"+e.getElementsByAttribute("href").attr("href"));


                        bundle.putStringArrayList("article",article_list);//핸들러를 이용해서 Thread()에서 가져온 데이터를 메인 쓰레드에 보내준다.
                        bundle.putStringArrayList("url",url_list);
                        Message msg = handler.obtainMessage();
                        msg.setData(bundle);
                        handler.sendMessage(msg);

                    }



                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }.start();







        editText = findViewById(R.id.search_text);

        // editText 리스터 작성
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                String searchText = editText.getText().toString();
//                search_list.clear();
//
//                if (searchText.equals("")) {
//                    adapter.setItems(original_list);
//                } else {
//                    // 검색 단어를 포함하는지 확인
//                    for (int a = 0; a < original_list.size(); a++) {
//                        if (original_list.get(a).toLowerCase().contains(searchText.toLowerCase())) {
//                            search_list.add(original_list.get(a));
//                        }
//                        adapter.setItems(search_list);
//                    }
//                }
//            }
//        });



        ImageView chatbot = findViewById(R.id.Chatbotbtn);
        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , Chatbot.class);
                startActivity(i);
            }
        });
    }

    private class SlidingPageAnimationListener implements Animation.AnimationListener {
        @Override
        public void onAnimationEnd(Animation animation) {
            //슬라이드 열기->닫기
            if (isPageOpen) {
                slidingPage01.setVisibility(View.INVISIBLE);
                isPageOpen = false;
            }
            //슬라이드 닫기->열기
            else {
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

    @Override
    protected void onResume() {
        super.onResume();
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Bundle bundle = msg.getData();
            String tmp;
            int p = 0;
            article_list = bundle.getStringArrayList("article");
            url_list = bundle.getStringArrayList("url");

            tmp = bundle.getString("art");
            Log.d("qwqwerqwerqwer",""+article_list + url_list);
            recyclerView = (RecyclerView) findViewById(R.id.news_notion);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false));
            adapter = new MainAdapter(article_list,url_list,MainActivity.this);
            adapter.setItems(article_list);
            recyclerView.setAdapter(adapter);
//            article_list.setText(bundle.getString("art"));
            //이런식으로 View를 메인 쓰레드에서 뿌려줘야한다.
        }
    };
}