package com.example.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.finalproject.Database.AppDatabase;
import com.example.finalproject.Fragments.MenuFragment;
import com.example.finalproject.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private static MainActivity instance;
    private ActivityMainBinding binding;
    public FolderViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance = this;
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportFragmentManager().beginTransaction().add(R.id.mainFrame, new MenuFragment()).commit();
        this.mViewModel = new ViewModelProvider(this).get(FolderViewModel.class);
    }

    public void replaceFragment(Fragment fragment){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.addToBackStack(null);
        ft.replace(R.id.mainFrame, fragment);
        ft.commit();
    }

    public static MainActivity getInstance() {
        return instance;
    }

    public FolderViewModel getViewModel() {
        return mViewModel;
    }
}