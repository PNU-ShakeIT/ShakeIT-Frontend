package com.example.pnu_front.Calender;

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
import com.example.pnu_front.adapter.expirationadapter;
import com.example.pnu_front.peititon.PendingPetitionModel;
import com.ramotion.circlemenu.CircleMenuView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class Calender extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
    Call<List<CalenderModer>> call;
    List<CalenderModer> result = new ArrayList<>();
    List<CalenderModer> tmp = new ArrayList<>();// 오늘 일정만 뺀 후의 리스트
    List<CalenderModer> cal_data = new ArrayList<>();//시간 순서로 정렬한 후의 리스트

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

        call = RetrofitInstance.getApiService().getCalendar();
        //데이터 요청(날짜별로)
        call.enqueue(new Callback<List<CalenderModer>>() {
            @Headers({"Content-Type: application/json"})
            @POST("/user/signup")
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
                Log.d("tag", "" + today + result);
                tmp.clear();
                int p;
                for (p = 0; p < result.size(); p++) {
                    if (result.get(p).getDate().equals(today)) {
                        Log.d("si", "여기사람살아요" + result.get(p));
                        tmp.add(k, result.get(p));
                        k++;
                    }
                    p++;
                }
                //tmp에 저장된 일정을 시간 순서로 정렬
                for (p = 0; p < tmp.size()-1; p++ )
                {
                    String time1;
                    String time2;
                    int t;
                    int f;
                    if(tmp.get(p).getTime().contains("~")) {
                        Log.d("개씨발","살려주세요살려주세요살려주세요살려주세요살려주세요살려주세요살려주세요");
                        time1 = tmp.get(p).getTime().substring(0,5);
                        Log.d("시발",""+time1);
                        time2 = time1.substring(0, 2) + time1.substring(3);
                        f = Integer.parseInt(time2);
                    }
                    else{
                        time2 = tmp.get(p).getTime().substring(0, 2) + tmp.get(p).getTime().substring(3);
                        f = Integer.parseInt(time2);
                    }
                    if(tmp.get(p+1).getTime().contains("~")) {
                        time1 = tmp.get(p + 1).getTime().substring(0, 5);
                        Log.d("시발",""+time1);
                        time2 = time1.substring(0, 2) + time1.substring(3);
                        t = Integer.parseInt(time2);
                    }
                    else{
                        time2 = tmp.get(p + 1).getTime().substring(0, 2) + tmp.get(p + 1).getTime().substring(3);
                        t = Integer.parseInt(time2);
                    }
                    if(f>t)
                    {
                        cal_data.add(tmp.get(p+1));
                        tmp.set(p+1,tmp.get(p));
                        tmp.set(p,cal_data.get(0));
                        cal_data.clear();
                    }
                    for(k=p; 0<k; k--) {
                        if(tmp.get(k).getTime().contains("~")) {
                            time1 = tmp.get(k).getTime().substring(0, 5);
                            Log.d("시발",""+time1);
                            time2 = time1.substring(0, 2) + time1.substring(3);
                            f = Integer.parseInt(time2);
                        }
                        else{
                            time2 = tmp.get(k).getTime().substring(0, 2) + tmp.get(k).getTime().substring(3);
                            f = Integer.parseInt(time2);
                        }
                        if(tmp.get(k+1).getTime().contains("~")) {
                            time1 = tmp.get(k + 1).getTime().substring(0, 5);
                            Log.d("시발",""+time1);
                            time2 = time1.substring(0, 2) + time1.substring(3);
                            t = Integer.parseInt(time2);
                        }
                        else{
                            time2 = tmp.get(k + 1).getTime().substring(0, 2) + tmp.get(k + 1).getTime().substring(3);
                            t = Integer.parseInt(time2);
                        }
                        t = Integer.parseInt(time2);
                        if(f<t)
                        {
                            cal_data.add(tmp.get(k));
                            tmp.set(k-1,tmp.get(k));
                            tmp.set(k,cal_data.get(0));
                            cal_data.clear();
                        }
                    }
                }
                Log.d("test",""+tmp);
                RecyclerView recyclerview_cal = findViewById(R.id.recyclerview_calendar);
                recyclerview_cal.setLayoutManager(layoutManager);
                adapter = new calendarAdapter(tmp);
                recyclerview_cal.setAdapter(adapter);
            }
        });




        //캘린더에 뿌려주기

        //사이클러 뷰에 날짜별로 넣어주면 표시







    }
}