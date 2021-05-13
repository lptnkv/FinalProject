package com.example.finalproject.Fabrics;


import com.example.finalproject.Entities.Card;
import com.example.finalproject.Entities.Folder;
import com.example.finalproject.Models.Difficulty;
import com.example.finalproject.Models.ITask;
import com.example.finalproject.Models.WriteTask;
import com.example.finalproject.Models.YesNoTask;
import com.example.finalproject.Models.Type;

public class WriteFabric implements IFabric {
    @Override
    public ITask generateTask(Folder folder, int ind) {
        Card card = folder.cards.get(ind);
        String answer = card.eng_word;
        String text = card.rus_word;
        return new WriteTask(null, answer, text);
    }
}
