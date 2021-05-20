package com.example.finalproject.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.Repo.FolderRepo;

import java.util.List;

public class CloudFolderViewModel extends AndroidViewModel {
    private FolderRepo repo;
    private MutableLiveData<List<Folder>> cloudFolders;

    public CloudFolderViewModel(@NonNull Application application) {
        super(application);
        repo = FolderRepo.getInstance(application.getApplicationContext());
        cloudFolders = repo.getCloudFolders();
    }

    public MutableLiveData<List<Folder>> getCloudFolders(){
        cloudFolders = repo.getCloudFolders();
        return cloudFolders;
    }

    public void uploadFolder(Folder folder){
        repo.upload(folder);
        cloudFolders = repo.getCloudFolders();
    }

    public void saveFolder(Folder folder){
        repo.insert(folder);
    }

    public void deleteFolder(Folder folder) {
        repo.deleteFromCloud(folder);
        cloudFolders = repo.getCloudFolders();
    }
}
