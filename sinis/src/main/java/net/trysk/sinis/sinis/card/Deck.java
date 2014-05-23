package net.trysk.sinis.sinis.card;

import android.content.Context;
import android.widget.ImageView;

import com.google.android.glass.app.Card;

import net.trysk.sinis.sinis.R;

import java.util.ArrayList;

/**
 * Created by trysk on 23/05/14.
 */
public class Deck {

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
}
