package com.example.finalproject.ObjectModels.Fabrics;


import com.example.finalproject.Database.Entities.Card;
import com.example.finalproject.Database.Entities.Folder;
import com.example.finalproject.ObjectModels.ITask;
import com.example.finalproject.ObjectModels.WriteTask;

public class WriteFabric implements IFabric {
    @Override
    public ITask generateTask(Folder folder, int ind) {
        Card card = folder.cards.get(ind);
        String answer = card.eng_word;
        String text = card.rus_word;
        return new WriteTask(null, answer, text);
    }
}
