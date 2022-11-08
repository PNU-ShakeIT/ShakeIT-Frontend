package com.example.pnu_front.ProcessedBill;

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

import com.example.pnu_front.LawMakingActivity;
import com.example.pnu_front.LawMaking.LawMakingModel;
import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.adapter.LawmakingAdapter;
import com.example.pnu_front.adapter.ProcessedBillAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_2 extends Fragment {
    RecyclerView recyclerView;
    ProcessedBillAdapter adapter;
    ArrayList<ProcessedBillModel> search_list = new ArrayList<>();
    Call<List<ProcessedBillModel>> call;
    List<ProcessedBillModel> result = new ArrayList<>();
    EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.frame_2, container, false);
        recyclerView = (RecyclerView)rootView.findViewById(R.id.pass_lawmake_notion);
        recyclerView.setLayoutManager(new LinearLayoutManager(((RecyclerView) rootView.findViewById(R.id.pass_lawmake_notion)).getContext(),RecyclerView.VERTICAL,false));
        adapter = new ProcessedBillAdapter(result);

        call = RetrofitInstance.getApiService().getBill();
        call.enqueue(new Callback<List<ProcessedBillModel>>() {
            @Override
            public void onResponse(Call<List<ProcessedBillModel>> call, Response<List<ProcessedBillModel>> response) {
                result = response.body();
                adapter.setItems(result);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<ProcessedBillModel>> call, Throwable t) {

            }
        });

//        editText = ((LawMakingActivity)getActivity()).findViewById(R.id.search_lawmake_text);
//
//        // editText 리스터 작성
//
//        editText.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                String searchText = editText.getText().toString();
//                search_list.clear();
//
//                if (searchText.equals("")) {
//                    adapter.setItems(result);
//                } else {
//                    // 검색 단어를 포함하는지 확인
//                    for (int a = 0; a < result.size(); a++) {
//                        if (result.get(a).getBill_name().toLowerCase().contains(searchText.toLowerCase()) ||
//                                result.get(a).getBill_num().toLowerCase().contains(searchText.toLowerCase()) ||
//                                result.get(a).getProposer().toLowerCase().contains(searchText.toLowerCase()) ||
//                                result.get(a).getAnnounce_dt().toLowerCase().contains(searchText.toLowerCase()) ||
//                                result.get(a).getCommittee_nm().toLowerCase().contains(searchText.toLowerCase())) {
//                            search_list.add(result.get(a));
//                        }
//                        adapter.setItems(search_list);
//                    }
//                }
//            }
//        });
//        recyclerView.setAdapter(adapter);

        return rootView;
    }

}