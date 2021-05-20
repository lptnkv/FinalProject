package com.example.finalproject.Network;

import androidx.room.TypeConverters;

import com.example.finalproject.Database.Entities.Card;
import com.example.finalproject.Database.Entities.CardsConverter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FolderResponse {
    @SerializedName("theme")
    @Expose
    public String theme;
    @SerializedName("cards")
    @Expose
    public ArrayList<Card> cards;
    @SerializedName("creator")
    @Expose
    public String creator;
}
