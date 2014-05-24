package net.trysk.sinis.sinis.card;

import android.content.Context;
import android.widget.ImageView;

import com.google.android.glass.app.Card;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.trysk.sinis.sinis.R;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Deck{

    private ArrayList<Deck> mDecks = null;

    private Gson mGson = new Gson();
    boolean mIsFullScreen;
    short mCardType; //0:normal, 1:photo, 2:video
    String mText, mFootnote, mImageR;

    public Deck(String text, String footnote, String imageR, short cardType, boolean isFullScreen, ArrayList<Deck> d) {
        this.mText = text;
        this.mFootnote = footnote;
        this.mImageR = imageR;
        this.mCardType = cardType;
        this.mIsFullScreen = isFullScreen;
        this.mDecks=d;
    }

    public Card getCard(Context mContext){
        Card card = new Card(mContext);

        if(this.mText.length()>0) card.setText(mText);
        if(this.mFootnote.length()>0
                ) card.setFootnote(mFootnote);

        if(this.mImageR.length()>0) {
            if (this.mIsFullScreen) card.setImageLayout(Card.ImageLayout.FULL);
            else card.setImageLayout(Card.ImageLayout.LEFT);

            int identifier = mContext.getResources().getIdentifier(mImageR, "drawable", "net.trysk.sinis.sinis");
            card.addImage(identifier);
        }
        card.setText(mText);
        card.setFootnote(mFootnote);

        return card;
    }

    public ArrayList<Deck> getmDecks(){
        return mDecks;
    }

    public int getType(){
        return mCardType;
    }
}
