package com.example.finalproject.Fabrics;


import com.example.finalproject.Models.Difficulty;
import com.example.finalproject.Models.ITask;
import com.example.finalproject.Models.PairTask;
import com.example.finalproject.Models.Type;

public class WriteFabric implements IFabric {
    @Override
    public ITask generateTask() {
        String answer = "2";
        Difficulty difficulty = Difficulty.Medium;
        String text = "Some random text...";
        Type type = Type.Write;
        return new PairTask(null, answer, difficulty, text, type);
    }
}
