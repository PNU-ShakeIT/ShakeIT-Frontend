package com.example.pnu_front.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.R;
import com.example.pnu_front.profile.OnitemClick;
import com.example.pnu_front.profile.ProfileModel;

import java.util.ArrayList;
import java.util.List;

public class profileadapter extends RecyclerView.Adapter<profileadapter.MyViewHolder> {

    List<ProfileModel> profileData;
    private OnitemClick mCallback;


    public profileadapter(Context applicationContext, List<ProfileModel> profileData , OnitemClick listener) {
        this.profileData = profileData;
        this.mCallback = listener;
    }

    public void setFilteredList(List<ProfileModel> filteredList){
        this.profileData = filteredList;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView member;
        public TextView party;
        public CardView cardView;
        public MyViewHolder(View view)
        {
            super(view);
            this.member = view.findViewById(R.id.congress_member_text);
            this.party = view.findViewById(R.id.congress_party_text);
            this.cardView = view.findViewById(R.id.congress_member_cardview);
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
    public void setItems(List<ProfileModel> list){
        profileData = list;
        notifyDataSetChanged();
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

    }
    @Override
    public int getItemCount() {
        return profileData.size();
    }

}
