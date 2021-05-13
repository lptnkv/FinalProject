package com.example.finalproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Entities.Card;
import com.example.finalproject.Entities.Folder;
import com.example.finalproject.Fragments.SingleCardFragment;
import com.example.finalproject.MainActivity;
import com.example.finalproject.R;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Card> cards;
    private String theme;
    RecyclerView recyclerView;

    public CardAdapter(Context context, Folder folder) {
        this.inflater = LayoutInflater.from(context);
        this.cards = folder.cards;
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
        View view = inflater.inflate(R.layout.card_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = recyclerView.getChildLayoutPosition(v);
                MainActivity.getInstance()
                        .replaceFragment(new SingleCardFragment(cards.get(position), theme));
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CardAdapter.ViewHolder holder, int position) {
        Card card = cards.get(position);
        holder.rusWordView.setText(card.rus_word);
        holder.engWordView.setText(card.eng_word);
    }

    @Override
    public int getItemCount() {
        return cards.size();
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