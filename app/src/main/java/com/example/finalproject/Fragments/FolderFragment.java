package com.example.finalproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Adapters.CardAdapter;
import com.example.finalproject.Entities.Card;
import com.example.finalproject.Entities.Folder;
import com.example.finalproject.MainActivity;
import com.example.finalproject.databinding.FolderFragmentBinding;

import java.util.ArrayList;

public class FolderFragment extends Fragment {
    FolderFragmentBinding binding;
    Folder folder;
    public RecyclerView recyclerView;
    public CardAdapter adapter;

    public FolderFragment(Folder folder) {
        this.folder = folder;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FolderFragmentBinding.inflate(inflater, container, false);
        recyclerView = binding.cardsRecyclerView;
        adapter = new CardAdapter(getContext(), folder);
        recyclerView.setAdapter(adapter);
        binding.addCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddCardDialog dlg = new AddCardDialog(folder);
                dlg.show(getChildFragmentManager(), "dlg");
            }
        });
        binding.tasksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getInstance().replaceFragment(new SelectTaskFragment(folder));
            }
        });
        return binding.getRoot();
    }
}