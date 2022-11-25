package com.example.pnu_front.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.Calender.CalenderModel;
import com.example.pnu_front.R;
import com.example.pnu_front.notification.NotificationModel;
import com.example.pnu_front.peititon.PendingPetitionModel;
import com.example.pnu_front.profile.ProfileModel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

     List<NotificationModel> notificationData;

    public NotificationAdapter(List<NotificationModel> notificationData) {
        this.notificationData = notificationData;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
            public TextView title;
            public TextView detail;
            public ImageView img;
            public TextView navigation;
            public TextView datealerm;
            public MyViewHolder(View view)
            {
                super(view);
                this.title = view.findViewById(R.id.text_title_notification);
                this.detail = view.findViewById(R.id.text_detail_notification);
                this.img = view.findViewById(R.id.img_notification);
                this.navigation = view.findViewById(R.id.notification_navigation);
                this.datealerm = view.findViewById(R.id.notification_datealerm);
            }
        }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent , false);
        return new MyViewHolder(holderView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        int num = notificationData.get(position).getCode();
        String createddate = notificationData.get(position).getCreatedate();
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = dateFormat.format(date);
        String todaydate[] = today.split("-");
        String targetdate[] = notificationData.get(position).getCreatedate().split("-");
        if(Objects.equals(todaydate[0], targetdate[0]))
            if(Objects.equals(todaydate[1], targetdate[1]))
                if(Objects.equals(todaydate[2], targetdate[2])) holder.datealerm.setText("오늘");
                else holder.datealerm.setText((Integer.parseInt(todaydate[2])-Integer.parseInt(targetdate[2])) +"일 전");
            else holder.datealerm.setText(Integer.parseInt(todaydate[0])-(Integer.parseInt(targetdate[1]))+"달 전");
        else holder.datealerm.setText((Integer.parseInt(todaydate[0])-Integer.parseInt(targetdate[0]))+"년 전");
        Log.d("testttt",""+num);
        switch (num) {
            case 1 : {
                holder.img.setBackgroundResource(R.drawable.ip_bub_right);
                holder.title.setText("처리된 입법 정보가 도착하였습니다.");
                holder.detail.setText(notificationData.get(position).getTitle());
                holder.navigation.setText("메인 > 메뉴 > 입법 > 처리된 법률안");
                break;
            }
            case 3 : {
                holder.img.setBackgroundResource(R.drawable.ip_bub_right);
                holder.title.setText("진행중인 입법 정보가 도착하였습니다.");
                holder.navigation.setText("메인 > 메뉴 > 입법 > 진행중인 법률안");
                holder.detail.setText(notificationData.get(position).getTitle());
                break;
            }
            case 4 : {
                holder.img.setBackgroundResource(R.drawable.chungwon_right);
                holder.title.setText("진행중인 청원 정보가 도착하였습니다.");
                holder.navigation.setText("메인 > 메뉴 > 청원 > 진행중인 청원");
                holder.detail.setText(notificationData.get(position).getTitle());
                break;
            }
            case 5 : {
                holder.img.setBackgroundResource(R.drawable.chungwon_right);
                holder.title.setText("종료된 청원 정보가 도착하였습니다.");
                holder.navigation.setText("메인 > 메뉴 > 청원 > 동의만료 청원");
                holder.detail.setText(notificationData.get(position).getTitle());
                break;
            }
        }


    }

    @Override
    public int getItemCount() {
        return notificationData.size();
    }


}