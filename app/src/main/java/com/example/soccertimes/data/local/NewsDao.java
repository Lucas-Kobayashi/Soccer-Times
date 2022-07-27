package com.example.soccertimes.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.soccertimes.domain.News;

import java.util.List;

@Dao
public interface NewsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(News news);

    @Query("SELECT * FROM news WHERE favorite = :favorite")
    List<News> loadFavoriteNews(boolean favorite);

}