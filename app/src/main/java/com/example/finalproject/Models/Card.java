package com.example.finalproject.Models;

import androidx.room.Entity;
import androidx.room.ForeignKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(foreignKeys = @ForeignKey(entity = Folder.class,
        parentColumns = "theme", childColumns = "theme", onDelete = CASCADE))
public class Card {
    public String russianWord;
    public String englishWord;
    public String theme;

    public Card(String russianWord, String englishWord, String theme) {
        this.russianWord = russianWord;
        this.englishWord = englishWord;
        this.theme = theme;
    }
}
