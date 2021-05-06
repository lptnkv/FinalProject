package com.example.finalproject.Models;

import java.util.ArrayList;

public abstract class ITask {
    public String text;
    public ArrayList<String> options;
    public String answer;
    public Difficulty difficulty;
    public Type type;

    public ITask(ArrayList<String> options, String answer, Difficulty difficulty,
                 String text, Type type) {
        this.options = options;
        this.answer = answer;
        this.difficulty = difficulty;
        this.text = text;
        this.type = type;
    }

    boolean validateTask(String answer){
        return this.answer.equals(answer);
    }


}
