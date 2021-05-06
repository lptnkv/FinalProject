package com.example.finalproject.Fabrics;

import com.example.finalproject.Models.Difficulty;
import com.example.finalproject.Models.ITask;
import com.example.finalproject.Models.PairTask;
import com.example.finalproject.Models.Type;

import java.util.ArrayList;

public class PairFabric implements IFabric {
    @Override
    public ITask generateTask() {
        ArrayList<String> options = new ArrayList<>();
        options.add("1");
        options.add("2");
        options.add("3");
        String answer = "2";
        Difficulty difficulty = Difficulty.Medium;
        String text = "Some random text...";
        Type type = Type.Pair;
        return new PairTask(options, answer, difficulty, text, type);
    }
}
