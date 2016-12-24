package com.example.votuan.learningenglish;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class hocnghe2 extends Activity implements OnCompletionListener, SeekBar.OnSeekBarChangeListener {

    private Button btnPlay;
    private Button btnNext;
    private Button btnPrevious;
    private SeekBar songProgressBar;
    private MediaPlayer mp;
    private Handler mHandler = new Handler();
    private Utilities utils;
    private int currentSongIndex = 0;
    private boolean isShuffle = false;
    private boolean isRepeat = false;
    TextView tv_noidung;
    int mp3[] = {R.raw.baiabc, R.raw.ifyouarehappy, R.raw.areyousleeping,
            R.raw.baabaablacksheep, R.raw.cuckooclock,R.raw.dingdongbell,R.raw.dayoftheweek,R.raw.fivelittleducks};
    String noidungtext[] = {"baiabc.txt", "ifyouarehappy.txt",
            "areyousleeping.txt", "baabaablacksheep.txt",
            "cuckooclock.txt", "dingdongbell.txt","dayoftheweek.txt","fivelittleducks.txt"};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_hocnghe);
        btnPlay = (Button) findViewById(R.id.btn_play);
        btnNext = (Button) findViewById(R.id.btn_next);
        btnPrevious = (Button) findViewById(R.id.btn_back);

        songProgressBar = (SeekBar) findViewById(R.id.seekBar1);
        mp = new MediaPlayer();
        utils = new Utilities();
        songProgressBar.setOnSeekBarChangeListener(this);
        mp.setOnCompletionListener(this);
        tv_noidung = (TextView) findViewById(R.id.tv_noidung);
        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b != null) {
            int j = b.getInt("position");
            currentSongIndex = j;
            playSong(currentSongIndex);
            readData2(noidungtext[currentSongIndex]);
            btnPlay.setText("Tạm dừng");
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // check for already playing
                if (mp.isPlaying()) {
                    if (mp != null) {
                        mp.pause();
                        btnPlay.setText("Nghe");
                    }
                } else {
                    // Resume song
                    if (mp != null) {
                        mp.start();
                        btnPlay.setText("Tạm dừng");
                    }
                }

            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (currentSongIndex < (mp3.length - 1)) {
                    playSong(currentSongIndex + 1);
                    readData2(noidungtext[currentSongIndex + 1]);
                    currentSongIndex = currentSongIndex + 1;
                } else {
                    playSong(0);
                    readData2(noidungtext[0]);
                    currentSongIndex = 0;
                }

            }
        });
        btnPrevious.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (currentSongIndex > 0) {
                    playSong(currentSongIndex - 1);
                    readData2(noidungtext[currentSongIndex - 1]);
                    currentSongIndex = currentSongIndex - 1;
                } else {
                    playSong(mp3.length - 1);
                    readData2(noidungtext[mp3.length - 1]);
                    currentSongIndex = mp3.length - 1;
                }

            }
        });
    }

    public void playSong(int songIndex) {
        AssetFileDescriptor fileDesc = getResources().openRawResourceFd(mp3[songIndex]);
        try {
            mp.reset();
            mp.setDataSource(fileDesc.getFileDescriptor(), fileDesc.getStartOffset(), fileDesc.getLength());
            fileDesc.close();
            mp.prepare();
            mp.start();
            songProgressBar.setProgress(0);
            songProgressBar.setMax(100);
            updateProgressBar();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateProgressBar() {
        mHandler.postDelayed(mUpdateTimeTask, 100);
    }

    private Runnable mUpdateTimeTask = new Runnable() {
        public void run() {
            try {
                long totalDuration = mp.getDuration();
                long currentDuration = mp.getCurrentPosition();
                int progress = (int) (utils.getProgressPercentage(currentDuration, totalDuration));
                songProgressBar.setProgress(progress);
                mHandler.postDelayed(this, 100);
            } catch (Exception ignored) {
                finish();
            }
        }
    };

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromTouch) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        mHandler.removeCallbacks(mUpdateTimeTask);
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        mHandler.removeCallbacks(mUpdateTimeTask);
        int totalDuration = mp.getDuration();
        int currentPosition = utils.progressToTimer(seekBar.getProgress(), totalDuration);
        mp.seekTo(currentPosition);
        updateProgressBar();
    }

    @Override
    public void onCompletion(MediaPlayer arg0) {

        // check for repeat is ON or OFF
        if (isRepeat) {
            // repeat is on play same song again
            playSong(currentSongIndex);
        } else if (isShuffle) {
            // shuffle is on - play a random song
            Random rand = new Random();
            currentSongIndex = rand.nextInt((mp3.length - 1) + 1);
            playSong(currentSongIndex);
        } else {
            // no repeat or shuffle ON - play next song
            if (currentSongIndex < (mp3.length - 1)) {
                playSong(currentSongIndex + 1);
                currentSongIndex = currentSongIndex + 1;
            } else {
                // play first song
                playSong(0);
                currentSongIndex = 0;
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.release();
    }

    public void readData2(String file) {
        String data;
        //InputStream in = getAssets().open(file);
        //InputStreamReader inreader = new InputStreamReader(in);
        //BufferedReader bufreader = new BufferedReader(inreader);
        //StringBuilder builder = new StringBuilder();
        BufferedReader reader = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(file), "UTF-8"));
            while ((data = reader.readLine()) != null) {
                stringBuffer.append(data);
                stringBuffer.append("\n");

            }
            tv_noidung.setText(stringBuffer.toString());
            reader.close();
        } catch (IOException ex) {
            Log.e("ERROR", ex.getMessage());
        }

    }

    @Override
    public void onBackPressed() {
        if (mp.isPlaying()) {
            mp.stop();
        } else {
            mp.release();
        }

        super.onBackPressed();
    }

}