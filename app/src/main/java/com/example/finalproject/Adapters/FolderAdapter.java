package com.example.finalproject.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.Fragments.FolderFragment;
import com.example.finalproject.MainActivity;
import com.example.finalproject.R;
import com.example.finalproject.databinding.FolderItemBinding;

import java.util.List;

public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Folder> folders;
    RecyclerView recyclerView;
    FolderItemBinding binding;

    public FolderAdapter(Context context, List<Folder> folders) {
        this.inflater = LayoutInflater.from(context);
        this.folders = folders;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public FolderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = FolderItemBinding.inflate(inflater, parent, false);
        View view = binding.getRoot();
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildLayoutPosition(v);
                MainActivity.getInstance().replaceFragment(new FolderFragment(folders.get(position)));
            }
        });
        binding.deleteFolderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildLayoutPosition(view);
                Log.d("FolderAdapter", Integer.toString(position));
                MainActivity.getInstance().getViewModel().delete(folders.get(position));
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FolderAdapter.ViewHolder holder, int position) {
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
