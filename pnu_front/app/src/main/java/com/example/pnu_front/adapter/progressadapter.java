package com.example.pnu_front.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.R;
import com.example.pnu_front.profile.ProfileModel;

import java.util.List;

public class progressadapter extends RecyclerView.Adapter<progressadapter.MyViewHolder> {

    private final String[] testtext;

    public progressadapter(String[] testtext) {
        this.testtext = testtext;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public MyViewHolder(View view) {
            super(view);
            this.textView = view.findViewById(R.id.title);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        Context context = parent.getContext();
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expiration_petition, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(holderView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.textView.setText(this.testtext[i]);
    }

    @Override
    public int getItemCount() {

        return testtext.length;
    }
    public void setItems(String list){
        notifyDataSetChanged();
    }
}
