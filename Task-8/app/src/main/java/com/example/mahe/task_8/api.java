package com.example.mahe.task_8;

import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;
public interface api {
    @GET("marvel")
    Call<List<Mov>> getMov();
}
