package com.example.pnu_front.adapter;


import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.Calender.CalenderModer;
import com.example.pnu_front.R;

import java.util.ArrayList;
import java.util.List;

public class calendarAdapter extends RecyclerView.Adapter<calendarAdapter.MyViewHolder> {
    List<CalenderModer> calenderData;

    public calendarAdapter(List<CalenderModer> calenderData) {
        this.calenderData = calenderData;
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
        switch(this.calenderData.get(i).getCode())
        {
            case "1" : {holder.title.setTextColor(Color.parseColor("#4f9468")); break;}
            case "2" : {holder.title.setTextColor(Color.parseColor("#c0522b")); break;}
            case "3" : {holder.title.setTextColor(Color.parseColor("#3b768e")); break;}
            case "4" : {holder.title.setTextColor(Color.parseColor("#b78333")); break;}
            case "5" : {holder.title.setTextColor(Color.parseColor("#555c6a")); break;}
        }
        holder.title.setText(this.calenderData.get(i).getCommittee_name());
        holder.mainschedule.setText(this.calenderData.get(i).getTitle());
        holder.time.setText(this.calenderData.get(i).getTime());
    }

    @Override
    public int getItemCount() {

        return calenderData.size();
    }
    public void setItems(List<CalenderModer> list){
        calenderData = list;
        notifyDataSetChanged();
    }
}
