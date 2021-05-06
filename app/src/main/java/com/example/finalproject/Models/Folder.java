package com.example.finalproject.Models;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class Folder {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String theme;

    @Ignore
    public ArrayList<Card> cards;

    public String creator;

    public Folder(String theme, ArrayList<Card> cards, String creator) {
        this.theme = theme;
        this.cards = cards;
        this.creator = creator;
    }
}
