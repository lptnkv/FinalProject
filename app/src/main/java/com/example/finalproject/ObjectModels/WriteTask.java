package com.example.finalproject.ObjectModels;

import java.util.ArrayList;

public class WriteTask extends ITask {


    public WriteTask(ArrayList<String> options, String answer, String text) {
        super(options, answer, text);
        this.type = Type.Write;
    }
}
