package com.nilesh.mvvmnewsapidemo.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nilesh.mvvmnewsapidemo.model.NewsResponseModel;
import com.nilesh.mvvmnewsapidemo.net.NewsApi;
import com.nilesh.mvvmnewsapidemo.net.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    MutableLiveData<NewsResponseModel> mutableLiveData = new MutableLiveData<>();




    public MutableLiveData<NewsResponseModel> getNewsList() {

        Log.i("phondenilesh", "Repository getNewsList");


        NewsApi api = RetrofitClient.getRetrofitClient().create(NewsApi.class);

        Call<NewsResponseModel> call = api.getNewsList("windows",
                "2021-12-02", "2021-12-02", "popularity", "37b3c89b454a4bd5a2f90b0d23c666ff");

        call.enqueue(new Callback<NewsResponseModel>() {
            @Override
            public void onResponse(Call<NewsResponseModel> call, Response<NewsResponseModel> response) {
                mutableLiveData.setValue(response.body());

                Log.i("phondenilesh", "Repository onResponse");
            }

            @Override
            public void onFailure(Call<NewsResponseModel> call, Throwable t) {

            }
        });

        return mutableLiveData;
    }
}
