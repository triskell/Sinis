package net.trysk.sinis.sinis.card;

import android.content.Context;

import com.google.android.glass.app.Card;

/**
 * Created by trysk on 24/05/14.
 */
public class LinkedCard extends Card {

    private int mNextid;

    public LinkedCard(Context context) {
        super(context);
        this.mNextid = 0;
    }

    public void setNextDeck(int id){
        mNextid = id;
    }

    public int getNextDeck(){
        return mNextid;
    }
}
