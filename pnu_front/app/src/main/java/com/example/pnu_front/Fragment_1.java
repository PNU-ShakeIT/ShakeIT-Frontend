package com.example.pnu_front;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment_1 extends Fragment {
    RecyclerView recyclerView;
    LawmakingAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.frame_1, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.news_notion);
        recyclerView.setLayoutManager(new LinearLayoutManager(((RecyclerView) rootView.findViewById(R.id.news_notion)).getContext(),RecyclerView.VERTICAL,false));
        adapter = new LawmakingAdapter();

        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));
        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));

        adapter.setItem(new lawmake("김세훈은 섹스를 잘하는가","2598","섹스","2020-10-5 ~ 2021-10-4"));

        recyclerView.setAdapter(adapter);


        return rootView;
    }

}