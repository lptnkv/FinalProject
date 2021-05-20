package com.example.finalproject.Adapters;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.Fragments.FolderFragment;
import com.example.finalproject.MainActivity;
import com.example.finalproject.R;
import com.example.finalproject.databinding.CloudFolderItemBinding;

import java.util.List;

public class CloudFolderAdapter extends RecyclerView.Adapter<CloudFolderAdapter.ViewHolder> {

    Context context;
    private final LayoutInflater inflater;
    private final List<Folder> folders;
    RecyclerView recyclerView;
    CloudFolderItemBinding binding;

    public CloudFolderAdapter(Context context, List<Folder> folders) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.folders = folders;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public CloudFolderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CloudFolderItemBinding.inflate(inflater, parent, false);
        View view = binding.getRoot();
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildLayoutPosition(v);
                MainActivity.getInstance()
                        .getCloudFolderViewModel()
                        .saveFolder(folders.get(position));
                Toast.makeText(context, "Папка сохранена на устройстве", Toast.LENGTH_SHORT).show();
            }
        });
        binding.deleteFromCloudButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildLayoutPosition(view);
                MainActivity.getInstance()
                        .getCloudFolderViewModel()
                        .deleteFolder(folders.get(position));
                folders.remove(position);
                notifyItemRemoved(position);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CloudFolderAdapter.ViewHolder holder, int position) {
        Folder folder = folders.get(position);
        holder.themeView.setText(folder.theme);
        holder.creatorView.setText(folder.creator);
        holder.amountView.setText(Integer.toString(folder.cards.size()));
    }

    @Override
    public int getItemCount() {
        return folders.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        final TextView themeView, creatorView, amountView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.themeView = itemView.findViewById(R.id.themeView);
            this.creatorView = itemView.findViewById(R.id.creatorView);
            this.amountView = itemView.findViewById(R.id.amountView);
        }
    }
}