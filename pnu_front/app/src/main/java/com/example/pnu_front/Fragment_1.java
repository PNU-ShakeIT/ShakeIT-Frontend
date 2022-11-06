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
        recyclerView = (RecyclerView)rootView.findViewById(R.id.progress_lawmake_notion);
        recyclerView.setLayoutManager(new LinearLayoutManager(((RecyclerView) rootView.findViewById(R.id.progress_lawmake_notion)).getContext(),RecyclerView.VERTICAL,false));
        adapter = new LawmakingAdapter();

        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));
        adapter.setItem(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?","259888","섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회"));

        recyclerView.setAdapter(adapter);


        return rootView;
    }

}