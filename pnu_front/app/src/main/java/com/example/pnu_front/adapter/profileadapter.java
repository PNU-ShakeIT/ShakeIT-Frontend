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

public class profileadapter extends RecyclerView.Adapter<profileadapter.MyViewHolder> {
    List<ProfileModel> profileData;

    public profileadapter(Context applicationContext, List<ProfileModel> profileData) {
        this.profileData = profileData;
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
        holder.member.setText(this.profileData.get(i).getHg_NM());
        holder.party.setText(this.profileData.get(i).getPoly_NM());
        //recyclerview item click
    }
    @Override
    public int getItemCount() {

        return profileData.size();
    }
}
