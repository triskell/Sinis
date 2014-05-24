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
import net.trysk.sinis.sinis.card.DeckPile;


public class MainActivity extends Activity {

    private CardScrollView mCardScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createDecks();

        mCardScrollView = new CardScrollView(this);

        int id = getIntent().getIntExtra("id", 0);
        CustomCardScrollAdapter adapter = new CustomCardScrollAdapter(DeckPile.getInstance().getDeck(id).getCards());
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);

        Intent intentDeck = new Intent(this, MainActivity.class);



        /*intentList.putExtra("Deck", mDecks);
        startActivity(intentList);*/
    }

    private void createDecks() {
        Deck deck;
        Card card;

        deck = new Deck();
            card = new Card(this);
            card.setText("Test card 1-1");
            deck.addCard(card);

            card = new Card(this);
            card.setText("Test card 1-2");
            deck.addCard(card);
        DeckPile.getInstance().adddeck(0, deck);

        deck = new Deck();
            card = new Card(this);
            card.setText("Test card 2-1");
            deck.addCard(card);

            card = new Card(this);
            card.setText("Test card 2-2");
            deck.addCard(card);
        DeckPile.getInstance().adddeck(1, deck);

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
