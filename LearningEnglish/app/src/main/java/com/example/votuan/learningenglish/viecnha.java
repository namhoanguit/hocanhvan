package com.example.votuan.learningenglish;
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class viecnha extends Activity{
    private TextToSpeech tts;
    GridView gridView;
    static final String[] list = new String[] { "clean the window", "do the cooking",
            "do the laundry", "dust the furniture", "feed the dog"
            , "fold the laundry", "hang up the laundry", "iron the clothes", "mop the floor" ,
            "mown the lawn","paint the fence","rake the leaves","sweep the floor",
            "take out the rubbish","tidy up the room","vacuum the floor","wash the car","wash the dishes","water the plants"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hoaqua);

        tts = new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if (status != TextToSpeech.ERROR) {
                            tts.setLanguage(Locale.UK);
                        }
                    }
                });
        gridView = (GridView) findViewById(R.id.gridView1);

        gridView.setAdapter(new viecnhaAdapter(this, list));

        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                tts.speak(list[position], TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    @Override
    public void onPause() {
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }
}
