package com.example.finalproject;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.finalproject.Fragments.MenuFragment;
import com.example.finalproject.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {
    private static MainActivity instance;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportFragmentManager().beginTransaction().add(R.id.mainFrame, new MenuFragment()).commit();

    }

    public static MainActivity getInstance() {
        return instance;
    }
}