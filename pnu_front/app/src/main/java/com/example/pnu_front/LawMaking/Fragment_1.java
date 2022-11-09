package com.example.pnu_front.LawMaking;


import static android.widget.Toast.LENGTH_SHORT;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuItemCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pnu_front.LawMakingActivity;
import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.adapter.LawmakingAdapter;
import com.example.pnu_front.peititon.PendingPetitionModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_1 extends Fragment {
    RecyclerView recyclerView;
    LawmakingAdapter adapter;
    ArrayList<LawMakingModel> search_list = new ArrayList<>();
    Call<List<LawMakingModel>> call;
    List<LawMakingModel> result = new ArrayList<>();
    MenuItem menuItem;
    SearchView searchView;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.frame_1, container, false);

        recyclerView = (RecyclerView)rootView.findViewById(R.id.progress_lawmake_notion);
        recyclerView.setLayoutManager(new LinearLayoutManager(((RecyclerView) rootView.findViewById(R.id.progress_lawmake_notion)).getContext(),RecyclerView.VERTICAL,false));
        adapter = new LawmakingAdapter(result);


        call = RetrofitInstance.getApiService().getLegislativeStatus();
        call.enqueue(new Callback<List<LawMakingModel>>() {
            @Override
            public void onResponse(Call<List<LawMakingModel>> call, Response<List<LawMakingModel>> response) {
                result = response.body();
                adapter.setItems(result);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<LawMakingModel>> call, Throwable t) {

            }
        });

        recyclerView.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_item, menu);
        menuItem = menu.findItem(R.id.searchId);
        searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setIconified(true);

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                fileterList(newText);
                return false;
            }
        });


        super.onCreateOptionsMenu(menu, inflater);
    }

    private void fileterList(String text) {
        List<LawMakingModel> filteredList = new ArrayList<>();
        for (LawMakingModel item : result) {
            if (item.getBill_name().contains(text)) {
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()) {
            //Toast.makeText(this,"입력된 정보가 없습니다", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setFilteredList(filteredList);
        }
    }
}
