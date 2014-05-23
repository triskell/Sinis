package net.trysk.sinis.sinis.card;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by trysk on 24/05/14.
 */
public class DeckParser {

    private Gson mGson = new Gson();

    private ArrayList<Deck> meck;

    public ArrayList getMeck() {
        return meck;
    }



    public DeckParser(String s) {

        Type listType = new TypeToken<ArrayList<Deck>>() {
        }.getType();

        this.meck = this.mGson.fromJson(s,listType);
    }
}
