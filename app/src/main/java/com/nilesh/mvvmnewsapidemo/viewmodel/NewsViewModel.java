package com.nilesh.mvvmnewsapidemo.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.nilesh.mvvmnewsapidemo.model.NewsResponseModel;
import com.nilesh.mvvmnewsapidemo.repository.Repository;

import java.util.List;

public class NewsViewModel extends AndroidViewModel {

    private MutableLiveData<NewsResponseModel> liveData;
    Repository repository;


    public NewsViewModel(@NonNull Application application) {
        super(application);

        repository = new Repository();
    }


    public LiveData<NewsResponseModel> getLiveData() {
        if(liveData == null) {
            liveData =  repository.getNewsList();
        }
        return  liveData;
    }
}
