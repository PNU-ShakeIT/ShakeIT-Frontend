package com.example.pnu_front.Calender;

import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.pnu_front.R;
import com.ramotion.circlemenu.CircleMenuView;

public class Calender extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        CalendarView calendarView = findViewById(R.id.calendarView);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Log.d("W","1:"+ i + "2:" + i1 + "3:" + i2);
                int[] tmp = new int[3];
                tmp[0] = i;
                tmp[1] = i1;
                tmp[2] = i2;
            }
        });
        //데이터 요청(날짜별로)
        //받은 후에 sort
    }
}