package com.example.pnu_front.Calender;

import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.R;
import com.example.pnu_front.adapter.calendarAdapter;
import com.example.pnu_front.adapter.expirationadapter;
import com.ramotion.circlemenu.CircleMenuView;

public class Calender extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);


        CalendarView calendarView = findViewById(R.id.calendarView);
        String[] title = {"과학기술정보방송통신위원회","외교통일위원회","공청회","본회의","국회의장","세미나"};
        String[] mainschedule = {"제400회 국회(정기회) 제5차 전체회의" , "제400회 국회(정기회) 제2차 예산, 결산, 기금심사 소위원회" , "제400회 국회(정기회) 제4차 공청회" , "제400회 국회(정기회) 제400-10차(의사일정)","2023년도 예산안 토론회(의정관 3층 중앙홀)","오늘의 세미나" };
        String[] time = {"9:00" , "10:00" , "10:30" , "11:30" , "12:00" , "1:00"};
        int[] code = {3,3,5,2,4,1};
//         code 1 -> 세미나
//         code 2 -> 본회의
//         code 3 -> 위원회
//         code 4 -> 국회의장
//         code 5 -> 공청회     => 코드 따로 받아서(종민이가 준다고 했음) 이걸로 title text 색상 변경
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Log.d("W","1:"+ i + " 2:" + i1 + " 3:" + i2);
                int[] tmp = new int[3];
                tmp[0] = i;
                tmp[1] = i1;
                tmp[2] = i2;
                RecyclerView recyclerview_cal = findViewById(R.id.recyclerview_calendar);
                recyclerview_cal.setLayoutManager(layoutManager);
                adapter= new calendarAdapter(title,mainschedule,time,code);
                recyclerview_cal.setAdapter(adapter);
            }
        });
        //데이터 요청(날짜별로)
        //받은 후에 sort


        //캘린더에 뿌려주기

        //사이클러 뷰에 날짜별로 넣어주면 표시







    }
}