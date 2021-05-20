package com.example.finalproject.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Adapters.CloudFolderAdapter;
import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.MainActivity;
import com.example.finalproject.Network.Network;
import com.example.finalproject.ViewModel.CloudFolderViewModel;
import com.example.finalproject.databinding.CloudFoldersFragmentBinding;

import java.util.ArrayList;
import java.util.List;

public class CloudFoldersFragment extends Fragment {
    private CloudFoldersFragmentBinding binding;
    public List<Folder> folders = new ArrayList<>();
    private RecyclerView recyclerView;
    public CloudFolderViewModel viewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Cloud Folders Fragment", "Cloud Folders created");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = CloudFoldersFragmentBinding.inflate(inflater, container, false);
        // binding.foldersRecyclerView.setAdapter(new CloudFolderAdapter(getContext(), folders));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("Cloud Folders Fragment", "Cloud Folders view created");
        viewModel = MainActivity.getInstance().getCloudFolderViewModel();
        viewModel.getCloudFolders().observe(getViewLifecycleOwner(), folders -> {
            Log.d("CloudFoldersFragment", folders.toString());
            binding.foldersRecyclerView.setAdapter(new CloudFolderAdapter(this.getContext(), folders));
        });
    }


}