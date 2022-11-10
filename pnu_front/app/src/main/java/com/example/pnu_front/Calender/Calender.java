package com.example.pnu_front.Calender;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.adapter.calendarAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class Calender extends AppCompatActivity {


    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    Call<List<CalenderModel>> call;
    List<CalenderModel> result = new ArrayList<>();
    static List<CalenderModel> sta = new ArrayList<>();
    List<CalenderModel> tmp = new ArrayList<>();// 오늘 일정만 뺀 후의 리스트
    List<CalenderModel> cal_data = new ArrayList<>();//시간 순서로 정렬한 후의 리스트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);
        TextView text_day = findViewById(R.id.date_text);


        CalendarView calendarView = findViewById(R.id.calendarView);
        int[] code = {3,3,5,2,4,1};
//         code 1 -> 세미나
//         code 2 -> 본회의
//         code 3 -> 위원회
//         code 4 -> 국회의장
//         code 5 -> 공청회
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        String today = dateFormat.format(date);
        String thismonth = monthFormat.format(date);
        TextView datetext = findViewById(R.id.date_text);
        datetext.setText(thismonth+"월 "+today+"일 일정");

        call = RetrofitInstance.getApiService().getCalendar();
        //데이터 요청(날짜별로)
        call.enqueue(new Callback<List<CalenderModel>>() {
            @Override
            public void onResponse(Call<List<CalenderModel>> call, Response<List<CalenderModel>> response) {
                result = response.body();
                sta = result;
                long now = System.currentTimeMillis();
                Date date = new Date(now);
                @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String today = dateFormat.format(date);
                int p;
                int k =0;
                for (p = 0; p < result.size(); p++) {
                    if (Objects.equals(result.get(p).getDate(), today)) {
                        tmp.add(k, result.get(p));
                        k++;
                    }
                }
                int r = tmp.size();
                int y = 0;
                for (p = 0; p < r; p++ ) {

                    if(tmp.get(p).getTime().contains("후")||tmp.get(p).getTime().contains("null"))
                    {
                        sta.add(y,tmp.get(p));
                        tmp.remove(p);
                        r--;
                        y++;
                    }
                }
//                //tmp에 저장된 일정을 시간 순서로 정렬
                List<CalenderModel> calenderModels = null;
                System.out.println("여기에요 여기 !!!!!!!");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                   calenderModels = tmp.stream().collect(Collectors.toList());
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    calenderModels = calenderModels.stream()
                            .filter((CalenderModel) -> CalenderModel.getTime() != null)
                            .sorted(Comparator.comparing(CalenderModel::getTime)).collect(Collectors.toList());
                }
                RecyclerView recyclerview_cal = findViewById(R.id.recyclerview_calendar);
                recyclerview_cal.setLayoutManager(layoutManager);
                adapter = new calendarAdapter(calenderModels);
                recyclerview_cal.setAdapter(adapter);





            }
            @Override
            public void onFailure(Call<List<CalenderModel>> call, Throwable t) {
            }
        });
        Log.d("sibal",""+sta);

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Log.d("W", "1:" + i + " 2:" + i1 + " 3:" + i2);
                String date;
                date = Integer.toString(i2);
                String month = Integer.toString(i1 + 1);
                text_day.setText(month + "월 " + date + "일 일정");
                String today;
                String strtmp;
                int inttmp = 0;
                int k = 0;

                //받은 후에 선택된 날짜의 일정만 뽑아서 tmp에 저장
                inttmp = inttmp + i * 1000000;
                inttmp = inttmp + (i1 + 1) * 1000;
                inttmp = inttmp + i2;
                strtmp = Integer.toString(inttmp);
                today = strtmp.substring(0, 4) + '-' + strtmp.substring(5, 7) + '-' + strtmp.substring(8);
//                Log.d("tag", "" + today + result);
                tmp.clear();
                int p;
                for (p = 0; p < result.size(); p++) {
                    if (Objects.equals(result.get(p).getDate(), today)) {
                        tmp.add(k, result.get(p));
                        k++;
                    }
                }

                //tmp에 저장된 일정을 시간 순서로 정렬
                List<CalenderModel> calenderModels = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    calenderModels = tmp.stream().collect(Collectors.toList());
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    calenderModels = calenderModels.stream()
                            .filter((CalenderModel) -> CalenderModel.getTime() != null)
                            .sorted(Comparator.comparing(CalenderModel::getTime))
                            .collect(Collectors.toList());
                }
                Log.d("test",""+calenderModels);
                RecyclerView recyclerview_cal = findViewById(R.id.recyclerview_calendar);
                recyclerview_cal.setLayoutManager(layoutManager);
                adapter = new calendarAdapter(calenderModels);
                recyclerview_cal.setAdapter(adapter);
            }

        });

        //캘린더에 뿌려주기

        //사이클러 뷰에 날짜별로 넣어주면 표시


    }

}