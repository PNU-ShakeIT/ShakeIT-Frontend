package com.example.pnu_front.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.R;

public class expirationadapter extends RecyclerView.Adapter<expirationadapter.MyViewHolder> {

    private final String[] testtext;
    private final String[] testmember;

    public expirationadapter(String[] testtext,String[] testmember) {
        this.testtext = testtext;
        this.testmember = testmember;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public TextView member;
        public ProgressBar bar;
        public MyViewHolder(View view)
        {
            super(view);
            this.title = view.findViewById(R.id.title);
            this.member = view.findViewById(R.id.petition_amount);
            this.bar = view.findViewById(R.id.progressBar);
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
        holder.title.setText(this.testtext[i]);
        String[] tmpname = new String[3];
        int num =0;
        int tmp =0;
        tmpname = testmember[i].split(" ");
        Log.d("name","발인자 이름:"+tmpname[0]);
        holder.member.setText(this.testmember[i]);
        num = Integer.parseInt(tmpname[2].replace("명",""));
        holder.bar.setProgress(num/500);
        }

    @Override
    public int getItemCount() {

        return testtext.length;
    }
}
