package com.example.pnu_front.Calender;

import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.adapter.calendarAdapter;
import com.example.pnu_front.adapter.expirationadapter;
import com.example.pnu_front.peititon.PendingPetitionModel;
import com.ramotion.circlemenu.CircleMenuView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Calender extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    Call<List<CalenderModer>> call;
    List<CalenderModer> result = new ArrayList<>();
    List<CalenderModer> tmp = new ArrayList<>();// 정렬할때 임시 저장소

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);


        CalendarView calendarView = findViewById(R.id.calendarView);
        int[] code = {3,3,5,2,4,1};
//         code 1 -> 세미나
//         code 2 -> 본회의
//         code 3 -> 위원회
//         code 4 -> 국회의장
//         code 5 -> 공청회
        call = RetrofitInstance.getApiService().getCalendar();
        call.enqueue(new Callback<List<CalenderModer>>() {
            @Override
            public void onResponse(Call<List<CalenderModer>> call, Response<List<CalenderModer>> response) {
                result = response.body();
            }
            @Override
            public void onFailure(Call<List<CalenderModer>> call, Throwable t) {
                Log.d("qwer","씨@@@@@@@@@@@@@@@@@@@@@@@발왜안되는데");
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Log.d("W","1:"+ i + " 2:" + i1 + " 3:" + i2);
                int tmp = 0;
                tmp = tmp + i*1000000;
                tmp = tmp +  (i1+1)*1000;
                tmp = tmp + i2;
                Log.d("Tag",""+result);
                String today = Integer.toString(tmp);

                Log.d("Tag",""+today);
                RecyclerView recyclerview_cal = findViewById(R.id.recyclerview_calendar);
                recyclerview_cal.setLayoutManager(layoutManager);
                adapter= new calendarAdapter(result);

                recyclerview_cal.setAdapter(adapter);
            }
        });
        //데이터 요청(날짜별로)
        //받은 후에 sort


        //캘린더에 뿌려주기

        //사이클러 뷰에 날짜별로 넣어주면 표시







    }
}