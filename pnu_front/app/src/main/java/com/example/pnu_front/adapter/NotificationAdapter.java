package com.example.pnu_front.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.Calender.CalenderModel;
import com.example.pnu_front.R;
import com.example.pnu_front.peititon.PendingPetitionModel;
import com.example.pnu_front.profile.ProfileModel;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    static List<PendingPetitionModel> notificationData;

    public NotificationAdapter(List<ProfileModel> result) {
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
            public TextView title;
            public TextView detail;
            public ImageView img;
            public MyViewHolder(View view)
            {
                super(view);
                this.title = view.findViewById(R.id.text_title_notification);
                this.detail = view.findViewById(R.id.text_detail_notification);
                this.img = view.findViewById(R.id.img_notification);
            }
        }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent , false);
        MyViewHolder myViewHolder = new MyViewHolder(holderView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationAdapter.MyViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return notificationData.size();
    }


}