package com.example.finalproject.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.finalproject.Database.Dao.CardDao;
import com.example.finalproject.Database.Dao.FolderDao;
import com.example.finalproject.Models.Card;
import com.example.finalproject.Models.Folder;


@Database(entities = {Folder.class, Card.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CardDao cardDao();
    public abstract FolderDao folderDao();

    private static AppDatabase instance = null;

    public static AppDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class,
                            "app_database.db").build();
                }
            }
        }
        return instance;
    }
}
