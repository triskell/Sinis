package net.trysk.sinis.sinis;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollView;

import net.trysk.sinis.sinis.adapter.CustomCardScrollAdapter;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private ArrayList<Card> mCards;
    private CardScrollView mCardScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        createCards();

        mCardScrollView = new CardScrollView(this);
        CustomCardScrollAdapter adapter = new CustomCardScrollAdapter(mCards);
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);
    }

    private void createCards() {
        ArrayList<Card> cards = new ArrayList<Card>();
        Card card;

        card = new Card(this);
        card.setText("Test Card");
        card.setFootnote("Swipe to see next cards, if any.");
        mCards.add(card);

        mCards = cards;
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
