package net.trysk.sinis.sinis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollView;

import net.trysk.sinis.sinis.adapter.CustomCardScrollAdapter;
import net.trysk.sinis.sinis.card.Deck;
import net.trysk.sinis.sinis.card.DeckPile;
import net.trysk.sinis.sinis.card.LinkedCard;


public class MainActivity extends Activity {

    private CardScrollView mCardScrollView;
    private int mId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createDecks();

        mCardScrollView = new CardScrollView(this);

        mId = getIntent().getIntExtra("id", 0);
        CustomCardScrollAdapter adapter = new CustomCardScrollAdapter(DeckPile.getInstance().getDeck(mId).getCards());
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);

        mCardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                tappedCard(DeckPile.getInstance().getDeck(mId).getCards().get(i).getNextDeck());
            }
        });

        /*intentList.putExtra("Deck", mDecks);
        startActivity(intentList);*/
    }

    private void tappedCard(int nextDeck) {
        Intent intentDeck = new Intent(this, MainActivity.class);
        intentDeck.putExtra("id", nextDeck);
        startActivity(intentDeck);
    }

    private void createDecks() {
        Deck deck;
        LinkedCard card;

        deck = new Deck();
            card = new LinkedCard(this);
            card.setText("Go to deck 1");
            card.setNextDeck(1);
            deck.addCard(card);

            card = new LinkedCard(this);
            card.setText("Go to deck 2");
            deck.addCard(card);
            card.setNextDeck(2);
        DeckPile.getInstance().adddeck(0, deck);

        deck = new Deck();
            card = new LinkedCard(this);
            card.setText("Test card 1-1");
            card.setNextDeck(0);
            deck.addCard(card);

            card = new LinkedCard(this);
            card.setText("Test card 1-2");
            deck.addCard(card);
            card.setNextDeck(0);
        DeckPile.getInstance().adddeck(1, deck);

        deck = new Deck();
            card = new LinkedCard(this);
            card.setText("Test card 2-1");
            card.setNextDeck(0);
        deck.addCard(card);

            card = new LinkedCard(this);
            card.setText("Test card 2-2");
            card.setNextDeck(0);
        deck.addCard(card);
        DeckPile.getInstance().adddeck(2, deck);

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
