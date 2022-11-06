package com.example.pnu_front;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Struct;
import java.util.ArrayList;

public class LawmakingAdapter extends RecyclerView.Adapter<LawmakingAdapter.ViewHolder>{
        private ArrayList<lawmake> arrayList = new ArrayList<lawmake>();

        static class ViewHolder extends RecyclerView.ViewHolder {
            TextView title;
            TextView user;
            TextView day;
            TextView num;
            TextView association;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                title = itemView.findViewById(R.id.lawmaking_title);
                user = itemView.findViewById(R.id.lawmaking_user);
                day = itemView.findViewById(R.id.lawmaking_date);
                num = itemView.findViewById(R.id.lawmaking_num);
                association = itemView.findViewById(R.id.association);
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
            lawmake item = arrayList.get(position);
            holder.title.setText(item.getTitle());
            holder.num.setText(item.getNum());
            holder.day.setText(item.getDay());
            holder.user.setText(item.getUser());
            holder.association.setText(item.getAssociation());
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }
        public void setItem(lawmake item){
            arrayList.add(item);
        }

}

