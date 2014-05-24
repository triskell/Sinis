package net.trysk.sinis.sinis.card;

import android.util.ArrayMap;

/**
 * Created by trysk on 24/05/14.
 */
public class DeckPile {

    private ArrayMap<Integer,Deck> mDecks;

    private DeckPile()
    {
        mDecks = new ArrayMap<Integer, Deck>();
    }

    private static DeckPile INSTANCE = null;

    public static synchronized DeckPile getInstance()
    {
        if (INSTANCE == null)
        { INSTANCE = new DeckPile();
        }
        return INSTANCE;
    }

    public static void adddeck(int id, Deck deck){
        INSTANCE.mDecks.put(id, deck);
    }

    public static Deck getDeck(int id){
        return INSTANCE.mDecks.get(id);
    }


}
