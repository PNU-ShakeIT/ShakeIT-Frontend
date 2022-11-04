package RetrofitMananger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import profile.ProfileModer;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("getCongressMember")
    Call<List<ProfileModer>> getPosts(@Query("name") String name);
}
