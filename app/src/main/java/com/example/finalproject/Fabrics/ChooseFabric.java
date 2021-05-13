package com.example.finalproject.Fabrics;

import com.example.finalproject.Entities.Card;
import com.example.finalproject.Entities.Folder;
import com.example.finalproject.Models.ChooseTask;
import com.example.finalproject.Models.Difficulty;
import com.example.finalproject.Models.ITask;
import com.example.finalproject.Models.YesNoTask;
import com.example.finalproject.Models.Type;

import java.util.ArrayList;
import java.util.Collections;

public class ChooseFabric implements IFabric {
    @Override
    public ITask generateTask(Folder folder, int ind) {
        ArrayList<String> options = new ArrayList<>();
        Card card = folder.cards.get(ind);
        String text = card.rus_word;
        String answer = card.eng_word;
        options.add(answer);
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < folder.cards.size(); i++){
            indices.add(i);
        }
        Collections.shuffle(indices);
        for (int i = 0; i < 3; i++){
            options.add(folder.cards.get(i).eng_word);
        }
        Collections.shuffle(options);
        return new ChooseTask(options, answer, text);
    }
}
