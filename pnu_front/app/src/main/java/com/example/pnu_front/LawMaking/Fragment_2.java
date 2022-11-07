package com.example.pnu_front.LawMaking;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.R;

import java.util.ArrayList;

public class Fragment_2 extends Fragment {
    RecyclerView recyclerView;
    LawmakingAdapter adapter;
    ArrayList<lawmake> search_list = new ArrayList<>();
    ArrayList<lawmake> original_list = new ArrayList<>();
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.frame_2, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.pass_lawmake_notion);
        recyclerView.setLayoutManager(new LinearLayoutManager(((RecyclerView) rootView.findViewById(R.id.pass_lawmake_notion)).getContext(),RecyclerView.VERTICAL,false));
        adapter = new LawmakingAdapter();

        original_list.add(new lawmake("우리의 우주는 실존하는게 맞는가?", "20994", "지평선","2020-10-5 ~ 2021-10-4", "오르트 구름"));
        original_list.add(new lawmake("은하계는 사실 작은 먼지에 불과하지 안흘까?", "21124", "우주","2022-10-5 ~ 2023-10-4", "은하계 탐구회"));
        original_list.add(new lawmake("자각몽을 꾸는 조건은 무엇인가?", "23355", "수면중","2020-10-5 ~ 2021-10-4", "수면 연구소"));
        original_list.add(new lawmake("우리의 우주는 실존하는게 맞는가?", "20994", "지평선","2020-10-5 ~ 2021-10-4", "오르트 구름"));
        original_list.add(new lawmake("은하계는 사실 작은 먼지에 불과하지 안흘까?", "21124", "우주","2022-10-5 ~ 2023-10-4", "은하계 탐구회"));
        original_list.add(new lawmake("자각몽을 꾸는 조건은 무엇인가?", "23355", "수면중","2020-10-5 ~ 2021-10-4", "수면 연구소"));
        original_list.add(new lawmake("우리의 우주는 실존하는게 맞는가?", "20994", "지평선","2020-10-5 ~ 2021-10-4", "오르트 구름"));
        original_list.add(new lawmake("은하계는 사실 작은 먼지에 불과하지 안흘까?", "21124", "우주","2022-10-5 ~ 2023-10-4", "은하계 탐구회"));
        original_list.add(new lawmake("자각몽을 꾸는 조건은 무엇인가?", "23355", "수면중","2020-10-5 ~ 2021-10-4", "수면 연구소"));
        original_list.add(new lawmake("우리의 우주는 실존하는게 맞는가?", "20994", "지평선","2020-10-5 ~ 2021-10-4", "오르트 구름"));
        original_list.add(new lawmake("은하계는 사실 작은 먼지에 불과하지 안흘까?", "21124", "우주","2022-10-5 ~ 2023-10-4", "은하계 탐구회"));
        original_list.add(new lawmake("자각몽을 꾸는 조건은 무엇인가?", "23355", "수면중","2020-10-5 ~ 2021-10-4", "수면 연구소"));
        original_list.add(new lawmake("우리의 우주는 실존하는게 맞는가?", "20994", "지평선","2020-10-5 ~ 2021-10-4", "오르트 구름"));
        original_list.add(new lawmake("은하계는 사실 작은 먼지에 불과하지 안흘까?", "21124", "우주","2022-10-5 ~ 2023-10-4", "은하계 탐구회"));
        original_list.add(new lawmake("자각몽을 꾸는 조건은 무엇인가?", "23355", "수면중","2020-10-5 ~ 2021-10-4", "수면 연구소"));


        adapter.setItems(original_list);
        recyclerView.setAdapter(adapter);

        editText = ((LawMakingActivity)getActivity()).findViewById(R.id.search_lawmake_text);

        // editText 리스터 작성

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String searchText = editText.getText().toString();
                search_list.clear();

                if (searchText.equals("")) {
                    adapter.setItems(original_list);
                } else {
                    // 검색 단어를 포함하는지 확인
                    for (int a = 0; a < original_list.size(); a++) {
                        if (original_list.get(a).getTitle().toLowerCase().contains(searchText.toLowerCase()) ||
                                original_list.get(a).getNum().toLowerCase().contains(searchText.toLowerCase()) ||
                                original_list.get(a).getUser().toLowerCase().contains(searchText.toLowerCase()) ||
                                original_list.get(a).getDay().toLowerCase().contains(searchText.toLowerCase()) ||
                                original_list.get(a).getAssociation().toLowerCase().contains(searchText.toLowerCase())) {
                            search_list.add(original_list.get(a));
                        }
                        adapter.setItems(search_list);
                    }
                }
            }
        });
        recyclerView.setAdapter(adapter);

        return rootView;
    }

}