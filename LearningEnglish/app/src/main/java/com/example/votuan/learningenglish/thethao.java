package com.example.votuan.learningenglish;

/**
 * Created by VoTuan on 12/23/2016.
 */
import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
public class thethao extends Activity {
    private TextToSpeech tts;
    GridView gridView;
    static final String[] list = new String[] { "Badminton", "Baseball",
            "Basketball", "Boxing", "Climbing"
            , "Cycling", "Fencing", "Fishing", "Golf" ,"Ice-skating","Karate","Motor-racing","Skiing",
            "Soccer","Surfing","Swimming","Tennis","Yoga"};

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

        gridView.setAdapter(new thethaoAdapter(this, list));

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
