package com.example.pnu_front.peititon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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
import com.example.pnu_front.adapter.processedadapter;
import com.example.pnu_front.profile.OnitemClick;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Petition_expiration extends AppCompatActivity implements OnitemClick {
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Call<List<ProcessedPetitionModel>> call;
    List<ProcessedPetitionModel> result = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition_expiration);
        FrameLayout processed_list = findViewById(R.id.processed_list);
        CardView list_detail = findViewById(R.id.processed_list_detail);
        ImageView imageView = findViewById(R.id.processed_listsizebtn);
        TextView status = findViewById(R.id.petition_processed_status);//0일때 평소 상태 1일때 확대 상태
        RecyclerView processedpt = findViewById(R.id.processedpt);
        Button processed_urlbtn = findViewById(R.id.processed_list_detail_urlbtn);
        status.setText("0");
        layoutManager = new LinearLayoutManager(this);
        processedpt.setLayoutManager(layoutManager);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.getText() == "0") {
                    ViewGroup.LayoutParams params = processed_list.getLayoutParams();
                    params.height = 1400;
                    processed_list.setLayoutParams(params);
                    list_detail.setVisibility(View.GONE);
                    imageView.setBackgroundResource(R.drawable.up_right);
                    status.setText("1");
                }
                else
                {
                    ViewGroup.LayoutParams params = processed_list.getLayoutParams();
                    params.height = 700;
                    processed_list.setLayoutParams(params);
                    list_detail.setVisibility(View.VISIBLE);
                    imageView.setBackgroundResource(R.drawable.down_right);
                    status.setText("0");

                }
            }
        });
        call = RetrofitInstance.getApiService().getProcessedPetition();
        call.enqueue(new Callback<List<ProcessedPetitionModel>>() {
            @Override
            public void onResponse(Call<List<ProcessedPetitionModel>> call, Response<List<ProcessedPetitionModel>> response) {
                result = response.body();
                adapter = new processedadapter(getApplicationContext(), result,Petition_expiration.this);
                processedpt.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ProcessedPetitionModel>> call, Throwable t) {

            }
        });

    }

    @Override
    public void onClick(int value) {
        FrameLayout proceed_list = findViewById(R.id.processed_list);
        CardView list_detail = findViewById(R.id.processed_list_detail);
        ImageView imageView = findViewById(R.id.processed_listsizebtn);
        TextView status = findViewById(R.id.petition_processed_status);//0일때 평소 상태 1일때 확대 상태
        ViewGroup.LayoutParams params = proceed_list.getLayoutParams();
        params.height =700;
        proceed_list.setLayoutParams(params);
        list_detail.setVisibility(View.VISIBLE);
        imageView.setBackgroundResource(R.drawable.down_right);
        status.setText("0");
        TextView title = findViewById(R.id.text_processed_list_detail_title);
        TextView num = findViewById(R.id.text_processed_list_detail_num);
        TextView proposer = findViewById(R.id.text_processed_list_detail_proposer);
        TextView approver = findViewById(R.id.text_processed_list_detail_approver);
        TextView pro_dt = findViewById(R.id.text_processed_list_detail_pro_dt);
        TextView committee = findViewById(R.id.text_processed_list_detail_curr_committee);
        title.setText(result.get(value).getName());
        num.setText(result.get(value).getNum());
        proposer.setText(result.get(value).getProposer());
        approver.setText(result.get(value).getApprover());
        pro_dt.setText(result.get(value).getPro_dt());
        committee.setText(result.get(value).getCurr_committee());

    }
}