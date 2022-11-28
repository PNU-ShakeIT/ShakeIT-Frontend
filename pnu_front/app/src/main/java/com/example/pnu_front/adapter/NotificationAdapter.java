package com.example.pnu_front.adapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pnu_front.LawMaking.LawMakingActivity;
import com.example.pnu_front.ProcessedBill.ProcessedBillActivity;
import com.example.pnu_front.R;
import com.example.pnu_front.notification.NotificationModel;
import com.example.pnu_front.peititon.Petition_expiration;
import com.example.pnu_front.peititon.Petition_progress;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.MyViewHolder> {

    private Context mContext;
    List<NotificationModel> notificationData;

    public NotificationAdapter(Context mContext,List<NotificationModel> notificationData) {
        this.notificationData = notificationData;
        this.mContext = mContext;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
            public TextView title;
            public TextView detail;
            public ImageView img;
            public TextView navigation;
            public TextView datealerm;
            public LinearLayout frame;
            public TextView code;
        private Context mContext;

        public MyViewHolder(View view)
            {
                super(view);
                this.title = view.findViewById(R.id.text_title_notification);
                this.detail = view.findViewById(R.id.text_detail_notification);
                this.img = view.findViewById(R.id.img_notification);
                this.navigation = view.findViewById(R.id.notification_navigation);
                this.datealerm = view.findViewById(R.id.notification_datealerm);
                this.frame = view.findViewById(R.id.notification_frame);
                this.code = view.findViewById(R.id.code);
                frame.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Context context = v.getContext();

                        if(code.getText().equals("1")) {
                            Intent i = new Intent(v.getContext(), LawMakingActivity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            v.getContext().startActivity(i);
                        }
                        else if(code.getText().equals("3")){Intent i = new Intent(v.getContext(), ProcessedBillActivity.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            v.getContext().startActivity(i);}
                        else if(code.getText().equals("4")){Intent i = new Intent(v.getContext(), Petition_progress.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            v.getContext().startActivity(i);}
                        else if(code.getText().equals("5")){Intent i = new Intent(v.getContext(), Petition_expiration.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            v.getContext().startActivity(i);}
                    }
                });
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
                if(Objects.equals(todaydate[2], targetdate[2])||(Integer.parseInt(targetdate[2])-1)==Integer.parseInt(todaydate[2])) holder.datealerm.setText("오늘");
                else holder.datealerm.setText((Integer.parseInt(todaydate[2])-Integer.parseInt(targetdate[2])) +"일 전");
            else holder.datealerm.setText(Integer.parseInt(todaydate[0])-(Integer.parseInt(targetdate[1]))+"달 전");
        else holder.datealerm.setText((Integer.parseInt(todaydate[0])-Integer.parseInt(targetdate[0]))+"년 전");
        switch (num) {
            case 1 : {
                holder.code.setText("1");
                holder.img.setBackgroundResource(R.drawable.ip_bub_right);
                holder.title.setText("처리된 입법 정보가 도착하였습니다.");
                holder.detail.setText(notificationData.get(position).getTitle());
                holder.navigation.setText("메인 > 메뉴 > 입법 > 처리된 법률안");
                break;
            }
            case 3 : {
                holder.code.setText("3");
                holder.img.setBackgroundResource(R.drawable.ip_bub_right);
                holder.title.setText("진행중인 입법 정보가 도착하였습니다.");
                holder.navigation.setText("메인 > 메뉴 > 입법 > 진행중인 법률안");
                holder.detail.setText(notificationData.get(position).getTitle());
                break;
            }
            case 4 : {
                holder.code.setText("4");
                holder.img.setBackgroundResource(R.drawable.chungwon_right);
                holder.title.setText("진행중인 청원 정보가 도착하였습니다.");
                holder.navigation.setText("메인 > 메뉴 > 청원 > 진행중인 청원");
                holder.detail.setText(notificationData.get(position).getTitle());
                break;
            }
            case 5 : {
                holder.code.setText("5");
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