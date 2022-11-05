package com.example.pnu_front.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.Calender.Calender;
import com.example.pnu_front.R;

public class calendarAdapter extends RecyclerView.Adapter<calendarAdapter.MyViewHolder> {

    private final String[] title;
    private final String[] mainschedule;
    private final String[] time;
    private final int[] code;

    public calendarAdapter(String[] title,String[] mainschedule, String[] time , int[] code) {
        this.title = title;
        this.mainschedule = mainschedule;
        this.time = time;
        this.code = code;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView mainschedule;
        public TextView time;
        public MyViewHolder(View view)
        {
            super(view);
            this.title = view.findViewById(R.id.calendar_title_text);
            this.mainschedule = view.findViewById(R.id.calendar_main_text);
            this.time = view.findViewById(R.id.calendar_time_text);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        Context context = parent.getContext();
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendar_detail, parent , false);
        MyViewHolder myViewHolder = new MyViewHolder(holderView);
        return myViewHolder;
    }

    @SuppressLint({"ResourceAsColor", "RestrictedApi"})
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        switch(code[i])
        {
            case 1 : {holder.title.setTextColor(Color.parseColor("#4f9468")); break;}
            case 2 : {holder.title.setTextColor(Color.parseColor("#c0522b")); break;}
            case 3 : {holder.title.setTextColor(Color.parseColor("#3b768e")); break;}
            case 4 : {holder.title.setTextColor(Color.parseColor("#b78333")); break;}
            case 5 : {holder.title.setTextColor(Color.parseColor("#555c6a")); break;}
        }
        holder.title.setText(title[i]);
        holder.mainschedule.setText(mainschedule[i]);
        holder.time.setText(time[i]);
    }

    @Override
    public int getItemCount() {

        return title.length;
    }
}
