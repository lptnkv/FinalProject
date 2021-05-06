package com.example.finalproject.Fabrics;

import com.example.finalproject.Models.Difficulty;
import com.example.finalproject.Models.ITask;
import com.example.finalproject.Models.PairTask;
import com.example.finalproject.Models.Type;

import java.util.ArrayList;

public class ChooseFabric implements IFabric {
    @Override
    public ITask generateTask() {
        ArrayList<String> options = new ArrayList<>();
        options.add("4");
        options.add("5");
        options.add("6");
        String answer = "2";
        Difficulty difficulty = Difficulty.Medium;
        String text = "Some random text...";
        Type type = Type.Choose;
        return new PairTask(options, answer, difficulty, text, type);
    }
}
