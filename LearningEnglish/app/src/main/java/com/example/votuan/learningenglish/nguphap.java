package com.example.votuan.learningenglish;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;

public class nguphap extends Activity implements OnClickListener {
    TextView tv_tieude, tv_noidung;
    String til[] = { "Mạo từ", "Tính từ",
            "Giới từ", "Liên từ",
             " Mệnh đề", "So sánh ngang/ bằng nhau",
            "Hiện tại đơn", "Quá khứ đơn","Tương lai đơn"};
    String noidung[] = { "maotu.txt", "tinhtu.txt", "gioitu.txt",
            "lientu.txt",  "menhde.txt", "sosanh.txt",
            "htd.txt","qkd.txt","tld.txt"};
    int i;
    StringBuilder builder, builder_tiengviet;
    ImageButton btn_next, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_nguphap);
        btn_back = (ImageButton) findViewById(R.id.btn_back);
        btn_back.setOnClickListener(this);
        btn_next = (ImageButton) findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
        tv_noidung = (TextView) findViewById(R.id.tv_noidung);

        Intent iin = getIntent();
        Bundle b = iin.getExtras();
        if (b != null) {
            int j = b.getInt("trang");
            String a = b.getString("title");
            setTitle(a);
            i = j;

            readtruyen(noidung[i]);

        } else {
            i = 1;

            readtruyen(noidung[0]);
        }
    }

    public void readtruyen(String file) {
        String data;
        //InputStream in = getResources().openRawResource(file);
        //InputStreamReader inreader = new InputStreamReader(in);
        //BufferedReader bufreader = new BufferedReader(inreader);
        builder_tiengviet = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(file), "UTF-8"));
            while ((data = reader.readLine()) != null) {

                builder_tiengviet.append(data);
                builder_tiengviet.append("\n");

            }

            tv_noidung.setText(builder_tiengviet.toString());

        } catch (IOException ex) {
            Log.e("ERROR", ex.getMessage());
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                if (i < 8) {
                    i++;
                    setTitle(til[i]);
                    readtruyen(noidung[i]);
                }
                break;
            case R.id.btn_back:
                if (i > 0) {
                    i--;
                    setTitle(til[i]);
                    readtruyen(noidung[i]);
                }
        }

    }
}
