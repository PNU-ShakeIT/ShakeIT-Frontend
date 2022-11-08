package com.example.pnu_front.LawMaking;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.R;

import java.util.ArrayList;

public class Fragment_1 extends Fragment {
    RecyclerView recyclerView;
    LawmakingAdapter adapter;
    ArrayList<lawmake> search_list = new ArrayList<>();
    ArrayList<lawmake> original_list = new ArrayList<>();
    EditText editText;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.frame_1, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.progress_lawmake_notion);
        recyclerView.setLayoutManager(new LinearLayoutManager(((RecyclerView) rootView.findViewById(R.id.progress_lawmake_notion)).getContext(),RecyclerView.VERTICAL,false));
        adapter = new LawmakingAdapter();

        original_list.add(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?", "25988", "섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회","http://adsdad.com", ""));
        original_list.add(new lawmake("성익이의 학생회는 sexmachine 만으로 구성 되는가?", "25988", "IT","2022-10-5 ~ 2023-10-4", "아이티 섹스 머신 위원회","http://adcsqw.com",""));
        original_list.add(new lawmake("뭐라고? 조만간 국회 핵폭탄 떨어진다고?", "25988", "김정은","2020-10-5 ~ 2021-10-4", "조선민주주의 공화국","http://asdqwr.com",""));
        original_list.add(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?", "25988", "섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회","http://adsdad.com", ""));
        original_list.add(new lawmake("성익이의 학생회는 sexmachine 만으로 구성 되는가?", "25988", "IT","2022-10-5 ~ 2023-10-4", "아이티 섹스 머신 위원회","http://adcsqw.com",""));
        original_list.add(new lawmake("뭐라고? 조만간 국회 핵폭탄 떨어진다고?", "25988", "김정은","2020-10-5 ~ 2021-10-4", "조선민주주의 공화국","http://asdqwr.com",""));
        original_list.add(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?", "25988", "섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회","http://adsdad.com", ""));
        original_list.add(new lawmake("성익이의 학생회는 sexmachine 만으로 구성 되는가?", "25988", "IT","2022-10-5 ~ 2023-10-4", "아이티 섹스 머신 위원회","http://adcsqw.com",""));
        original_list.add(new lawmake("뭐라고? 조만간 국회 핵폭탄 떨어진다고?", "25988", "김정은","2020-10-5 ~ 2021-10-4", "조선민주주의 공화국","http://asdqwr.com",""));
        original_list.add(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?", "25988", "섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회","http://adsdad.com", ""));
        original_list.add(new lawmake("성익이의 학생회는 sexmachine 만으로 구성 되는가?", "25988", "IT","2022-10-5 ~ 2023-10-4", "아이티 섹스 머신 위원회","http://adcsqw.com",""));
        original_list.add(new lawmake("뭐라고? 조만간 국회 핵폭탄 떨어진다고?", "25988", "김정은","2020-10-5 ~ 2021-10-4", "조선민주주의 공화국","http://asdqwr.com",""));
        original_list.add(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?", "25988", "섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회","http://adsdad.com", ""));
        original_list.add(new lawmake("성익이의 학생회는 sexmachine 만으로 구성 되는가?", "25988", "IT","2022-10-5 ~ 2023-10-4", "아이티 섹스 머신 위원회","http://adcsqw.com",""));
        original_list.add(new lawmake("뭐라고? 조만간 국회 핵폭탄 떨어진다고?", "25988", "김정은","2020-10-5 ~ 2021-10-4", "조선민주주의 공화국","http://asdqwr.com",""));
        original_list.add(new lawmake("민식이 같은 잼민이는 트럭으로 쳐도 되는가?", "25988", "섹스","2020-10-5 ~ 2021-10-4", "저출산 제거 위원회","http://adsdad.com", ""));
        original_list.add(new lawmake("성익이의 학생회는 sexmachine 만으로 구성 되는가?", "25988", "IT","2022-10-5 ~ 2023-10-4", "아이티 섹스 머신 위원회","http://adcsqw.com",""));
        original_list.add(new lawmake("뭐라고? 조만간 국회 핵폭탄 떨어진다고?", "25988", "김정은","2020-10-5 ~ 2021-10-4", "조선민주주의 공화국","http://asdqwr.com",""));

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