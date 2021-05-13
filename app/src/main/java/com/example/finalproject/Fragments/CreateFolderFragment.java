package com.example.finalproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.finalproject.Entities.Folder;
import com.example.finalproject.databinding.CreateFolderFragmentBinding;

import java.util.ArrayList;

public class CreateFolderFragment extends DialogFragment {
    private CreateFolderFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Создание папки");
        binding = CreateFolderFragmentBinding.inflate(inflater, container, false);
        binding.createFolderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String theme = binding.folderNameEditText.getText().toString();
                Folder folder = new Folder(theme, new ArrayList<>(), "lptnkv");
                ((FoldersFragment) getParentFragment()).mViewModel.insert(folder);
                dismiss();
            }
        });
        return binding.getRoot();
    }
}
