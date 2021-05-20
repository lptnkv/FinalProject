package com.example.finalproject.Repo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.finalproject.Database.AppDatabase;
import com.example.finalproject.Database.Dao.FolderDao;
import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.Network.Network;

import java.util.List;

public class FolderRepo {
    private static FolderRepo instance;
    private FolderDao folderDao;
    private LiveData<List<Folder>> savedFolders;
    private MutableLiveData<List<Folder>> cloudFolders = new MutableLiveData<>();
    private Handler handler;


    public FolderRepo(Context context) {
        AppDatabase db = AppDatabase.getDatabase(context);
        folderDao = db.folderDao();
        savedFolders = folderDao.getAll();
        handler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                if (msg.obj instanceof List) {
                    List<Folder> cloudFoldersList = (List<Folder>) msg.obj;
                    cloudFolders.postValue(cloudFoldersList);
                }
            }
        };
        Network.getInstance().getFolders(handler);
    }


    public void insert(Folder folder){
        AppDatabase.databaseWriteExecutor.execute(()->{
            try{
                folderDao.insertFolder(folder);
            } catch (Exception e){
                e.printStackTrace();
            }

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

    public void upload(Folder folder){
        Network.getInstance().postFolder(folder);
    }

    public LiveData<List<Folder>> getSavedFolders() {
        return savedFolders;
    }

    public MutableLiveData<List<Folder>> getCloudFolders() {
        Network.getInstance().getFolders(handler);
        return cloudFolders;
    }

    public static FolderRepo getInstance(Context context){
        if (instance == null){
            instance = new FolderRepo(context);
        }
        return instance;
    }

    public void deleteFromCloud(Folder folder){
        Network.getInstance().deleteFolder(folder);
        Network.getInstance().getFolders(handler);
    }

    public void setCloudFolders(List<Folder> cloudFolders) {
        MutableLiveData<List<Folder>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(cloudFolders);
        this.cloudFolders = mutableLiveData;
    }
}