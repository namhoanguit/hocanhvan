package com.example.votuan.learningenglish;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listnguphap extends Activity {
    String itemValue;
    ArrayList<String> tieudeanh;
    String chuoi[]={ "Mạo từ", "Tính từ",
            "Giới từ", "Liên từ",
             " Mệnh đề", "So sánh ngang/ bằng nhau", "Hiện tại đơn","Quá khứ đơn","Tương lai đơn",
            };

    Intent i1;
    custom_listview adt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_listnguphap);
        final ListView lv = (ListView) findViewById(R.id.lv_dialog);
        tieudeanh=new ArrayList<>();
        tieudeanh.add(chuoi[0]);
        tieudeanh.add(chuoi[1]);
        tieudeanh.add(chuoi[2]);
        tieudeanh.add(chuoi[3]);
        tieudeanh.add(chuoi[4]);
        tieudeanh.add(chuoi[5]);
        tieudeanh.add(chuoi[6]);
        tieudeanh.add(chuoi[7]);
        tieudeanh.add(chuoi[8]);
		/*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, tieudeanh);*/
        adt=new custom_listview(this,R.layout.custom_listview,tieudeanh);
        lv.setAdapter(adt);
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                if (position == 0) {
                    i1 = new Intent(listnguphap.this, nguphap.class);
                    i1.putExtra("trang", position);
                    i1.putExtra("title","Mạo từ");
                    startActivity(i1);
                }
                if (position == 1) {
                    i1 = new Intent(listnguphap.this, nguphap.class);
                    i1.putExtra("trang", position);
                    i1.putExtra("title", " Tính từ");
                    startActivity(i1);
                }
                if (position == 2) {
                    i1 = new Intent(listnguphap.this, nguphap.class);
                    i1.putExtra("trang", position);
                    i1.putExtra("title", " Giới từ");
                    startActivity(i1);
                }
                if (position == 3) {
                    i1 = new Intent(listnguphap.this, nguphap.class);
                    i1.putExtra("trang", position);
                    i1.putExtra("title", " Liên từ");
                    startActivity(i1);
                }

                if (position == 4) {
                    i1 = new Intent(listnguphap.this, nguphap.class);
                    i1.putExtra("trang", position);
                    i1.putExtra("title", " Mệnh đề");
                    startActivity(i1);
                }
                if (position == 5) {
                    i1 = new Intent(listnguphap.this, nguphap.class);
                    i1.putExtra("trang", position);
                    i1.putExtra("title", "So sánh ngang/ bằng nhau");
                    startActivity(i1);
                }
                if (position == 6) {
                    i1 = new Intent(listnguphap.this, nguphap.class);
                    i1.putExtra("trang", position);
                    i1.putExtra("title", "Hiện tại đơn");
                    startActivity(i1);
                }
                if (position == 7) {
                    i1 = new Intent(listnguphap.this, nguphap.class);
                    i1.putExtra("trang", position);
                    i1.putExtra("title", "Quá khứ đơn");
                    startActivity(i1);
                }
                if (position == 8) {
                    i1 = new Intent(listnguphap.this, nguphap.class);
                    i1.putExtra("trang", position);
                    i1.putExtra("title", "Tương lai đơn");
                    startActivity(i1);
                }
            }
        });
    }
}
