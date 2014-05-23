package net.trysk.sinis.sinis.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollAdapter;

import java.util.ArrayList;

/**
 * Created by trysk on 23/05/14.
 */
public class CustomCardScrollAdapter extends CardScrollAdapter {

    private ArrayList<Card> mCards = null;

    public CustomCardScrollAdapter(cards){

    }

    @Override
    public int getCount() {
        if(mCards == null) return 0;
        return mCards.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public int getPosition(Object o) {
        return 0;
    }
}
