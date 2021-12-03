package com.nilesh.mvvmnewsapidemo.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.nilesh.mvvmnewsapidemo.R;
import com.nilesh.mvvmnewsapidemo.adapter.NewsAdapter;
import com.nilesh.mvvmnewsapidemo.model.Article;
import com.nilesh.mvvmnewsapidemo.model.NewsResponseModel;
import com.nilesh.mvvmnewsapidemo.viewmodel.NewsViewModel;

import java.util.ArrayList;
import java.util.List;

public class NewsActivity extends AppCompatActivity {

    List<Article> list;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        list = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NewsViewModel newsViewModel  = new ViewModelProvider(NewsActivity.this).get(NewsViewModel.class);


        newsViewModel.getLiveData().observe(this, new Observer<NewsResponseModel>() {
            @Override
            public void onChanged(NewsResponseModel newsResponseModel) {
                list.addAll(newsResponseModel.articles);

                NewsAdapter adapter = new NewsAdapter(list, getApplicationContext());
                recyclerView.setAdapter(adapter);
            }
        });
    }
}