package net.trysk.sinis.sinis.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;

import net.trysk.sinis.sinis.card.LinkedCard;

import java.util.ArrayList;

/**
 * Created by Thomas Abot on 23/05/14.
 */
public class CustomCardScrollAdapter extends CardScrollAdapter {

    private ArrayList<LinkedCard> mCards = null;

    public CustomCardScrollAdapter(ArrayList<LinkedCard> card){
        this.mCards = card;
    }

    @Override
    public int getCount() {
        if(mCards == null) return 0;
        return mCards.size();
    }

    @Override
    public Object getItem(int i) {
        if(mCards == null) return null;
        return mCards.get(i);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(mCards == null) return null;
        return mCards.get(i).getView();
    }

    @Override
    public int getPosition(Object o) {
        if(mCards == null) return 0;
        return mCards.indexOf(o);
    }
}
