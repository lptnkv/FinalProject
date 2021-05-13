package com.example.finalproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.finalproject.Entities.Card;
import com.example.finalproject.Entities.Folder;
import com.example.finalproject.MainActivity;
import com.example.finalproject.databinding.AddCardDialogBinding;

import java.util.ArrayList;

public class AddCardDialog extends DialogFragment {
    AddCardDialogBinding binding;
    Folder folder;

    public AddCardDialog(Folder folder) {
        this.folder = folder;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Создание папки");
        binding = AddCardDialogBinding.inflate(inflater, container, false);
        binding.createFolderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rusWord = binding.rusWordView.getText().toString();
                String engWord = binding.engWordView.getText().toString();
                folder.cards.add(new Card(rusWord, engWord));
                MainActivity.getInstance().getViewModel().update(folder);
                int size = ((FolderFragment) getParentFragment()).folder.cards.size();
                ((FolderFragment) getParentFragment()).adapter.notifyItemInserted(size - 1);
                dismiss();
            }
        });
        return binding.getRoot();
    }
}
