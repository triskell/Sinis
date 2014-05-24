package net.trysk.sinis.sinis;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.FileObserver;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.glass.app.Card;
import com.google.android.glass.media.CameraManager;
import com.google.android.glass.widget.CardScrollView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.trysk.sinis.sinis.adapter.CustomCardScrollAdapter;
import net.trysk.sinis.sinis.card.Deck;
import net.trysk.sinis.sinis.card.DeckSingleton;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class ListActivity extends Activity {

    private ArrayList<Card> mCards;
    private CardScrollView mCardScrollView;
    private ArrayList<Deck> mDecks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        mDecks= DeckSingleton.getInstance(this).getCurrentDeck();


        mCards = new ArrayList<Card>();
        for (Deck mDeck : mDecks) {
            mCards.add(mDeck.getCard(this));
        }
        mCardScrollView = new CardScrollView(this);
        CustomCardScrollAdapter adapter = new CustomCardScrollAdapter(mCards);
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
                }
                else {
                    if(DeckSingleton.getInstance(view.getContext()).getCurrentDeck().get(i).getmDecks().size()>0) {
                        System.out.println("YOLO1 " + DeckSingleton.indexes.toString());
                        DeckSingleton.getInstance(view.getContext()).addIndex(i);
                        System.out.println("YOLO2 " + DeckSingleton.indexes.toString());
                        startActivity(new Intent(view.getContext(), ListActivity.class));
                    }
                    else{
                        Toast.makeText(view.getContext(), "Application test, chemin innaccessible", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    @Override
    public void onBackPressed(){

        super.onBackPressed();
        DeckSingleton.getInstance(this).removeIndex();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.list, menu);
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
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            String picturePath = data.getStringExtra(
                    CameraManager.EXTRA_PICTURE_FILE_PATH);
            processPictureWhenReady(picturePath);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void processPictureWhenReady(final String picturePath) {
        final File pictureFile = new File(picturePath);

        if (pictureFile.exists()) {
            // The picture is ready; process it.
        } else {
            // The file does not exist yet. Before starting the file observer, you
            // can update your UI to let the user know that the application is
            // waiting for the picture (for example, by displaying the thumbnail
            // image and a progress indicator).

            final File parentDirectory = pictureFile.getParentFile();
            FileObserver observer = new FileObserver(parentDirectory.getPath(),
                    FileObserver.CLOSE_WRITE | FileObserver.MOVED_TO) {
                // Protect against additional pending events after CLOSE_WRITE
                // or MOVED_TO is handled.
                private boolean isFileWritten;

                @Override
                public void onEvent(int event, String path) {
                    if (!isFileWritten) {
                        // For safety, make sure that the file that was created in
                        // the directory is actually the one that we're expecting.
                        File affectedFile = new File(parentDirectory, path);
                        isFileWritten = affectedFile.equals(pictureFile);

                        if (isFileWritten) {
                            stopWatching();

                            // Now that the file is ready, recursively call
                            // processPictureWhenReady again (on the UI thread).
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    processPictureWhenReady(picturePath);
                                }
                            });
                        }
                    }
                }
            };
            observer.startWatching();
        }
    }
}
