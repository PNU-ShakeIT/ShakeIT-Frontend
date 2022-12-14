package com.example.pnu_front.peititon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pnu_front.ProgressDialog;
import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.pnu_front.adapter.pendingadapter;
import com.example.pnu_front.adapter.processedadapter;
import com.example.pnu_front.profile.OnitemClick;

public class Petition_progress extends AppCompatActivity implements OnitemClick {

    RecyclerView recyclerView;
    pendingadapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Call<List<PendingPetitionModel>> call;
    List<PendingPetitionModel> result = new ArrayList<>();
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        progressDialog.setCancelable(false);
        progressDialog.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, 1300); //딜레이 타임 조절


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
        View back = findViewById(R.id.pet_prog_back);
        searchView = findViewById(R.id.petition_searchview);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fileterList(newText);
                return false;
            }
        });
        final int wide_height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 500, getResources().getDisplayMetrics());
        final int small_height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 220, getResources().getDisplayMetrics());
        ViewGroup.LayoutParams params = proceed_list.getLayoutParams();
        params.height = wide_height;
        proceed_list.setLayoutParams(params);
        list_detail.setVisibility(View.GONE);
        imageView.setBackgroundResource(R.drawable.up_right);
        status.setText("1");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Petition_progress.this, Petition.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        status.setText("0");
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.getText() == "0") {
                    ViewGroup.LayoutParams params = proceed_list.getLayoutParams();
                    params.height = wide_height;
                    proceed_list.setLayoutParams(params);
                    list_detail.setVisibility(View.GONE);
                    imageView.setBackgroundResource(R.drawable.up_right);
                    status.setText("1");
                }
                else
                {
                    ViewGroup.LayoutParams params = proceed_list.getLayoutParams();
                    params.height = small_height;
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

                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(str));
                startActivity(i);
            }
        });
    }

    private void fileterList(String text) {
        List<PendingPetitionModel> filteredList = new ArrayList<>();
        for(PendingPetitionModel item : result){
            if(item.getName().contains(text)){
                filteredList.add(item);
            }
            if(item.getProposer().contains(text)){
                filteredList.add(item);
            }
        }
        if(filteredList.isEmpty()){
            //Toast.makeText(this, "입력된 정보가 없습니다", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setFilteredList(filteredList);
        }
    }

    @Override
    public void onClick(int value) {
        final int small_height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 220, getResources().getDisplayMetrics());

        TextView urltmp = findViewById(R.id.proceed_urltmp);
        urltmp.setText(result.get(value).getUrl());
        FrameLayout proceed_list = findViewById(R.id.proceed_list);
        CardView list_detail = findViewById(R.id.proceed_list_detail);
        ImageView imageView = findViewById(R.id.proceed_listsizebtn);
        TextView status = findViewById(R.id.petition_proceed_status);//0일때 평소 상태 1일때 확대 상태
        ViewGroup.LayoutParams params = proceed_list.getLayoutParams();
        params.height =small_height;
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
        num.setText("제안인 = "+result.get(value).getNum());
        proposer.setText("승인자 = "+result.get(value).getProposer());
        approver.setText("청원번호 = "+result.get(value).getApprover());
        pro_dt.setText("신청년도 = "+result.get(value).getPro_dt());
        committee.setText("제안한 곳 = "+result.get(value).getCurr_committee());
    }
}
