package com.example.pnu_front.peititon;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pnu_front.R;

import java.util.List;

import RetrofitMananger.RetrofitInstance;
import profile.ProfileModer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Petition extends AppCompatActivity {
    Call<List<ProfileModer>> call;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        textView = findViewById(R.id.textView2);

        call = RetrofitInstance.getApiService().getPosts("황희");
        call.enqueue(new Callback<List<ProfileModer>>() {
            @Override
            public void onResponse(Call<List<ProfileModer>> call, Response<List<ProfileModer>> response) {
                List<ProfileModer> result = response.body();
                String str = result.get(1).toString();
                textView.setText(str);
            }

            @Override
            public void onFailure(Call<List<ProfileModer>> call, Throwable t) {

            }
        });
    }
}