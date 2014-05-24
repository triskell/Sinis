package net.trysk.sinis.sinis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.google.android.glass.app.Card;
import com.google.android.glass.widget.CardScrollView;
import com.google.gson.Gson;

import net.trysk.sinis.sinis.adapter.CustomCardScrollAdapter;
import net.trysk.sinis.sinis.card.Deck;
import net.trysk.sinis.sinis.card.DeckParser;
import net.trysk.sinis.sinis.card.DeckSingleton;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private ArrayList<Deck> mDecks;
    private CardScrollView mCardScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);


        mDecks=DeckSingleton.getInstance(this).getCurrentDeck();
        ArrayList<Card> cards = new ArrayList<Card>();
        for (Deck mDeck : this.mDecks) {
            System.out.println("YOLO "+mDeck.toString());
            cards.add(mDeck.getCard(this));
        }

        //createDecks();

        mCardScrollView = new CardScrollView(this);
        CustomCardScrollAdapter adapter = new CustomCardScrollAdapter(cards);
        mCardScrollView.setAdapter(adapter);
        mCardScrollView.activate();
        setContentView(mCardScrollView);

        mCardScrollView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (mDecks.get(i).getType() == 1) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent, 0);
                } else if (mDecks.get(i).getType() == 2) {

                } else {
                    DeckSingleton.getInstance(view.getContext()).addIndex(i);
                    startActivity(new Intent(view.getContext(), ListActivity.class));
                }
            }
        });
    }

    /*private void createDecks() {
        mDecks = new ArrayList<Deck>();
        Deck deck;

        createDecks();

        deck = new Deck("Test Deck, main text","footnote here","", (short) 0,true);
        mDecks.add(deck);
    }*/


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
