package com.example.pnu_front.profile;

import static com.example.pnu_front.R.id.searchView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
//import android.widget.SearchView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pnu_front.MainActivity;
import com.example.pnu_front.ProgressDialog;
import com.example.pnu_front.R;
import com.example.pnu_front.RetrofitMananger.RetrofitInstance;
import com.example.pnu_front.RetrofitMananger.RetrofitService;
import com.example.pnu_front.adapter.profileadapter;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity implements OnitemClick {

    RecyclerView recyclerView;
    EditText editText;
    RecyclerView.Adapter adapter;
    profileadapter myadapter;
    RecyclerView.LayoutManager layoutManager;
    Call<List<ProfileModel>> call;
    List<ProfileModel> result = new ArrayList<>();
    List<ProfileModel> search_list = new ArrayList<>();
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        progressDialog.setCancelable(false);
        progressDialog.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                progressDialog.dismiss();
            }
        }, 1300); //????????? ?????? ??????



        ImageView imageView = findViewById(R.id.Congress_member_listsizebtn);
        RecyclerView congressmember = findViewById(R.id.congress_member_list);
        FrameLayout memberprofile = findViewById(R.id.congress_member_profile);
        TextView status = findViewById(R.id.status);//0?????? ?????? ?????? 1?????? ?????? ??????
        View back = findViewById(R.id.profile_back);

        searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        final int wide_height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 420, getResources().getDisplayMetrics());
        final int small_height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 215, getResources().getDisplayMetrics());
        ViewGroup.LayoutParams params = congressmember.getLayoutParams();
        params.height = wide_height;
        congressmember.setLayoutParams(params);
        memberprofile.setVisibility(View.GONE);
        imageView.setBackgroundResource(R.drawable.up_right);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(status.getText() == "0") {
                   ViewGroup.LayoutParams params = congressmember.getLayoutParams();
                    params.height = wide_height;
                    congressmember.setLayoutParams(params);
                    memberprofile.setVisibility(View.GONE);
                    imageView.setBackgroundResource(R.drawable.up_right);
                    status.setText("1");
                }
                else
                {
                    ViewGroup.LayoutParams params = congressmember.getLayoutParams();
                    params.height = small_height;
                    congressmember.setLayoutParams(params);
                    memberprofile.setVisibility(View.VISIBLE);
                    imageView.setBackgroundResource(R.drawable.down_right);
                    status.setText("0");

                }
            }
        });

        String[] str = getResources().getStringArray(R.array.spinnerArray);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.spinner_age,str);
        adapter.setDropDownViewResource(androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);
        Spinner spinner_field =(Spinner)findViewById(R.id.spinner_age);
        spinner_field.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (spinner_field.getSelectedItemPosition() > 0){
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_field.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        congressmember.setLayoutManager(layoutManager);

        call = RetrofitInstance.getApiService().getCongressMember();
        call.enqueue(new Callback<List<ProfileModel>>() {
            @Override
            public void onResponse(Call<List<ProfileModel>> call, Response<List<ProfileModel>> response) {
                result = response.body();
                myadapter = new profileadapter(getApplicationContext(), result, Profile.this);
                congressmember.setAdapter(myadapter);
            }

            @Override
            public void onFailure(Call<List<ProfileModel>> call, Throwable t) {

            }
        });
    }

    private void filterList(String text) {
        List<ProfileModel> filteredList = new ArrayList<>();

        for(ProfileModel item : result){
            if(item.getHg_NM().contains(text)){
                filteredList.add(item);
            } else if(item.getPoly_NM().contains(text)){
                filteredList.add(item);
            }
        }

        if(filteredList.isEmpty()){
            //Toast.makeText(this, "????????? ????????? ????????????", Toast.LENGTH_SHORT).show();
        } else {
            RecyclerView congressmember = findViewById(R.id.congress_member_list);
            myadapter = new profileadapter(getApplicationContext(), result, Profile.this);
           myadapter.setFilteredList(filteredList);
           congressmember.setAdapter(myadapter);
        }
    }
    public static int ConvertDPtoPX(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round((float) dp * density);
    }
    @Override
    public void onClick(int value) {
        final int small_height = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 215, getResources().getDisplayMetrics());
        RecyclerView congressmember = findViewById(R.id.congress_member_list);
        FrameLayout memberprofile = findViewById(R.id.congress_member_profile);
        ViewGroup.LayoutParams params = congressmember.getLayoutParams();
        params.height = small_height;
        ImageView imageView = findViewById(R.id.Congress_member_listsizebtn);
        congressmember.setLayoutParams(params);
        memberprofile.setVisibility(View.VISIBLE);
        imageView.setBackgroundResource(R.drawable.down_right);
        TextView status = findViewById(R.id.status);
        status.setText("0");
        ImageView img = findViewById(R.id.image_profile);
        String url = result.get(value).getImg_URL();

        Glide.with(this).load(url).override(200,300).into(img);

        TextView name = findViewById(R.id.text_profile_name);
        TextView hj_name = findViewById(R.id.text_profile_hj_NM);
        TextView eng_name = findViewById(R.id.text_profile_eng_NM_birth);
        TextView orig = findViewById(R.id.text_profile_orig);
        TextView cmits = findViewById(R.id.text_profile_cmits);
        TextView units = findViewById(R.id.text_profile_units);
        TextView tel_Num = findViewById(R.id.text_profile_telNum);
        TextView homepage = findViewById(R.id.text_profile_homepage);
        TextView email = findViewById(R.id.text_profile_email);
        TextView secretary1 = findViewById(R.id.text_profile_secretary);
        TextView secretary2 = findViewById(R.id.text_profile_secretary2);
        name.setText(result.get(value).getHg_NM());
        hj_name.setText(result.get(value).getHj_NM());
        eng_name.setText(result.get(value).getEng_NM()+" "+result.get(value).getBth_DATE());
        orig.setText(result.get(value).getOrig_NM());
        cmits.setText(result.get(value).getCmits());
        units.setText(result.get(value).getUnits());
        tel_Num.setText(result.get(value).getTel_NO());
        homepage.setText(result.get(value).getHomepage());
        email.setText(result.get(value).getE_MAIL());
        secretary1.setText(result.get(value).getSecretary());
        secretary2.setText(result.get(value).getSecretary2());


    }
}