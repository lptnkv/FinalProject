package com.example.finalproject.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.Repo.FolderRepo;

import java.util.List;

public class FolderViewModel extends AndroidViewModel {
    private FolderRepo foldersRepo;
    private LiveData<List<Folder>> savedFolders;

    public FolderViewModel(@NonNull Application application) {
        super(application);
        foldersRepo = FolderRepo.getInstance(application.getApplicationContext());
        savedFolders = foldersRepo.getSavedFolders();
    }

    public void insert(Folder folder) {
        foldersRepo.insert(folder);
    }
    public void update(Folder folder) {
        foldersRepo.update(folder);
    }
    public void delete(Folder folder) {
        foldersRepo.delete(folder);
    }

    public LiveData<List<Folder>> getSavedFolders() {
        return savedFolders;
    }
}
