package com.example.finalproject.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.finalproject.Database.Entities.Folder;

import java.util.List;

@Dao
public abstract class   FolderDao {
    @Query("SELECT * FROM folder")
    public abstract LiveData<List<Folder>> getAll();

    @Update
    public abstract void update(Folder folder);

    @Delete
    public abstract void delete(Folder folder);

    @Insert
    public abstract void insertFolder(Folder folder);

}
