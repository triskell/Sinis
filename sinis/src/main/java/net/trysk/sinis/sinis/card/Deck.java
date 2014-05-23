package net.trysk.sinis.sinis.card;

import android.content.Context;

import com.google.android.glass.app.Card;


import java.io.Serializable;
import java.util.ArrayList;

public class Deck{

    private ArrayList<Deck> mDecks = null;

    Context mContext;
    boolean mIsFullScreen;
    short mCardType; //0:normal, 1:photo, 2:video
    String mText, mFootnote, mImageR;

    public Deck(Context context, String text, String footnote, String imageR, short cardType, boolean isFullScreen) {
        this.mContext = context;
        this.mText = text;
        this.mFootnote = footnote;
        this.mImageR = imageR;
        this.mCardType = cardType;
        this.mIsFullScreen = isFullScreen;
    }

    public Card getCard(){
        Card card = new Card(this.mContext);

        switch (this.mCardType){
            case 1:
                //TODO photo
                break;
            case 2:
                //TODO video
                break;
            default:
                if(this.mText!=null) card.setText(mText);
                if(this.mFootnote!=null) card.setFootnote(mFootnote);

                if(this.mImageR!=null){
                    if(this.mIsFullScreen) card.setImageLayout(Card.ImageLayout.FULL);
                    else card.setImageLayout(Card.ImageLayout.LEFT);

                    int identifier = mContext.getResources().getIdentifier(mImageR, "drawable","net.trysk.sinis.sinis");
                    card.addImage(identifier);
                }


        }
        card.setText("Test Card");
        card.setFootnote("Swipe to see next cards, if any.");

        return card;
    }

    public ArrayList<Deck> getmDecks() {
        return mDecks;
    }

    public int getType(){
        return mCardType;
    }
}
