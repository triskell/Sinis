package net.trysk.sinis.sinis.card;

import android.content.Context;

import net.trysk.sinis.sinis.R;

import java.util.ArrayList;

/**
 * Created by boris on 24/05/14.
 */
public class DeckSingleton {
    private static ArrayList<Integer> indexes;
    private ArrayList<Deck> globalDeck;
    private static DeckSingleton deckUnicorn=null;

    private DeckSingleton(Context c){
        indexes=new ArrayList<Integer>();
        DeckParser unicorn = new DeckParser(c.getResources().getString(R.string.This_is_where_the_magic_happen));

        this.globalDeck = unicorn.getMeck();
    }

    public static DeckSingleton getInstance(Context c){
        if(deckUnicorn==null){
            deckUnicorn=new DeckSingleton(c);

        }
        return deckUnicorn;
    }

    public void addIndex(int i){
        indexes.add(i);
    }

    public void removeIndex(){
        if(indexes.size()>0){
            indexes.remove(indexes.size()-1);
        }
    }

    public ArrayList<Deck> getCurrentDeck(){
        ArrayList<Deck> currentDeck=globalDeck;
        int i=0;
        while(i<indexes.size()){
            currentDeck=currentDeck.get(indexes.get(i)).getmDecks();
            i++;
        }
        return currentDeck;
    }
}
