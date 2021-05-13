package com.example.finalproject.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Card {
    @PrimaryKey
    public int id;
    public String rus_word;
    public String eng_word;

    public Card() {
    }

    public Card(String rus_word, String eng_word) {
        this.rus_word = rus_word;
        this.eng_word = eng_word;
    }


    public String getRus_word() {
        return rus_word;
    }

    public void setRus_word(String rus_word) {
        this.rus_word = rus_word;
    }

    public String getEng_word() {
        return eng_word;
    }

    public void setEng_word(String eng_word) {
        this.eng_word = eng_word;
    }
}
