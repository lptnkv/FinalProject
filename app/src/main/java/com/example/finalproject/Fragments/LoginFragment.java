package com.example.finalproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalproject.Database.AppDatabase;
import com.example.finalproject.Database.Entities.User;
import com.example.finalproject.MainActivity;
import com.example.finalproject.databinding.LoginFragmentBinding;


public class LoginFragment extends Fragment {

    LoginFragmentBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = LoginFragmentBinding.inflate(inflater, container, false);
        binding.startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nickname = binding.nameTextView.getText().toString();

                if (!nickname.isEmpty()){
                    User currentUser = new User(nickname);
                    AppDatabase.databaseWriteExecutor.execute(()->{
                            AppDatabase.getDatabase(getContext()).userDao().insert(currentUser);
                    });
                    MainActivity.getInstance().setCurrentUser(currentUser);
                    MainActivity.getInstance().login();
                } else {
                    Toast.makeText(getContext(), "Введите никнейм", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return binding.getRoot();
    }
}
