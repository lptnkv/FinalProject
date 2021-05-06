package com.example.finalproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalproject.Models.ITask;
import com.example.finalproject.databinding.TaskLayoutBinding;

import java.util.ArrayList;


public class TaskFragment extends Fragment {
    private TaskLayoutBinding binding;

    ArrayList<ITask> tasks;
    int currentTask;

    public TaskFragment(String theme) {
        currentTask = 0;
        tasks = new ArrayList<>();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TaskLayoutBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void updateFragment(){
        currentTask++;
        if (currentTask  == tasks.size()){
            showResult();
        } else {
            switch (tasks.get(currentTask).type){
                case Pair:{

                    break;
                }
                case Write:{

                    break;
                }
                case Choose:{

                    break;
                }
            }
        }
    }

    public void showResult(){
        Toast.makeText(getContext(), "The end", Toast.LENGTH_SHORT).show();
    }
}
