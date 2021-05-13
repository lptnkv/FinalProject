package com.example.finalproject.ObjectModels;

import java.util.ArrayList;

public class ChooseTask extends ITask {

    public ChooseTask(ArrayList<String> options, String answer, String text) {
        super(options, answer, text);
        this.type = Type.Choose;
    }
}
