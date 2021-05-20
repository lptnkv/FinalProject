package com.example.finalproject.Fragments;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.PrimaryKey;

import com.example.finalproject.databinding.TaskResultFragmentBinding;

public class TaskResultsFragment extends Fragment {
    int total_number;
    int right_answers;
    private TaskResultFragmentBinding binding;


    public TaskResultsFragment(int total_number, int right_answers) {
        this.total_number = total_number;
        this.right_answers = right_answers;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TaskResultFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        String result = Integer.toString(right_answers) + " / " + Integer.toString(total_number);
        binding.resultView.setText(result);
        if ((float) right_answers / total_number >= 0.75) {
            binding.resultInWordsView.setText("Отлично");
            binding.resultView.setTextColor(Color.GREEN);
        } else if ((float) right_answers / total_number >= 0.5){
            binding.resultInWordsView.setText("Хорошо");
            binding.resultView.setTextColor(Color.YELLOW);
        } else {
            binding.resultInWordsView.setText("Попробуйте снова");
            binding.resultView.setTextColor(Color.RED);
        }
        return view;
    }
}
