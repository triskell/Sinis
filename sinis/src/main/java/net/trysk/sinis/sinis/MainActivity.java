package net.trysk.sinis.sinis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollView;

import net.trysk.sinis.sinis.adapter.CustomCardScrollAdapter;
import net.trysk.sinis.sinis.card.Deck;
import net.trysk.sinis.sinis.card.DeckParser;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private ArrayList<Deck> mDecks;
    private CardScrollView mCardScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        DeckParser unicorn = new DeckParser(getResources().getString(R.string.This_is_where_the_magic_happen));

        this.mDecks = unicorn.getMeck();
        System.out.println("YOLO "+mDecks.toString());
        super.onCreate(savedInstanceState);

        ArrayList<Card> cards = new ArrayList<Card>();
        for (Deck mDeck : mDecks) {
            cards.add(mDeck.getCard());
        }

        createDecks();

        mCardScrollView = new CardScrollView(this);
        CustomCardScrollAdapter adapter = new CustomCardScrollAdapter(cards);
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);

        Intent intentList = new Intent(this, ListActivity.class);
        intentList.putExtra("Deck", mDecks);
        startActivity(intentList);
    }

    private void createDecks() {
        mDecks = new ArrayList<Deck>();
        Deck deck;

        createDecks();

        deck = new Deck(this.getBaseContext(), "Test Deck, main text","footnote here","", (short) 0,true);
        mDecks.add(deck);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
