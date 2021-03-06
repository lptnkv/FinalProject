package com.example.finalproject.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.finalproject.Database.Dao.CardDao;
import com.example.finalproject.Database.Dao.FolderDao;
import com.example.finalproject.Database.Dao.UserDao;
import com.example.finalproject.Database.Entities.Card;
import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.Database.Entities.User;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {Folder.class, Card.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract CardDao cardDao();
    public abstract FolderDao folderDao();
    public abstract UserDao userDao();

    private static final int NUMBER_OF_THREADS = 4;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

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
