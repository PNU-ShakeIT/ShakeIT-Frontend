package com.example.pnu_front.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.LawMaking.LawMakingModel;
import com.example.pnu_front.ProcessedBill.ProcessedBillModel;
import com.example.pnu_front.R;

import java.util.List;

public class ProcessedBillAdapter extends RecyclerView.Adapter<ProcessedBillAdapter.ViewHolder>{
    List<ProcessedBillModel> ProcessedBillData;

    public ProcessedBillAdapter(List<ProcessedBillModel> processedBillData) {
        ProcessedBillData = processedBillData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView user;
        public TextView day;
        public TextView num;
        public TextView association;
        public TextView vote;
        public TextView ProcessedBIll_url;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.ProcessedBill_title);
            user = itemView.findViewById(R.id.ProcessedBill_user);
            day = itemView.findViewById(R.id.ProcessedBill_date);
            num = itemView.findViewById(R.id.ProcessedBill_num);
            association = itemView.findViewById(R.id.Bill_association);
            vote = itemView.findViewById(R.id.vote);
            ProcessedBIll_url = itemView.findViewById(R.id.ProcessedBill_url);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.processedbill_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(this.ProcessedBillData.get(position).getBill_name());
        holder.num.setText(this.ProcessedBillData.get(position).getBill_num());
        holder.day.setText(this.ProcessedBillData.get(position).getAnnounce_dt());
        holder.user.setText(this.ProcessedBillData.get(position).getProposer());
        holder.association.setText(this.ProcessedBillData.get(position).getCommittee_nm());
        holder.ProcessedBIll_url.setText(this.ProcessedBillData.get(position).getUrl());
        holder.ProcessedBIll_url.setText(this.ProcessedBillData.get(position).getProc_result());
    }

    @Override
    public int getItemCount() {
        return ProcessedBillData.size();
    }
    public void setItem(ProcessedBillModel item){
        ProcessedBillData.add(item);
    }

    public void setItems(List<ProcessedBillModel> list){
        ProcessedBillData = list;
        notifyDataSetChanged();
    }
}
