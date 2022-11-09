package com.example.pnu_front.ProcessedBill;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.NoCopySpan;
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
import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.adapter.LawmakingAdapter;
import com.example.pnu_front.adapter.ProcessedBillAdapter;
import com.example.pnu_front.profile.ProfileModel;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProcessedBillActivity extends AppCompatActivity {
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


        expiration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ProcessedBillActivity.this, LawMakingActivity.class);
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
                adapter = new LawmakingAdapter(getApplicationContext(), result);
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
            Toast.makeText(this, "입력된 정보가 없습니다", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setFilteredList(filteredList);
        }
    }
}
