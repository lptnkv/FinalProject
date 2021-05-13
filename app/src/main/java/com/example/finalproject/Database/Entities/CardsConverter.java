package com.example.finalproject.Database.Entities;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class CardsConverter {
    @TypeConverter
    public String fromCards(ArrayList<Card> cards){
        Gson gson = new Gson();
        return gson.toJson(cards);
    }

    @TypeConverter
    public ArrayList<Card> toCards(String json){
        Gson gson = new Gson();
        ArrayList<Card> result = gson.fromJson(json, new TypeToken<ArrayList<Card>>(){}.getType());
        return  result;
    }
}
