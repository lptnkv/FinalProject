package com.example.finalproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import androidx.fragment.app.Fragment;

import com.example.finalproject.Entities.Folder;
import com.example.finalproject.Fabrics.ChooseFabric;
import com.example.finalproject.Fabrics.IFabric;
import com.example.finalproject.Fabrics.WriteFabric;
import com.example.finalproject.Fabrics.YesNoFabric;
import com.example.finalproject.MainActivity;
import com.example.finalproject.databinding.SelectTaskFragmentBinding;

import java.util.ArrayList;

public class SelectTaskFragment extends Fragment {
    Folder folder;
    SelectTaskFragmentBinding binding;
    ArrayList<IFabric> fabrics;
    int number_of_tasks = 10;

    public SelectTaskFragment(Folder folder) {
        this.folder = folder;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = SelectTaskFragmentBinding.inflate(inflater, container, false);
        binding.startTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        return binding.getRoot();
    }

    public void onStartTaskButtonClick(View v){
        if (binding.writeTaskCheckBox.isChecked()){
            fabrics.add(new WriteFabric());
        }
        if (binding.chooseTaskCheckBox.isChecked()){
            fabrics.add(new ChooseFabric());
        }
        if (binding.yesNoTaskCheckBox.isChecked()){
            fabrics.add(new YesNoFabric());
        }
        MainActivity.getInstance().replaceFragment(new TaskFragment(fabrics, number_of_tasks, folder));
    }
}
