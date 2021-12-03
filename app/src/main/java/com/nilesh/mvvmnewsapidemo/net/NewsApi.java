package com.nilesh.mvvmnewsapidemo.net;

import com.nilesh.mvvmnewsapidemo.model.NewsResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApi {

    @GET("/v2/everything")
    Call<NewsResponseModel> getNewsList(@Query("q") String q, @Query("from") String from,
                                              @Query("to") String to, @Query("sortBy") String sortBy,
                                              @Query("apiKey") String apiKey);
}
