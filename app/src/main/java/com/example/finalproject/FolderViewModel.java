package com.example.finalproject;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.finalproject.Entities.Folder;
import com.example.finalproject.Repo.FolderRepo;

import java.util.ArrayList;
import java.util.List;

public class FolderViewModel extends AndroidViewModel {
    private FolderRepo foldersRepo;
    private LiveData<List<Folder>> allFolders;

    public FolderViewModel(@NonNull Application application) {
        super(application);
        foldersRepo = new FolderRepo(application);
        allFolders = foldersRepo.getAllFolders();
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

    public LiveData<List<Folder>> getAllNotes() {
        return allFolders;
    }
}
