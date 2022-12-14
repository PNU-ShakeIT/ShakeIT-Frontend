package com.example.pnu_front.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.LawMaking.LawMakingModel;
import com.example.pnu_front.R;
import com.example.pnu_front.profile.OnitemClick;
import com.example.pnu_front.profile.ProfileModel;

import java.util.List;

public class LawmakingAdapter extends RecyclerView.Adapter<LawmakingAdapter.ViewHolder>{
    List<LawMakingModel> LawMakingData;
    private OnitemClick mCallback;

    public LawmakingAdapter(Context applicationContext, List<LawMakingModel> lawMakingData, OnitemClick listener) {
        LawMakingData = lawMakingData;
        this.mCallback = listener;
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
        public LinearLayout lawmaking;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.lawmaking_title);
            user = itemView.findViewById(R.id.lawmaking_user);
            day = itemView.findViewById(R.id.lawmaking_date);
            num = itemView.findViewById(R.id.lawmaking_num);
            lawmaking = itemView.findViewById(R.id.lawmaking);
            association = itemView.findViewById(R.id.association);
            url = itemView.findViewById(R.id.lawmaking_url);
            lawmaking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = Integer.parseInt(LawMakingData.get(getAdapterPosition()).getId());
                    System.out.println("pos : " + pos);
                    mCallback.onClick(pos);
                }
            });
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
            Log.d("???????????????????????????????????????????????????????????????",""+LawMakingData.get(position).getProposer());
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

