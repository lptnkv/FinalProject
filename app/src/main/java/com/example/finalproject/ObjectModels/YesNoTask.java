package com.example.finalproject.ObjectModels;


import java.util.ArrayList;

public class YesNoTask extends ITask {

    public YesNoTask(ArrayList<String> options, String answer, String text) {
        super(options, answer, text);
        this.type = Type.YesNo;
    }
}
