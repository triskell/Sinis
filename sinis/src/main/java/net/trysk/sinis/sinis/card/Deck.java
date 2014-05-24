package net.trysk.sinis.sinis.card;

import com.google.android.glass.app.Card;

import java.util.ArrayList;

public class Deck{

    private ArrayList<Card> mCards = null;

    public Deck(){
        mCards = new ArrayList<Card>();
    }

    public void addCard(Card card){
        mCards.add(card);
    }

    public ArrayList<Card> getCards(){
        return mCards;
    }
}
