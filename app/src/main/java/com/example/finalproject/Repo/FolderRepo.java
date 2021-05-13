package com.example.finalproject.Repo;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.finalproject.Database.AppDatabase;
import com.example.finalproject.Database.Dao.FolderDao;
import com.example.finalproject.Database.Entities.Folder;

import java.util.List;

public class FolderRepo {
    private FolderDao folderDao;
    private LiveData<List<Folder>> allFolders;

    public FolderRepo(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        folderDao = db.folderDao();
        allFolders = folderDao.getAll();
    }

    public void insert(Folder folder){
        AppDatabase.databaseWriteExecutor.execute(()->{
            folderDao.insertFolder(folder);
        });
    }

    public void update(Folder folder){
        AppDatabase.databaseWriteExecutor.execute(()->{
            folderDao.update(folder);
        });
    }

    public void delete(Folder folder){
        AppDatabase.databaseWriteExecutor.execute(()->{
            folderDao.delete(folder);
        });
    }

    public LiveData<List<Folder>> getAllFolders() {
        return allFolders;
    }
}
