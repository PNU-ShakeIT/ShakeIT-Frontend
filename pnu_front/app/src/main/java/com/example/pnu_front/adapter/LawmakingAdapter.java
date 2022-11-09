package com.example.pnu_front.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.LawMaking.LawMakingModel;
import com.example.pnu_front.R;
import com.example.pnu_front.peititon.PendingPetitionModel;
import com.example.pnu_front.profile.ProfileModel;

import java.util.ArrayList;
import java.util.List;

public class LawmakingAdapter extends RecyclerView.Adapter<LawmakingAdapter.ViewHolder>{
    List<LawMakingModel> LawMakingData;

    public LawmakingAdapter(List<LawMakingModel> lawMakingData) {
        LawMakingData = lawMakingData;
    }

    public void setFilteredList(List<LawMakingModel> filteredList){
        this.LawMakingData = filteredList;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView user;
        public TextView day;
        public TextView num;
        public TextView association;
        public TextView url;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.lawmaking_title);
            user = itemView.findViewById(R.id.lawmaking_user);
            day = itemView.findViewById(R.id.lawmaking_date);
            num = itemView.findViewById(R.id.lawmaking_num);
            association = itemView.findViewById(R.id.association);
            url = itemView.findViewById(R.id.lawmaking_url);
        }
    }

        @NonNull
        @Override
        public  ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemView = inflater.inflate(R.layout.lawmaking_item, parent, false);

            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.title.setText(this.LawMakingData.get(position).getBill_name());
            holder.num.setText(this.LawMakingData.get(position).getBill_no());
            holder.day.setText(this.LawMakingData.get(position).getNoti_end_dt());
            holder.user.setText(this.LawMakingData.get(position).getProposer());
            holder.association.setText(this.LawMakingData.get(position).getCurr_committee());
            holder.url.setText(this.LawMakingData.get(position).getLink());
        }

        @Override
        public int getItemCount() {
            return LawMakingData.size();
        }
        public void setItem(LawMakingModel item){
            LawMakingData.add(item);
        }

    public void setItems(List<LawMakingModel> list){
        LawMakingData = list;
        notifyDataSetChanged();
    }
}

