package com.example.soccertimes.data.remote;

import com.example.soccertimes.domain.News;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.Call;

public interface SoccerNewsApi {

    @GET("news.json")
    Call<List<News>> getNews();
}
