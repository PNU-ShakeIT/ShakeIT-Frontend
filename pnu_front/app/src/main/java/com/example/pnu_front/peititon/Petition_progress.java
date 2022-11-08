package com.example.pnu_front.peititon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.pnu_front.adapter.pendingadapter;
import com.example.pnu_front.profile.OnitemClick;

public class Petition_progress extends AppCompatActivity implements OnitemClick {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Call<List<PendingPetitionModel>> call;
    List<PendingPetitionModel> result = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_petition_progress);
        RecyclerView progress = findViewById(R.id.progresspt);
        layoutManager = new LinearLayoutManager(this);
        progress.setLayoutManager(layoutManager);
        TextView urltmp = findViewById(R.id.proceed_urltmp);
        FrameLayout proceed_list = findViewById(R.id.proceed_list);
        CardView list_detail = findViewById(R.id.proceed_list_detail);
        ImageView imageView = findViewById(R.id.proceed_listsizebtn);
        TextView status = findViewById(R.id.petition_proceed_status);//0일때 평소 상태 1일때 확대 상태
        Button proceed_urlbtn = findViewById(R.id.proceed_list_detail_urlbtn);
        status.setText("0");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("testst",""+status.getText());
                if(status.getText() == "0") {
                    ViewGroup.LayoutParams params = proceed_list.getLayoutParams();
                    params.height = 1400;
                    proceed_list.setLayoutParams(params);
                    list_detail.setVisibility(View.GONE);
                    imageView.setBackgroundResource(R.drawable.up_right);
                    status.setText("1");
                }
                else
                {
                    ViewGroup.LayoutParams params = proceed_list.getLayoutParams();
                    params.height = 700;
                    proceed_list.setLayoutParams(params);
                    list_detail.setVisibility(View.VISIBLE);
                    imageView.setBackgroundResource(R.drawable.down_right);
                    status.setText("0");

                }
            }
        });


        call = RetrofitInstance.getApiService().getPendingPetition();
        call.enqueue(new Callback<List<PendingPetitionModel>>() {
            @Override
            public void onResponse(Call<List<PendingPetitionModel>> call, Response<List<PendingPetitionModel>> response) {
                result = response.body();
                adapter = new pendingadapter(getApplicationContext(), result,Petition_progress.this);
                progress.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<PendingPetitionModel>> call, Throwable t) {

            }
        });
        proceed_urlbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str =  urltmp.getText().toString();
                Log.d("url",""+str);

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(i);
//                Log.d("url",""+i);
//                context.startActivity(i);
            }
        });
    }

    @Override
    public void onClick(int value) {
        TextView urltmp = findViewById(R.id.proceed_urltmp);
        urltmp.setText(result.get(value).getUrl());
        Log.d("testestest",""+urltmp.getText());
        FrameLayout proceed_list = findViewById(R.id.proceed_list);
        CardView list_detail = findViewById(R.id.proceed_list_detail);
        ImageView imageView = findViewById(R.id.proceed_listsizebtn);
        TextView status = findViewById(R.id.petition_proceed_status);//0일때 평소 상태 1일때 확대 상태
        ViewGroup.LayoutParams params = proceed_list.getLayoutParams();
        params.height =700;
        proceed_list.setLayoutParams(params);
        list_detail.setVisibility(View.VISIBLE);
        imageView.setBackgroundResource(R.drawable.down_right);
        status.setText("0");
        TextView title = findViewById(R.id.text_proceed_detail_title);
        TextView num = findViewById(R.id.text_proceed_list_detail_num);
        TextView proposer = findViewById(R.id.text_proceed_list_detail_proposer);
        TextView approver = findViewById(R.id.text_proceed_list_detail_approver);
        TextView pro_dt = findViewById(R.id.text_proceed_list_detail_pro_dt);
        TextView committee = findViewById(R.id.text_proceed_list_detail_curr_committee);
        title.setText(result.get(value).getName());
        num.setText(result.get(value).getNum());
        proposer.setText(result.get(value).getProposer());
        approver.setText(result.get(value).getApprover());
        pro_dt.setText(result.get(value).getPro_dt());
        committee.setText(result.get(value).getCurr_committee());
    }
}
