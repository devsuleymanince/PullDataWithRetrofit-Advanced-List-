package com.suleymanince.retrofitadvancedlist.RestApi;

import com.suleymanince.retrofitadvancedlist.Models.Bilgiler;
import com.suleymanince.retrofitadvancedlist.Models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RestApi {
    @GET("/comments")
    Call<List<Bilgiler>> bilgiGetir();

    @GET("/comments")
    Call<List<Result>> getirResult(@Query("postId") String postid, @Query("id") String id);
}
