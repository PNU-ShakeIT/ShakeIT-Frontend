package com.example.pnu_front.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.R;
import com.example.pnu_front.peititon.PendingPetitionModel;
import com.example.pnu_front.profile.OnitemClick;

import java.util.ArrayList;
import java.util.List;

public class pendingadapter extends RecyclerView.Adapter<pendingadapter.MyViewHolder> {

    List<PendingPetitionModel> pendingPetitionData;
    private static OnitemClick mCallback;

    public pendingadapter(Context applicationContext, List<PendingPetitionModel> pendingPetitionData, OnitemClick listener) {
        this.pendingPetitionData = pendingPetitionData;
        this.mCallback = listener;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView member;
        public ProgressBar bar;
        public CardView cardView;
        public MyViewHolder(View view)
        {
            super(view);
            this.title = view.findViewById(R.id.title);
            this.member = view.findViewById(R.id.petition_amount);
            this.bar = view.findViewById(R.id.progressBar);
            this.cardView = view.findViewById(R.id.cardView_petition);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION)
                    {
                        mCallback.onClick(pos);
                        Log.d("1:37","pos:"+pos);
                    }

                }
            });
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        Context context = parent.getContext();
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expiration_petition, parent , false);
        MyViewHolder myViewHolder = new MyViewHolder(holderView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.title.setText(this.pendingPetitionData.get(i).getName());
        String[] tmpname = new String[2];
        int num =0;
        int tmp =0;
        String numString;
        tmpname = pendingPetitionData.get(i).getProposer().split(" ");
        if(tmpname.length == 1){
            holder.member.setText(this.pendingPetitionData.get(i).getProposer());
            holder.bar.setProgress(0);
        }
        else{
            holder.member.setText(this.pendingPetitionData.get(i).getProposer());
            numString = tmpname[1].replace("인","");
            num = Integer.parseInt(numString.replace(",", ""));
            Log.d("num", ""+num);
            holder.bar.setProgress(num/500);
        }
    }

    @Override
    public int getItemCount() {

        return pendingPetitionData.size();
    }
    public void setItems(List<PendingPetitionModel> list){
        pendingPetitionData = list;
        notifyDataSetChanged();
    }
}
