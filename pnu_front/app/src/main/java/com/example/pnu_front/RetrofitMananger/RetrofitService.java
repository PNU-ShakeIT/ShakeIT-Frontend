package com.example.pnu_front.RetrofitMananger;

import java.util.List;

import com.example.pnu_front.profile.ProfileModer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("getCongressMember")
    Call<List<ProfileModer>> getPosts(@Query("name") String name);
}
