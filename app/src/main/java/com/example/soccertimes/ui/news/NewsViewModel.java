package com.example.soccertimes.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.soccertimes.domain.News;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

//        TODO Remover mock de noticias
        List<News> news = new ArrayList<>();
        news.add(new News("Ferroviária tem desfalques importantes", "Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        news.add(new News("Ferroviária joga sábado", "Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        news.add(new News("Copa do mundo feminina", "Lorem Ipsum is simply dummy text of the printing and typesetting industry."));

        this.news.setValue(news);
    }

    public LiveData<List<News>> getNews() {
        return news;
    }
}