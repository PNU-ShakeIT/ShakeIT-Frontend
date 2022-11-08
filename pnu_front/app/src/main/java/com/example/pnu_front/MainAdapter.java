package com.example.pnu_front;

import static com.example.pnu_front.R.id.news_notion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Stack;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    private ArrayList<String> articlelist;
    private ArrayList<String> urllist;
    private Context context;

    public MainAdapter(ArrayList<String> articlelist, ArrayList<String> urllist,Context context) {
        articlelist = new ArrayList<>();
        urllist = new ArrayList<>();

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.news_item_title);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.news_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        String text = articlelist.get(position);
        holder.textView.setText(text);
//        holder.textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String url = urllist.get(position);
//
//
//                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                Log.d("url",""+i);
//                context.startActivity(i);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return articlelist.size();
    }
    public void setItem(String data){
        articlelist.add(data);
    }

    public void setItems(ArrayList<String> art_list ){
        articlelist = art_list;
        notifyDataSetChanged();
    }

}