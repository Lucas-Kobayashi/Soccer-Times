package com.example.soccertimes.ui.news;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.example.soccertimes.data.local.AppDatabase;
import com.example.soccertimes.data.remote.SoccerNewsApi;
import com.example.soccertimes.domain.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news = new MutableLiveData<>();
    private final SoccerNewsApi api;

    public NewsViewModel() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://lucas-kobayashi.github.io/Soccer-Times-API/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(SoccerNewsApi.class);

        this.findNews();
    }

    private void findNews() {
        api.getNews().enqueue(new Callback<List<News>>() {
            @Override
            public void onResponse(Call<List<News>> call, Response<List<News>> response) {
                if (response.isSuccessful()){
                    news.setValue(response.body());
                }else{
                    //TODO Pensar em uma estrategia para tratamento de errros
                }
            }

            @Override
            public void onFailure(Call<List<News>> call, Throwable t) {
                //TODO Pensar em uma estrategia para tratamento de errros
            }
        });
    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}