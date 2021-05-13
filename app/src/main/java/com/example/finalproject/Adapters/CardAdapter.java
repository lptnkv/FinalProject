package com.example.finalproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Database.Entities.Card;
import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.Fragments.SingleCardFragment;
import com.example.finalproject.MainActivity;
import com.example.finalproject.R;
import com.example.finalproject.databinding.CardItemBinding;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    public Folder folder;
    private String theme;
    RecyclerView recyclerView;
    CardItemBinding binding;

    public CardAdapter(Context context, Folder folder) {
        this.inflater = LayoutInflater.from(context);
        this.folder = folder;
        this.theme = folder.theme;
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public CardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = CardItemBinding.inflate(inflater, parent, false);
        View view = binding.getRoot();
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildLayoutPosition(v);
                MainActivity.getInstance()
                        .replaceFragment(new SingleCardFragment(folder.cards.get(position), theme));
            }
        });

        binding.deleteCardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildLayoutPosition(view);
                folder.cards.remove(position);
                notifyItemRemoved(position);
                MainActivity.getInstance().getViewModel().update(folder);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        Card card = folder.cards.get(position);
        holder.rusWordView.setText(card.rus_word);
        holder.engWordView.setText(card.eng_word);
    }

    @Override
    public int getItemCount() {
        return folder.cards.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        final TextView rusWordView, engWordView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.rusWordView = (TextView) itemView.findViewById(R.id.rusWord);
            this.engWordView = (TextView) itemView.findViewById(R.id.engWord);
        }
    }
}