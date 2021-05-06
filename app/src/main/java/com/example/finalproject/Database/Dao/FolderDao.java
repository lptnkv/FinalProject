package com.example.finalproject.Database.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.finalproject.Models.Card;
import com.example.finalproject.Models.Folder;

import java.util.List;

@Dao
public abstract class FolderDao {
    @Query("SELECT * FROM folder")
    public abstract List<Card>  getAll();

    @Query("SELECT * FROM folder WHERE theme=:theme")
    public abstract Folder getThemedFolder(String theme);

    @Update
    public abstract void update(Card card);

    @Delete
    public abstract void delete(Card card);

    @Insert
    public abstract void insertFolder(Folder folder);

    @Insert
    public abstract void insertCard(Card card);

    @Transaction
    public void insert(Folder folder){
        insertFolder(folder);
        for(Card card : folder.cards){
            insertCard(card);
        }
    }
}
