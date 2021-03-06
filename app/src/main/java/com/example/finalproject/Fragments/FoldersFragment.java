package com.example.finalproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Adapters.FolderAdapter;
import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.MainActivity;
import com.example.finalproject.R;
import com.example.finalproject.ViewModel.FolderViewModel;
import com.example.finalproject.databinding.FoldersFragmentBinding;

import java.util.ArrayList;

public class FoldersFragment extends Fragment {
    private FoldersFragmentBinding binding;
    public ArrayList<Folder> folders = new ArrayList<>();
    public FolderViewModel mViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FoldersFragmentBinding.inflate(inflater, container, false);
        RecyclerView recyclerView = binding.foldersRecyclerView;
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
        binding.createFolderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreateFolderFragment dlg1 = new CreateFolderFragment();
                dlg1.show(getChildFragmentManager(), "dlg1");
            }
        });
        binding.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.getInstance().replaceFragment(new CloudFoldersFragment());
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = MainActivity.getInstance().getFolderViewModel();
        mViewModel.getSavedFolders().observe(getViewLifecycleOwner(), folders -> {
            binding.foldersRecyclerView.setAdapter(
                    new FolderAdapter(this.getContext(), folders)
            );
        });
    }
}
