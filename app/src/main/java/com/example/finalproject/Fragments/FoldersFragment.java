package com.example.finalproject.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Adapters.FolderAdapter;
import com.example.finalproject.Entities.Folder;
import com.example.finalproject.FolderViewModel;
import com.example.finalproject.MainActivity;
import com.example.finalproject.databinding.FoldersFragmentBinding;

import java.util.ArrayList;

public class FoldersFragment extends Fragment {
    private FoldersFragmentBinding binding;
    public ArrayList<Folder> folders = new ArrayList<>();
    private RecyclerView recyclerView;
    public FolderViewModel mViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FoldersFragmentBinding.inflate(inflater, container, false);
        Log.d("FoldersFragment", Integer.toString(folders.size()));
        recyclerView = binding.foldersRecyclerView;
        binding.createFolderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateFolderFragment dlg1 = new CreateFolderFragment();
                dlg1.show(getChildFragmentManager(), "dlg1");
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FolderViewModel mViewModel = MainActivity.getInstance().getViewModel();

        mViewModel.getAllNotes().observe(getViewLifecycleOwner(), folders -> {
            binding.foldersRecyclerView.setAdapter(
                    new FolderAdapter(this.getContext(), folders)
            );
        });
    }
}
