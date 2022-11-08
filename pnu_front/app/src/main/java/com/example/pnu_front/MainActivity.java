package com.example.pnu_front;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.w3c.dom.Text;

import java.io.IOException;


import com.example.pnu_front.Calender.Calender;
import com.example.pnu_front.peititon.Petition;

import com.example.pnu_front.profile.Profile;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String article = "";
    String url = "";
    static ArrayList<String> urltmp = new ArrayList<>();
    boolean isPageOpen = false;
    static int tmp_int ;
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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Bundle bundle = new Bundle();
        View calender = findViewById(R.id.calbtn);
        View profile = findViewById(R.id.profbtn);
        View petition = findViewById(R.id.petitionbtn);
        View lawmaking = findViewById(R.id.lawmakingbtn);
        LinearLayout article_layout = findViewById(R.id.news_notion);
        TextView article01 = findViewById(R.id.article_01);
        TextView article02 = findViewById(R.id.article_02);
        TextView article03 = findViewById(R.id.article_03);
        TextView article04 = findViewById(R.id.article_04);
        TextView article05 = findViewById(R.id.article_05);
        TextView article06 = findViewById(R.id.article_06);
        TextView article07 = findViewById(R.id.article_07);
        TextView article08 = findViewById(R.id.article_08);
        TextView article09 = findViewById(R.id.article_09);

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
                Intent i = new Intent(MainActivity.this, com.example.pnu_front.LawMakingActivity.class);
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
        TextView tmpint = findViewById(R.id.tmpint);
        tmpint.setText("0");

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
                    Log.d("실패","실패실패실패실패실패실패실패실패실패실패실패");
                }
            }
        }.start();

        ImageView chatbot = findViewById(R.id.Chatbotbtn);
        chatbot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this , Chatbot.class);
                startActivity(i);
            }
        });
        article01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str =  urltmp.get(0);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(i);
            }
        });
        article02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str =  urltmp.get(1);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(i);
            }
        });
        article03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str =  urltmp.get(2);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(i);
            }
        });
        article04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str =  urltmp.get(3);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(i);
            }
        });
        article05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str =  urltmp.get(4);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(i);
            }
        });
        article06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str =  urltmp.get(5);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(i);
            }
        });
        article07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str =  urltmp.get(6);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(i);
            }
        });
        article08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str =  urltmp.get(7);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(i);
            }
        });
        article09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str =  urltmp.get(8);
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
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
                TextView article01 = findViewById(R.id.article_01);
                TextView article02 = findViewById(R.id.article_02);
                TextView article03 = findViewById(R.id.article_03);
                TextView article04 = findViewById(R.id.article_04);
                TextView article05 = findViewById(R.id.article_05);
                TextView article06 = findViewById(R.id.article_06);
                TextView article07 = findViewById(R.id.article_07);
                TextView article08 = findViewById(R.id.article_08);
                TextView article09 = findViewById(R.id.article_09);
                article01.setClickable(false);
                article02.setClickable(false);
                article03.setClickable(false);
                article04.setClickable(false);
                article05.setClickable(false);
                article06.setClickable(false);
                article07.setClickable(false);
                article08.setClickable(false);
                article09.setClickable(false);
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
            TextView tmpint = findViewById(R.id.tmpint);
            TextView article01 = findViewById(R.id.article_01);
            TextView article02 = findViewById(R.id.article_02);
            TextView article03 = findViewById(R.id.article_03);
            TextView article04 = findViewById(R.id.article_04);
            TextView article05 = findViewById(R.id.article_05);
            TextView article06 = findViewById(R.id.article_06);
            TextView article07 = findViewById(R.id.article_07);
            TextView article08 = findViewById(R.id.article_08);
            TextView article09 = findViewById(R.id.article_09);
            Bundle bundle = msg.getData();
            int temp ;
            String tempstr;
            tempstr = tmpint.getText().toString();
            temp = Integer.parseInt(tempstr);
            Log.d("asdfafafsfasdfa","1111111111111111111111"+tempstr+"진짜개씨발좆같네"+temp);
            if(temp-1 == 8)
            {
                 article01.setText(article_list.get(0));
                 article02.setText(article_list.get(1));
                 article03.setText(article_list.get(2));
                 article04.setText(article_list.get(3));
                 article05.setText(article_list.get(4));
                 article06.setText(article_list.get(5));
                 article07.setText(article_list.get(6));
                 article08.setText(article_list.get(7));
                 article09.setText(article_list.get(8));
                 urltmp = (ArrayList<String>) url_list.clone();
            }
            article_list = bundle.getStringArrayList("article");
            url_list = bundle.getStringArrayList("url");
            Log.d("ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ","1111111111111111111");
            temp++;
            tmpint.setText(Integer.toString(temp));
//            article_list.setText(bundle.getString("art"));
            //이런식으로 View를 메인 쓰레드에서 뿌려줘야한다.
        }
    };
}