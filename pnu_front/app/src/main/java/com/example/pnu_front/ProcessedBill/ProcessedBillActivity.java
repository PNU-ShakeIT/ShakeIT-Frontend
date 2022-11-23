package com.example.pnu_front.ProcessedBill;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.NoCopySpan;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.LawMaking.LawMakingActivity;
import com.example.pnu_front.LawMaking.LawMakingModel;
import com.example.pnu_front.MainActivity;
import com.example.pnu_front.ProgressDialog;
import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.adapter.LawmakingAdapter;
import com.example.pnu_front.adapter.ProcessedBillAdapter;
import com.example.pnu_front.profile.OnitemClick;
import com.example.pnu_front.profile.ProfileModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProcessedBillActivity extends AppCompatActivity implements OnitemClick {
    LawmakingAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Call<List<LawMakingModel>> call;
    List<LawMakingModel> result = new ArrayList<>();
    SearchView searchView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processedbill);
        TextView expiration = findViewById(R.id.lawmaking_expiration_btn2);
        FrameLayout Processed_Bill_list = findViewById(R.id.Processed_Bill_list);
        RecyclerView processedBillpt = findViewById(R.id.processedBillpt);
        layoutManager = new LinearLayoutManager(this);
        processedBillpt.setLayoutManager(layoutManager);
        searchView = findViewById(R.id.bill_searchview);
        View back = findViewById(R.id.processed_back);
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
        }, 2000); //딜레이 타임 조절



        expiration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProcessedBillActivity.this, LawMakingActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP);

                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProcessedBillActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });


        call = RetrofitInstance.getApiService().getLegislativeStatus();
        call.enqueue(new Callback<List<LawMakingModel>>() {
            @Override
            public void onResponse(Call<List<LawMakingModel>> call, Response<List<LawMakingModel>> response) {
                result = response.body();
                adapter = new LawmakingAdapter(getApplicationContext(), result, ProcessedBillActivity.this);
                processedBillpt.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<LawMakingModel>> call, Throwable t) {

            }
        });

    }

    private void filterList(String text) {
        List<LawMakingModel> filteredList = new ArrayList<>();
        for(LawMakingModel item : result){
            if(item.getBill_name().contains(text)){
                filteredList.add(item);
            }
        }

        if(filteredList.isEmpty()){
        } else {
            adapter.setFilteredList(filteredList);
        }
    }



    @Override
    public void onClick(int value) {
        String tmp = null;
        for (int k = 0; k < result.size(); k++) {
            if (Integer.parseInt(result.get(k).getId()) == value) {
                tmp = result.get(k).getLink();
            }
        }
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(tmp));
        startActivity(i);

    }
}
