package com.example.votuan.learningenglish;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {

    Button but2, but4, but5,but6;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but2 = (Button) findViewById(R.id.bthocnghe);
        but2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, listnghe.class);
                startActivity(intent);
            }
        });

        but4 = (Button) findViewById(R.id.btbatdau);
        but4.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, phatam.class);
                startActivity(intent);
            }
        });
        but5 = (Button) findViewById(R.id.bttudien);
        but5.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, tudien.class);
                startActivity(intent);
            }
        });
        but6 = (Button) findViewById(R.id.btnguphap);
        but6.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(MainActivity.this, listnguphap.class);
                startActivity(intent);
            }
        });
    }
}
