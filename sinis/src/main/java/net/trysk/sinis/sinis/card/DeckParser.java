package net.trysk.sinis.sinis.card;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by trysk on 24/05/14.
 */
public class DeckParser {

    private Gson mGson = new Gson();



    private ArrayList<Deck> meck;

    public ArrayList<Deck> getMeck() {
        return meck;
    }



    public DeckParser(String s) {

        /*Type listType = new TypeToken<ArrayList<Deck>>() {
        }.getType();

        System.out.println("Yolo unicorn");

        this.meck = this.mGson.fromJson(s,Deck[].class);

        System.out.println("YOLO2 " + this.meck.toString());*/

        JSONArray array = null;
        try {
            array = new JSONArray(s);
            meck=new ArrayList<Deck>();
            for(int i=0;i<array.length();i++){
                meck.add(getDeck(array.getJSONObject(i)));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }



    }

    private Deck getDeck(JSONObject obj){
        boolean mIsFullScreen;
        short mCardType; //0:normal, 1:photo, 2:video
        String mText, mFootnote, mImageR;
        ArrayList<Deck> mDecks = new ArrayList<Deck>();

        try {
            mIsFullScreen=(obj.get("mIsFullScreen").toString())=="true"?true:false;
            mCardType=Short.parseShort(obj.get("mCardType").toString());
            mText=obj.get("mText").toString();
            mFootnote=obj.get("mFootnote").toString();
            mImageR=obj.get("mImageR").toString();

            JSONArray array=new JSONArray(obj.get("mDesks").toString());

            for(int i=0;i<array.length();i++){
                mDecks.add(getDeck(array.getJSONObject(i)));
            }

            return new Deck(mText,mFootnote,mImageR,mCardType,mIsFullScreen, mDecks);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }
}
