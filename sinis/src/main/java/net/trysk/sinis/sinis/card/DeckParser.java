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

    public Deck getMeck() {
        return meck;
    }

    private Deck meck;

    public DeckParser(String s) {

        Type listType = new TypeToken<ArrayList<Deck>>() {
        }.getType();

        this.mGson.fromJson(s,Deck.class);
    }
}
