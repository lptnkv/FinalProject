package com.example.finalproject.Fabrics;

import com.example.finalproject.Entities.Card;
import com.example.finalproject.Entities.Folder;
import com.example.finalproject.Models.Difficulty;
import com.example.finalproject.Models.ITask;
import com.example.finalproject.Models.YesNoTask;
import com.example.finalproject.Models.Type;

import java.util.ArrayList;
import java.util.Random;

public class YesNoFabric implements IFabric {
    @Override
    public ITask generateTask(Folder folder, int ind) {
        Random random = new Random();
        ArrayList<String> options = new ArrayList<>();
        options.add("Да");
        options.add("Нет");
        String text;
        String answer;
        Card card = folder.cards.get(ind);
        if (random.nextBoolean()){
            text = card.rus_word + " - " + card.eng_word;
            answer = "Да";
        } else {
            int rand_int = random.nextInt();
            while (rand_int == ind){
                rand_int = random.nextInt();
            }
            text = card.rus_word + " - " + folder.cards.get(rand_int).eng_word;
            answer = "Нет";
        }
        return new YesNoTask(options, answer, text);
    }
}
