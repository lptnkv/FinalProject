package com.example.finalproject.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Folder {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String theme;
    @TypeConverters({CardsConverter.class})
    public ArrayList<Card> cards;
    public String creator;

    public Folder(String theme, ArrayList<Card> cards, String creator) {
        this.theme = theme;
        this.cards = cards;
        this.creator = creator;
    }

    public Folder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
}
