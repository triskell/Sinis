package net.trysk.sinis.sinis.card;

import com.google.android.glass.app.Card;

import java.util.ArrayList;

public class Deck{

    private ArrayList<LinkedCard> mCards = null;

    public Deck(){
        mCards = new ArrayList<LinkedCard>();
    }

    public void addCard(LinkedCard card){
        mCards.add(card);
    }

    public ArrayList<LinkedCard> getCards(){
        return mCards;
    }

}
