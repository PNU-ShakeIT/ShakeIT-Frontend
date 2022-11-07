package com.example.pnu_front.RetrofitMananger;

import java.util.List;

import com.example.pnu_front.Calender.CalenderModel;
import com.example.pnu_front.Calender.CalenderModer;
import com.example.pnu_front.LawMaking.LawMakingModel;
import com.example.pnu_front.ProcessedBill.ProcessedBillModel;
import com.example.pnu_front.peititon.PendingPetitionModel;
import com.example.pnu_front.peititon.ProcessedPetitionModel;
import com.example.pnu_front.profile.ProfileModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitService {

    @GET("getCongressMember")
    Call<List<ProfileModel>> getCongressMember();

    @GET("getCalendar")
    Call<List<CalenderModel>> getCalendar();

    @GET("getPendingPetition")
    Call<List<PendingPetitionModel>> getPendingPetition();

    @GET("getProcessedPetition")
    Call<List<ProcessedPetitionModel>> getProcessedPetition();

    @GET("getLegislativeStatus")
    Call<List<LawMakingModel>> getLegislativeStatus();

    @GET("getBill")
    Call<List<ProcessedBillModel>> getBill();
}
