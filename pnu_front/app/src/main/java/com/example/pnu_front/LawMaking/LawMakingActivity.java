package com.example.pnu_front.LawMaking;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

import com.example.pnu_front.MainActivity;
import com.example.pnu_front.ProcessedBill.ProcessedBillActivity;
import com.example.pnu_front.ProcessedBill.ProcessedBillModel;
import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.adapter.LawmakingAdapter;
import com.example.pnu_front.adapter.ProcessedBillAdapter;
import com.example.pnu_front.adapter.processedadapter;
import com.example.pnu_front.peititon.Petition_expiration;
import com.example.pnu_front.profile.OnitemClick;
import com.example.pnu_front.profile.ProfileModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LawMakingActivity extends AppCompatActivity implements OnitemClick
{
    ProcessedBillAdapter adapter;
    RecyclerView.LayoutManager layoutManager;
    Call<List<ProcessedBillModel>> call;
    List<ProcessedBillModel> result = new ArrayList<>();
    SearchView searchView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawmaking);
        FrameLayout bill_list = findViewById(R.id.bill_list);
        RecyclerView processedBillpt = findViewById(R.id.processedBillpt);
        layoutManager = new LinearLayoutManager(this);
        processedBillpt.setLayoutManager(layoutManager);
        TextView progress = findViewById(R.id.lawmaking_progress_btn1);
        View back = findViewById(R.id.lawmaking_back);

        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LawMakingActivity.this, ProcessedBillActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LawMakingActivity.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
        searchView = findViewById(R.id.bill_searchview);
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

        call = RetrofitInstance.getApiService().getBill();
        call.enqueue(new Callback<List<ProcessedBillModel>>() {
            @Override
            public void onResponse(Call<List<ProcessedBillModel>> call, Response<List<ProcessedBillModel>> response) {
                result = response.body();
                adapter = new ProcessedBillAdapter(getApplicationContext(), result , LawMakingActivity.this);
                System.out.println(result.get(8).getUrl());
                processedBillpt.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ProcessedBillModel>> call, Throwable t) {

            }
        });

    }

    private void filterList(String text) {
        List<ProcessedBillModel> filteredList = new ArrayList<>();
        for(ProcessedBillModel item : result){
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
                tmp = result.get(k).getUrl();
            }
        }
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(tmp));
        startActivity(i);

    }
}