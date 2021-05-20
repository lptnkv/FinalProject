package com.example.finalproject;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalproject.Database.AppDatabase;
import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.Database.Entities.User;
import com.example.finalproject.Fragments.FoldersFragment;
import com.example.finalproject.Fragments.LoginFragment;
import com.example.finalproject.Network.Network;
import com.example.finalproject.Repo.FolderRepo;
import com.example.finalproject.ViewModel.CloudFolderViewModel;
import com.example.finalproject.ViewModel.FolderViewModel;
import com.example.finalproject.databinding.ActivityMainBinding;

import java.nio.file.Path;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static MainActivity instance;
    private ActivityMainBinding binding;
    public LoginFragment loginFragment;
    public FolderViewModel folderViewModel;
    public CloudFolderViewModel cloudFolderViewModel;
    public User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        AppDatabase.databaseWriteExecutor.execute(()->{
            List<User> activeUser = AppDatabase.getDatabase(getApplicationContext()).userDao().getByActive();
            if (activeUser.isEmpty()){
                loginFragment = new LoginFragment();
                getSupportFragmentManager().beginTransaction().add(R.id.mainFrame, loginFragment).commit();
            } else {
                currentUser = activeUser.get(0);
                getSupportFragmentManager().beginTransaction().add(R.id.mainFrame, new FoldersFragment()).commit();
            }
        });

        this.folderViewModel = new ViewModelProvider(this).get(FolderViewModel.class);
        this.cloudFolderViewModel = new ViewModelProvider(this).get(CloudFolderViewModel.class);
    }

    public void replaceFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(fragment.getClass().toString());
        ft.replace(R.id.mainFrame, fragment);
        ft.commit();
    }

    public void removeTaskFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.remove(fragment);
        ft.commit();
        getSupportFragmentManager().popBackStack();
        getSupportFragmentManager().popBackStack();
    }

    public void login(){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.remove(loginFragment);
        ft.replace(R.id.mainFrame, new FoldersFragment());
        ft.commit();
    }

    public static MainActivity getInstance() {
        return instance;
    }

    public FolderViewModel getFolderViewModel() {
        return folderViewModel;
    }

    public CloudFolderViewModel getCloudFolderViewModel(){
        return cloudFolderViewModel;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user){
        this.currentUser = user;
    }
}