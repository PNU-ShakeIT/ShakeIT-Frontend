package com.example.pnu_front;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Fragment_2 extends Fragment {
    RecyclerView recyclerView;
    LawmakingAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.frame_2, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.pass_lawmake_notion);
        recyclerView.setLayoutManager(new LinearLayoutManager(((RecyclerView) rootView.findViewById(R.id.pass_lawmake_notion)).getContext(),RecyclerView.VERTICAL,false));
        adapter = new LawmakingAdapter();

        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-15 ~ 2021-10-14", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));
        adapter.setItem(new lawmake("우리의 우주는 실존하는게 맞는것인가?","259888","지평선","2020-10-5 ~ 2021-10-4", "오르트 구름 위원회"));

        recyclerView.setAdapter(adapter);

        return rootView;
    }

}