package com.example.finalproject.Models;

import java.util.ArrayList;

public abstract class ITask {
    public String text;
    public ArrayList<String> options;
    public String answer;
    public Type type;

    public ITask(ArrayList<String> options, String answer,
                 String text) {
        this.options = options;
        this.answer = answer;
        this.text = text;
    }

    public boolean validateTask(String answer){
        return this.answer.equals(answer);
    }
}
