package com.example.pnu_front.RetrofitMananger;

import java.util.List;

import com.example.pnu_front.Calender.CalenderModer;
import com.example.pnu_front.peititon.PendingPetitionModel;
import com.example.pnu_front.profile.ProfileModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("getCongressMember")
    Call<List<ProfileModel>> getPosts();

    @GET("getCalendar")
    Call<List<CalenderModer>> getCalendar();

    @GET("getPendingPetition")
    Call<List<PendingPetitionModel>> getPendingPetition();

}
