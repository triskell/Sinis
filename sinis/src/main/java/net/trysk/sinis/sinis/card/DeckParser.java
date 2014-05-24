package net.trysk.sinis.sinis.card;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by trysk on 24/05/14.
 */
public class DeckParser {

    private Gson mGson = new Gson();

    private Deck[] meck;

    public ArrayList getMeck() {
        return new ArrayList(Arrays.asList(meck));
    }



    public DeckParser(String s) {

        Type listType = new TypeToken<ArrayList<Deck>>() {
        }.getType();

        System.out.println("Yolo unicorn");

        this.meck = this.mGson.fromJson(s,Deck[].class);

        System.out.println("YOLO2 " + this.meck.toString());
    }
}
