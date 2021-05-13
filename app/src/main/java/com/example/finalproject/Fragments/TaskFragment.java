package com.example.finalproject.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.ObjectModels.Fabrics.IFabric;
import com.example.finalproject.MainActivity;
import com.example.finalproject.ObjectModels.ITask;
import com.example.finalproject.R;
import com.example.finalproject.databinding.TaskFragmentBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class TaskFragment extends Fragment {
    private TaskFragmentBinding binding;

    ArrayList<ITask> tasks;
    int currentIndex;
    ITask currentTask;
    int number_of_tasks;
    int number_of_right_answers;
    private static final int[] buttons = {
            R.id.firstButton,
            R.id.secondButton,
            R.id.thirdButton,
            R.id.forthButton,
            R.id.yesButton,
            R.id.noButton
    };

    public TaskFragment(ArrayList<IFabric> fabrics, int number_of_tasks, Folder folder) {
        currentIndex = 0;
        this.number_of_tasks = Math.min(folder.cards.size(), number_of_tasks);
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < folder.cards.size(); i++){
            indices.add(i);
        }
        Collections.shuffle(indices);
        Log.d("TaskFragment", indices.toString());
        tasks = new ArrayList<>();
        for (int i = 0; i < this.number_of_tasks; i++){
            int randomFabricIndex = new Random().nextInt(fabrics.size());
            Log.d("TaskFragment", Integer.toString(randomFabricIndex));
            Log.d("TaskFragment", Integer.toString(indices.get(i)));
            ITask task = fabrics.get(randomFabricIndex).generateTask(folder, indices.get(i));
            tasks.add(task);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TaskFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        updateFragment();
        for (int i = 0; i < buttons.length; i++){
            Button button = view.findViewById(buttons[i]);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (currentTask.validateTask(button.getText().toString())){
                        number_of_right_answers++;
                    }
                    updateFragment();
                }
            });
        }
        binding.checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentTask.validateTask(binding.checkButton.getText().toString())){
                    number_of_right_answers++;
                }
                updateFragment();
            }
        });
        return view;
    }

    public void updateFragment(){
        if (currentIndex == tasks.size()){
            MainActivity.getInstance().removeFragment(this);
            showResult();
        } else {
            String numViewText = Integer.toString(currentIndex + 1) +
                    " / " + Integer.toString(this.number_of_tasks);
            binding.numView.setText(numViewText);
            currentTask = tasks.get(currentIndex);
            binding.taskTextView.setText(currentTask.text);
            switch (currentTask.type){
                case YesNo:{
                    binding.yesNoLayout.setVisibility(View.VISIBLE);
                    binding.chooseLayout.setVisibility(View.GONE);
                    binding.writeLayout.setVisibility(View.GONE);
                    break;
                }
                case Write:{
                    binding.yesNoLayout.setVisibility(View.GONE);
                    binding.chooseLayout.setVisibility(View.GONE);
                    binding.writeLayout.setVisibility(View.VISIBLE);
                    break;
                }
                case Choose:{
                    binding.yesNoLayout.setVisibility(View.GONE);
                    binding.chooseLayout.setVisibility(View.VISIBLE);
                    binding.writeLayout.setVisibility(View.GONE);
                    binding.firstButton.setText(currentTask.options.get(0));
                    binding.firstButton.setText(currentTask.options.get(1));
                    binding.firstButton.setText(currentTask.options.get(2));
                    binding.firstButton.setText(currentTask.options.get(3));
                    break;
                }
            }
        }
    }

    public void showResult(){
        Toast.makeText(getContext(), "Правильных ответов: " +
                Integer.toString(number_of_right_answers),
                Toast.LENGTH_SHORT).show();
    }
}
