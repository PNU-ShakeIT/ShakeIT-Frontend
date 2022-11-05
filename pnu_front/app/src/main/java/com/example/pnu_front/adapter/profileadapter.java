package com.example.pnu_front.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.R;

public class profileadapter extends RecyclerView.Adapter<profileadapter.MyViewHolder> {

    private final String[] testmember;
    private final String[] testparty;

    public profileadapter(String[] testmember,String[] testparty) {

        this.testmember = testmember;
        this.testparty = testparty;
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView member;
        public TextView party;
        public MyViewHolder(View view)
        {
            super(view);
            this.member = view.findViewById(R.id.congress_member_text);
            this.party = view.findViewById(R.id.congress_party_text);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        Context context = parent.getContext();
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_list, parent , false);
        MyViewHolder myViewHolder = new MyViewHolder(holderView);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int i) {
        holder.member.setText(this.testmember[i]);
        holder.party.setText(this.testparty[i]);
    }

    @Override
    public int getItemCount() {

        return testmember.length;
    }
}
