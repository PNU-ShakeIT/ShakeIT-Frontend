package com.example.pnu_front;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.RetrofitManager.ApiClient;
import com.example.pnu_front.RetrofitManager.ApiInterface;
import com.example.pnu_front.RetrofitManager.PetitionModel;
import com.example.pnu_front.ViewManager.PetitionAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Petition extends AppCompatActivity {

    RecyclerView recyclerView;
    PetitionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petition);


        ApiInterface service = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<PetitionModel>> call = service.getPetitoning();

        call.enqueue(new Callback<List<PetitionModel>>() {
            // 정상으로 통신 성공시
            @Override
            public void onResponse(Call<List<PetitionModel>> call, Response<List<PetitionModel>> response) {
                generateDataList(response.body());
            }
            // 통신 실패시(예외발생, 인터넷끊김 등의 이유)
            @Override
            public void onFailure(Call<List<PetitionModel>> call, Throwable t) {
                Toast.makeText(Petition.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);
    }

    private void generateDataList(List<PetitionModel> petitionList){
        recyclerView = (RecyclerView)findViewById(R.id.recyceler_view);
        adapter = new PetitionAdapter(this, petitionList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }
}