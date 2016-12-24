package com.example.votuan.learningenglish;

import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import java.util.Locale;

public class dongvat extends Activity{
    private TextToSpeech tts;
    GridView gridView;
    static final String[] list = new String[] { "Dolphin", "Butterfly",
            "Elephant", "Panda", "Hippopotamus", "Cat", "Turtle",
            "Rabbit", "Dog", "Bee", "Tiger" , "Lion","Duck", "Chicken"};

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

        gridView.setAdapter(new dongvat1(this, list));

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
