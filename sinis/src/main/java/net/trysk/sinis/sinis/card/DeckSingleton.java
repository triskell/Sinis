package net.trysk.sinis.sinis.card;

import java.util.ArrayList;

/**
 * Created by boris on 24/05/14.
 */
public class DeckSingleton {
    private static ArrayList<Integer> indexes;
    private Deck globalDeck;
    private static DeckSingleton deckUnicorn=null;

    private DeckSingleton(Deck d){
        this.globalDeck=d;
    }

    public DeckSingleton getInstance(Deck d){
        if(deckUnicorn==null){
            deckUnicorn=new DeckSingleton(d);
            indexes=new ArrayList<Integer>();
        }
        return this;
    }

    public void addIndex(int i){
        indexes.add(i);
    }

    public void removeIndex(){
        if(indexes.size()>0){
            indexes.remove(indexes.size()-1);
        }
    }

    public Deck getCurrentDeck(){
        Deck currentDeck=globalDeck;
        int i=0;
        while(i<indexes.size()){
            currentDeck=currentDeck.getmDecks().get(indexes.get(i));
            i++;
        }
        return currentDeck;
    }
}
