package com.example.finalproject.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finalproject.Models.Card;

import java.util.List;

@Dao
public interface CardDao {
    @Query("SELECT * FROM card")
    List<Card> getAll();

    @Query("SELECT * FROM card WHERE theme = :theme")
    List<Card> getThemeCards(String theme);

    @Insert
    void insert(Card cart);

    @Update
    void update(Card card);

    @Delete
    void delete(Card card);
}
