package com.example.votuan.learningenglish;

/**
 * Created by HOANGNAM-PC on 12/23/2016.
 */


import android.app.Activity;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import java.util.Locale;


public class cothe  extends Activity{
    private TextToSpeech tts;
    GridView gridView;
    static final String[] list = new String[] {"Arm","Calf","Chin", "Cheeks", "Ear","Elbow",
            "Eye","Eyebrow","Eyelashes","Finger","Fist","Foot","Forehead","Gums","Hair","Hand","Head",
            "Heel","Index Finger","Iris"};

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

        gridView.setAdapter(new cotheAdapter(this, list));

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
