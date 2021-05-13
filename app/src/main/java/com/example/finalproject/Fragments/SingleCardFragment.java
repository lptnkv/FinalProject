package com.example.finalproject.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.finalproject.Database.Entities.Card;
import com.example.finalproject.databinding.SingleCardFragmentBinding;

public class SingleCardFragment extends Fragment{
    private SingleCardFragmentBinding binding;
    Card card;
    String theme;

    public SingleCardFragment(Card card, String theme) {
        this.card = card;
        this.theme = theme;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = SingleCardFragmentBinding.inflate(inflater, container, false);
        binding.themeView.setText(this.theme);
        binding.wordView.setText(this.card.rus_word);
        View view = binding.getRoot();
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.wordView.getText().equals(card.rus_word)){
                    binding.wordView.setText(card.eng_word);
                } else {
                    binding.wordView.setText(card.rus_word);
                }
            }
        });
        return view;
    }

}
