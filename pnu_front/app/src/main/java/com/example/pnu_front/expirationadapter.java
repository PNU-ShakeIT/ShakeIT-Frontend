package com.example.pnu_front;

import static androidx.recyclerview.widget.RecyclerView.*;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class expirationadapter extends RecyclerView.Adapter<expirationadapter.MyViewHolder> {

    private String[] testtext;

    public expirationadapter(String[] testtext) {
        this.testtext = testtext;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public MyViewHolder(View view)
        {
            super(view);
            this.title = view.findViewById(R.id.title);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_petition_expiration , parent , false);
        MyViewHolder myViewHolder = new MyViewHolder(holderView);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(this.testtext[position]);
    }

    @Override
    public int getItemCount() {
        return testtext.length;
    }
}
