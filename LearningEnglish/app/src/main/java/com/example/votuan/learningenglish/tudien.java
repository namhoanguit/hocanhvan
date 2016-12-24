package com.example.votuan.learningenglish;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class tudien extends Activity {
    private DataBaseHelper myDbHelper;
    private String TAG = "mysqllite";
    Button tracuu;
    AutoCompleteTextView edt_tu;
    String tukhoa;
    WebView webView;
    ArrayAdapter<String> adapter = null;
    ArrayList<String> arr = null;
    Button btnghe;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tudien);
        myDbHelper = new DataBaseHelper(this);
        webView = (WebView) findViewById(R.id.wvhienthi);
        tts=new TextToSpeech(getApplication(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    tts.setLanguage(Locale.UK);
                }
            }
        });
        arr = new ArrayList<>();
        // mo csdl
        try {
            myDbHelper.checkAndCopyDatabase();
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            Log.d(TAG, "database error!");
        }
        btnghe= (Button) findViewById(R.id.btnNghe);
        btnghe.setVisibility(View.INVISIBLE);
        edt_tu = (AutoCompleteTextView) findViewById(R.id.formtracuu);
        edt_tu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btnghe.setVisibility(View.INVISIBLE);
                arr = myDbHelper.getAll(charSequence.toString());
                adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.layout_item, R.id.tv_auto, arr);
                adapter.notifyDataSetChanged();
                edt_tu.setAdapter(adapter);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        tracuu = (Button) findViewById(R.id.buttontracuu);
        tracuu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tukhoa = edt_tu.getText().toString();
                tratu(tukhoa);
                btnghe.setVisibility(View.VISIBLE);
                btnghe.setEnabled(true);
            }
        });
        btnghe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tts.speak(edt_tu.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }

    public void tratu(String id) {
        int i = 0;
        myDbHelper = new DataBaseHelper(this);
        // mo csdl
        try {
            myDbHelper.checkAndCopyDatabase();
            myDbHelper.openDataBase();
        } catch (SQLException sqle) {
            Toast.makeText(getApplicationContext(), sqle + "", Toast.LENGTH_LONG).show();
        }
        try {
            Cursor c = myDbHelper.QueryData("select content from anh_viet where word='" + id + "'");
            if (c != null) {
                if (c.moveToFirst()) {
                    webView.loadDataWithBaseURL(null, c.getString(0) + "", "text/html", "utf-8", null);
                    i++;
                }

            }
        } catch (SQLException e) {
            Log.d(TAG, "Query error!");
        }

        if (i == 0) {
            Toast.makeText(getApplicationContext(), "Không có từ cần tra !",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
