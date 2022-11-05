package com.example.pnu_front.profile;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.RetrofitMananger.RetrofitService;
import com.example.pnu_front.adapter.profileadapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.Adapter myadapter;
    RecyclerView.LayoutManager layoutManager;
    Call<List<ProfileModel>> call;
    List<ProfileModel> result = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final int[] tmp = {0}; //0일때 평소 상태 1일때 확대 상태
        setContentView(R.layout.activity_profile);
        ImageView imageView = findViewById(R.id.Congress_member_listsizebtn);
        RecyclerView congressmember = findViewById(R.id.congress_member_list);
        RecyclerView memberprofile = findViewById(R.id.congress_member_profile);
        FrameLayout frameLayout = findViewById(R.id.frame_layout);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tmp[0] == 0) {
                    ViewGroup.LayoutParams params = congressmember.getLayoutParams();
                    params.width = 950;
                    params.height = 1400;
                    congressmember.setLayoutParams(params);
                    memberprofile.setVisibility(View.GONE);
                    imageView.setBackgroundResource(R.drawable.up_right);
                    tmp[0] = 1;
                }
                else
                {
                    ViewGroup.LayoutParams params = congressmember.getLayoutParams();
                    params.height = 600;
                    congressmember.setLayoutParams(params);
                    memberprofile.setVisibility(View.VISIBLE);
                    imageView.setBackgroundResource(R.drawable.down_right);
                    tmp[0] = 0 ;

                }
            }
        });
        String[] str = getResources().getStringArray(R.array.spinnerArray);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_age,str);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        Spinner spinner_field =(Spinner)findViewById(R.id.spinner_age);
        spinner_field.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner_field.getSelectedItemPosition() > 0){

                    Log.d("msg",spinner_field.getSelectedItem().toString()+"selected");
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_field.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        congressmember.setLayoutManager(layoutManager);

        call = RetrofitInstance.getApiService().getPosts();
        call.enqueue(new Callback<List<ProfileModel>>() {
            @Override
            public void onResponse(Call<List<ProfileModel>> call, Response<List<ProfileModel>> response) {
                result = response.body();
                myadapter = new profileadapter(getApplicationContext(), result);
                congressmember.setAdapter(myadapter);
            }

            @Override
            public void onFailure(Call<List<ProfileModel>> call, Throwable t) {

            }
        });
    }
}